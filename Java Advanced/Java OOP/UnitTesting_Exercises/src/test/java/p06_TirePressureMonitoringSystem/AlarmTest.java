package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {
    @Test
    public void alarmShoudBeOnIfOutOfRangeLower(){
        Alarm alarm=new Alarm();
        Sensor sensor=Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
        Assert.assertEquals(false,alarm.getAlarmOn());
    }
    @Test
    public void alarmShoudBeOnIfOutOfRangeUpper(){
        Alarm alarm=new Alarm();
        Sensor sensor=Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(33.0);
        Assert.assertEquals(false,alarm.getAlarmOn());
    }

}