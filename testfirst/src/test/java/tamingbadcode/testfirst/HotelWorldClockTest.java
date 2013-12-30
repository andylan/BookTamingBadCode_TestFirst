package tamingbadcode.testfirst;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;
import java.util.TimeZone;

import static junit.framework.TestCase.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-12-26
 * Time: 下午6:30
 * To change this template use File | Settings | File Templates.
 */
@RunWith(JUnit4.class)
public class HotelWorldClockTest {

    private DeskClerk deskClerk = new DeskClerk();

    @Before
    public void initialization() {
        // Given
        deskClerk.addCityClock("Beijing", new CityClock("Beijing", TimeZone.getTimeZone("GMT+8")));
        deskClerk.addCityClock("London", new CityClock("London", TimeZone.getTimeZone("GMT+0")));
        deskClerk.addCityClock("Moscow", new CityClock("Moscow", TimeZone.getTimeZone("GMT+4")));
        deskClerk.addCityClock("Sydney", new CityClock("Sydney", TimeZone.getTimeZone("GMT+10")));
        deskClerk.addCityClock("NewYork", new CityClock("NewYork", TimeZone.getTimeZone("GMT-5")));
    }

    @Test
    public void WHEN_BeijingIsSetToNineOclock() {
        // Given
        Calendar time = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        time.set(2013, Calendar.DECEMBER, 30, 9, 0, 0);

        // When
        deskClerk.setLocalTimeToCityClock(time, "Beijing");

        // Then
        assertEquals("Failure - the local time of Beijing should be 9"
                , 9
                , deskClerk.getCityClock("Beijing").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of London should be 1"
                , 1, deskClerk.getCityClock("London").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Moscow should be 5"
                , 5, deskClerk.getCityClock("Moscow").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Sydney should be 11"
                , 11, deskClerk.getCityClock("Sydney").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of New York should be 20"
                , 20, deskClerk.getCityClock("NewYork").getLocalTime().get(Calendar.HOUR_OF_DAY));
    }

    @Test
    public void WHEN_LondonIsSetToFiveOclock() {
        // Given
        Calendar time = Calendar.getInstance(TimeZone.getTimeZone("GMT+0"));
        time.set(2013, Calendar.DECEMBER, 30, 5, 0, 0);

        // When
        deskClerk.setLocalTimeToCityClock(time, "London");

        // Then
        assertEquals("Failure - the local time of Beijing should be 13"
                , 13
                , deskClerk.getCityClock("Beijing").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of London should be 5"
                , 5, deskClerk.getCityClock("London").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Moscow should be 9"
                , 9, deskClerk.getCityClock("Moscow").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Sydney should be 15"
                , 15, deskClerk.getCityClock("Sydney").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of New York should be 0"
                , 0, deskClerk.getCityClock("NewYork").getLocalTime().get(Calendar.HOUR_OF_DAY));
    }

    @Test
    public void WHEN_MoscowIsSetToZeroOclock() {
        // Given
        Calendar time = Calendar.getInstance(TimeZone.getTimeZone("GMT+4"));
        time.set(2013, Calendar.DECEMBER, 30, 0, 0, 0);

        // When
        deskClerk.setLocalTimeToCityClock(time, "Moscow");

        // Then
        assertEquals("Failure - the local time of Beijing should be 4"
                , 4
                , deskClerk.getCityClock("Beijing").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of London should be 20"
                , 20, deskClerk.getCityClock("London").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Moscow should be 0"
                , 0, deskClerk.getCityClock("Moscow").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of Sydney should be 6"
                , 6, deskClerk.getCityClock("Sydney").getLocalTime().get(Calendar.HOUR_OF_DAY));
        assertEquals("Failure - the local time of New York should be 15"
                , 15, deskClerk.getCityClock("NewYork").getLocalTime().get(Calendar.HOUR_OF_DAY));
    }

}
