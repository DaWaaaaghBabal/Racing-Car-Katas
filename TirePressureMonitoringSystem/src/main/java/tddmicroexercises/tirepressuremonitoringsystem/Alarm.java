package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    TirePressureSensor sensor;

    boolean alarmOn = false;
    
    public Alarm() {
    	this.sensor = new TirePressureSensorAdapter(new Sensor());
    }
    public Alarm(TirePressureSensor sensor) {
    	
    	this.sensor = sensor;
    }
    
    public void check() {
        double psiPressureValue = sensor.nextPsiPressure();

        if (isOutOfAcceptableRange(psiPressureValue))
        {
            alarmOn = true;
        }
    }
	private boolean isOutOfAcceptableRange(double psiPressureValue) {
		if (psiPressureValue < LowPressureThreshold) { return true; }
		if (psiPressureValue > HighPressureThreshold) { return true; }
		return false;
	}

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
