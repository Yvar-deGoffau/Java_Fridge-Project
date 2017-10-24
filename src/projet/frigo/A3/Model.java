package projet.frigo.A3;

import java.util.List;
import java.util.ArrayList;

/**
 * This contains the representation of all Data, and all treatement that might occurs to it
 *
 */
public class Model {

	/**
	 * The controller responsable to send the Data to the View
	 */
	private Controller controller;
	
	/**
	 * The Arduino responsable of fetching all Data
	 */
	private Arduino arduino;
	/**
	 * The current Temperature
	 */
	private String temp1;
	/**
	 * The current Humidity
	 */
	private String humi1;
	/**
	 * The current Rosée Point
	 */
	private String temp2_rosee;
	/**
	 * The ordered Temperature
	 */
	private int temp_consigne = 18;
	/**
	 * A list of all the observators of this model
	 */
	private List<IModelObserver> list = new ArrayList<>();

	/**
	 * Initialize the model
	 * @param arduino The arduino to communicate with
	 */
	public Model(Arduino arduino) {

		this.arduino = arduino;
		
		// Make a new controller to suit our model
		this.controller = new Controller(this);
		
		// Register the newly generated controller for notifications by the Model
		list.add(controller);
	}

	/**
	 * This function changes the data in the model, then notify all observers that a change might have occured
	 * @param temp1 Our new Temperature
	 * @param humi1 Our new Humidity
	 * @param temp2_rosee Our new Rosée Point
	 */
	public void onValueChanges(String temp1, String humi1, String temp2_rosee) {
		// modify all data
		this.temp1 = temp1;
		this.humi1 = humi1;
		this.temp2_rosee = temp2_rosee;
		notifyChanges();
	}

	/**
	 * This function changes the ordered temperature according to the command ID
	 * @param i The command. {@code 0= decrease ; 1= increase ; other= no change}
	 * @return Our new ordered temperature
	 */
	public String onConsigneChange(int i) {

		if (i == 0) {
			this.temp_consigne--;

			return String.valueOf(temp_consigne);
		} else if (i == 1) {
			this.temp_consigne++;

			return String.valueOf(temp_consigne);
		} else {
			return String.valueOf(temp_consigne);
		}
	}

	/**
	 * Notify all observers of any changes that might have occured
	 */
	private void notifyChanges() {
		for (IModelObserver observer : list) {
			observer.onTempChange(temp1);
			// equivalent : controller.onTempChange(temp1);
			observer.onHumiChange(humi1);
			observer.onRoseeChange(temp2_rosee);
		}
	};

}
