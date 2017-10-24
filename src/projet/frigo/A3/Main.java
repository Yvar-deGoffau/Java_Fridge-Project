package projet.frigo.A3;

import java.awt.EventQueue;

/**
 * The main class
 * <p>
 * Initialize the Arduino; and then start the program
 */
public class Main {
	/**
	 * Initialize the Arduino; and then start the program
	 * @param args The program arguments. Not used...
	 * @throws Exception Any exception that might occur
	 */
    public static void main(String[] args) throws Exception {
        
					//Calling View
					Arduino arduino = new Arduino();
					
					arduino.initialize();
    }
}
