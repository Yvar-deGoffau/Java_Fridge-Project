package projet.frigo.A3;

/**
 * This class sends the data from the Model to the View
 *
 */
public class Controller implements IModelObserver {
	/**
	 * A reference to our current Model
	 */
	private Model model;
	
	/**
	 * The View to use for the Interface
	 */
	private View view;

	/**
	 * This class sends the data from the Model to a newly instanciated View
	 * @param model The model to observe
	 */
	public Controller(Model model) {
		// Loads the Model
		this.model = model;
		
		// Creates a new View
		this.view = new View(this);

		// Makes the view render
		view.setVisible(true);
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public void onTempChange(String value) {
		view.fieldTemperature.setText(value);
		
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public void onHumiChange(String value) {
		view.fieldHumidity.setText(value);
		
	}

	/**
	 * Gets executed to notify of a change in the consigne
	 * @param i The change command. {@code 0= decrease ; 1= increase ; other= no change}
	 * @return The new value for our consigne
	 */
	public String onConsigneChange(int i) {
		return model.onConsigneChange(i);		
	}
	
	

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public void onRoseeChange(String value) {
		view.fieldPoint_rosee.setText(value);
		
	}
}
