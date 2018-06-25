package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.*;
import static org.junit.Assert.*;

public class TestAlarm {

	private Alarm alarm;
	private double nextPressureValue;
	private TirePressureSensor sensor;
	
	@Before
	public void setUp() {
		sensor = () -> nextPressureValue;
		alarm = new Alarm(sensor);
	}
	
    @Test
    public void testWithDefaultValue() {
        assertEquals(false, alarm.isAlarmOn());
    }
    
    @Test
    public void testWithOkValue() {
    	double ordinaryValue = 18;
    	nextPressureValue = ordinaryValue;
    	alarm.check();
    	assertFalse(alarm.isAlarmOn());
    }
    
    @Test
    public void testWithTooLowValue() {
    	double tooLowValue = 16;
    	nextPressureValue = tooLowValue;
    	alarm.check();
    	assertTrue(alarm.isAlarmOn());
    }
    
    @Test
    public void testWithTooHighValue() {
    	double tooHighValue = 22;
    	nextPressureValue = tooHighValue;
    	alarm.check();
    	assertTrue(alarm.isAlarmOn());
    }
    
    @Test
    public void testWithValidHighLimitValue() {
    	double highLimitValue = 20.99;
    	nextPressureValue = highLimitValue;
    	alarm.check();
    	assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void testWithValidLowLimitValue() {
    	double lowLimitValue = 17.01;
    	nextPressureValue = lowLimitValue;
    	alarm.check();
    	assertFalse(alarm.isAlarmOn());
    }
    
    @Test
    public void testWithInvalidHighLimitValue() {
    	double highLimitValue = 21.01;
    	nextPressureValue = highLimitValue;
    	alarm.check();
    	assertTrue(alarm.isAlarmOn());
    }
    
    @Test
    public void testWithInvalidLowLimitValue() {
    	double lowLimitValue = 16.99;
    	nextPressureValue = lowLimitValue;
    	alarm.check();
    	assertTrue(alarm.isAlarmOn());
    }
}
