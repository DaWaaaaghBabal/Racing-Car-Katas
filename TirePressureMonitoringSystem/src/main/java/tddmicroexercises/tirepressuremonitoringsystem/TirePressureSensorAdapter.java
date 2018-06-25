package tddmicroexercises.tirepressuremonitoringsystem;


public class TirePressureSensorAdapter implements TirePressureSensor {
	private Sensor wrappedSensor;
	public TirePressureSensorAdapter(Sensor sensor) {
		wrappedSensor = sensor;
	}
	public double nextPsiPressure() {
		return wrappedSensor.popNextPressurePsiValue();
	}
}
