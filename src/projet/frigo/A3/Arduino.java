package projet.frigo.A3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;

/**
 * The class used to connect to the Arduino
 * <p>
 * This class is used to connect to the Arduino. 
 * It implements SerialPortEventListener to register as a dispatcher,
 *  and then on each serialEvent it dispatch the data and sends it to the Model.
 *
 */
public class Arduino implements SerialPortEventListener {
    /** 
     * The port we're going to use. 
     */
    SerialPort serialPort;

    /** 
     * Port names to test for the Arduino under different OS
     */
    private static final String PORT_NAMES[] = {
            "/dev/tty.usbserial-A9007UX1", // Mac OS X
            "/dev/ttyACM0", // Raspberry Pi
            "/dev/ttyUSB0", // Linux
            "COM3", // Windows
    };
    
    /**
     * A BufferedReader which will be fed by a InputStreamReader
     * converting the bytes into characters and
     * making the displayed results codepage independent
     */
    private BufferedReader input;
    
    /** 
     * The output stream to the port
     */
    private OutputStream output;
    
    /**
     * A reference to the Model to send data to
     */
	private Model model;
	
    /**
     *  Milliseconds to block while waiting for the port to open
     */
    private static final int TIME_OUT = 2000;
    
    /** 
     * Default bits per second rate for COM port. 
     * Should be the same as under the Arduino 
     */
    private static final int DATA_RATE = 9600;
    
    
    public Arduino() {
    	// Initialize the Model
    this.model = new Model(this);
    
    }

    /**
     * Search for the port, connect to it, and add Event Listeners for the dispatch loop
     */
    public void initialize() {
        // the next line is for Raspberry Pi and
        // gets us into the while loop and was suggested here was suggested http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
        // System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        //Todo: Start the Simulator here
        if (portId == null) {
            System.out.println("Error: Could not find COM port. Please plug in the Arduino Board");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * This should be called when you stop using the port.
     * This will prevent port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Handle an event on the serial port. Read the data and interpret it.
     * <p>
     * The Arduino sends the data under the following format:
     * <p>
     * {@code < Temperature > ; < Humidit� > ; < Point de Ros�e > \n}
     * <p>
     * This function read that from the event, dispatch it, and sends it to the Model.
     * 
     * @param oEvent Event data. See gnu.io.SerialPortEvent
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
            	//Boucle qui r�cup�re les donn�es depuis l'arduino
                String inputLine=input.readLine();
                String string = inputLine;
                //S�pare les differents parties
                String[] parts = string.split(";");
                String temp1 = parts[0]; // 27�C
                String humi1 = parts[1]; // 53 %
                String temp2_rosee = parts[2]; // 13�
                /*Display using for debugging:
                System.out.print("Temperature :" + temp1);
                System.out.print(" / Humidit� :" + humi1);
                System.out.println(" / Ros�e :" + temp2_rosee);
                */
                
                //Sending Data to Model at every loop
                model.onValueChanges(temp1, humi1, temp2_rosee);
          
                
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }


}
