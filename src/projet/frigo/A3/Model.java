package projet.frigo.A3;

import java.util.List;
import java.util.ArrayList;

public class Model {

	private Controller controller;
	private Arduino arduino;
	private String temp1;
	private String humi1;
	private String temp2_rosee;
	private int temp_consigne = 18;
	private List<IModelObserver> list = new ArrayList<>();

	public Model(Arduino arduino) {

		this.arduino = arduino;
		this.controller = new Controller(this);
		list.add(controller);
	}

	public void onValueChanges(String temp1, String humi1, String temp2_rosee) {
		// TODO Auto-generated method stub
		this.temp1 = temp1;
		this.humi1 = humi1;
		this.temp2_rosee = temp2_rosee;
		notifyChanges();
	}

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

	private void notifyChanges() {
		for (IModelObserver observer : list) {
			observer.onTempChange(temp1);
			// equivalent : controller.onTempChange(temp1);
			observer.onHumiChange(humi1);
			observer.onRoseeChange(temp2_rosee);
		}
	};

}
