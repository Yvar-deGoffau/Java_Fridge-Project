package projet.frigo.A3;

public interface IModelObserver {
	//It wilk crea te by itselfthe controller
	void onTempChange(String value);
	void onHumiChange(String value);
	void onRoseeChange(String value);
}
