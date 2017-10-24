package projet.frigo.A3;

/**
 * The interface of any controller observing the Model
 * 
 */
public interface IModelObserver {
	/**
	 * Gets executed to notify of a change in temperature
	 * @param value The new value for the temperature
	 */
	void onTempChange(String value);
	/**
	 * Gets executed to notify of a change in humidity
	 * @param value The new value for the humidity
	 */
	void onHumiChange(String value);
	/**
	 * Gets executed to notify of a change in the Rosée point
	 * @param value The new value for the Rosée point
	 */
	void onRoseeChange(String value);
}
