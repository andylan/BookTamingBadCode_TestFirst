package tamingbadcode.testfirst;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;
import java.util.TimeZone;

import static junit.framework.TestCase.assertEquals;

/**
 * User: Ben
 * Date: 13-12-26
 * Time: 下午6:30
 */
@RunWith(JUnit4.class)
public class HotelWorldClockTest {

    private ClockTimeManager clockTimeManager = new ClockTimeManager();

    @Before
    public void initialization() {
        // Given
        clockTimeManager.addCityClock("Beijing", new CityClock(TimeZone.getTimeZone("GMT+8")));
        clockTimeManager.addCityClock("London", new CityClock(TimeZone.getTimeZone("GMT+0")));
        clockTimeManager.addCityClock("Moscow", new CityClock(TimeZone.getTimeZone("GMT+4")));
        clockTimeManager.addCityClock("Sydney", new CityClock(TimeZone.getTimeZone("GMT+10")));
        clockTimeManager.addCityClock("NewYork", new CityClock(TimeZone.getTimeZone("GMT-5")));
        clockTimeManager.addCityClock("SanFrancisco", new CityClock(TimeZone.getTimeZone("GMT-8")));
    }

    @Test
    public void WHEN_BeijingIsSetToNineOclock() {
        // Given
        Calendar time = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        time.set(2013, Calendar.DECEMBER, 30, 9, 0, 0);

        // When
        clockTimeManager.setLocalTimeToCityClock(time, "Beijing");

        // Then
        assertEquals("Failure - the local time of Beijing should be 9"
                , 9
                , clockTimeManager.getCityClock("Beijing").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of London should be 1"
                , 1, clockTimeManager.getCityClock("London").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Moscow should be 5"
                , 5, clockTimeManager.getCityClock("Moscow").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Sydney should be 11"
                , 11, clockTimeManager.getCityClock("Sydney").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of New York should be 20"
                , 20, clockTimeManager.getCityClock("NewYork").getLocalTime().get(Calendar.HOUR_OF_DAY));
    }

    @Test
    public void WHEN_LondonIsSetToFiveOclock() {
        // Given
        Calendar time = Calendar.getInstance(TimeZone.getTimeZone("GMT+0"));
        time.set(2013, Calendar.DECEMBER, 30, 5, 0, 0);

        // When
        clockTimeManager.setLocalTimeToCityClock(time, "London");

        // Then
        assertEquals("Failure - the local time of Beijing should be 13"
                , 13
                , clockTimeManager.getCityClock("Beijing").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of London should be 5"
                , 5, clockTimeManager.getCityClock("London").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Moscow should be 9"
                , 9, clockTimeManager.getCityClock("Moscow").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Sydney should be 15"
                , 15, clockTimeManager.getCityClock("Sydney").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of New York should be 0"
                , 0, clockTimeManager.getCityClock("NewYork").getLocalTime().get(Calendar.HOUR_OF_DAY));
    }

    @Test
    public void WHEN_MoscowIsSetToZeroOclock() {
        // Given
        Calendar time = Calendar.getInstance(TimeZone.getTimeZone("GMT+4"));
        time.set(2013, Calendar.DECEMBER, 30, 0, 0, 0);

        // When
        clockTimeManager.setLocalTimeToCityClock(time, "Moscow");

        // Then
        assertEquals("Failure - the local time of Beijing should be 4"
                , 4
                , clockTimeManager.getCityClock("Beijing").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of London should be 20"
                , 20, clockTimeManager.getCityClock("London").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Moscow should be 0"
                , 0, clockTimeManager.getCityClock("Moscow").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Sydney should be 6"
                , 6, clockTimeManager.getCityClock("Sydney").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of New York should be 15"
                , 15, clockTimeManager.getCityClock("NewYork").getLocalTime().get(Calendar.HOUR_OF_DAY));
    }

    @Test
    public void WHEN_SanFranciscoIsSetToEighteenOclock() {
        // Given
        Calendar time = Calendar.getInstance(TimeZone.getTimeZone("GMT-8"));
        time.set(2013, Calendar.DECEMBER, 30, 18, 0, 0);

        // When
        clockTimeManager.setLocalTimeToCityClock(time, "SanFrancisco");

        // Then
        assertEquals("Failure - the local time of Beijing should be 10"
                , 10
                , clockTimeManager.getCityClock("Beijing").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of London should be 2"
                , 2, clockTimeManager.getCityClock("London").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Moscow should be 6"
                , 6, clockTimeManager.getCityClock("Moscow").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Sydney should be 12"
                , 12, clockTimeManager.getCityClock("Sydney").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of New York should be 21"
                , 21, clockTimeManager.getCityClock("NewYork").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of San Francisco should be 18"
                , 18, clockTimeManager.getCityClock("SanFrancisco").getLocalTime().get(Calendar.HOUR_OF_DAY));
    }

}
