package projet.frigo.A3;

public class Controller implements IModelObserver {
	private Model model;
	private View view;

	public Controller(Model model) {
		
		this.model = model;
		this.view = new View(this);

		view.setVisible(true);
	}

	@Override
	public void onTempChange(String value) {
		view.fieldTemperature.setText(value);
		
	}

	@Override
	public void onHumiChange(String value) {
		view.fieldHumidity.setText(value);
		
	}

	public String onConsigneChange(int i) {
		return model.onConsigneChange(i);		
	}
	
	

	@Override
	public void onRoseeChange(String value) {
		view.fieldPoint_rosee.setText(value);
		
	}
}
