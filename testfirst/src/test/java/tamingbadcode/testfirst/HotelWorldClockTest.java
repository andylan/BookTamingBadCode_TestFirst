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
        Calendar timeBeijing = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        timeBeijing.set(2013, Calendar.DECEMBER, 30, 9, 0, 0);

        Calendar timeLondon = Calendar.getInstance(TimeZone.getTimeZone("GMT+0"));
        timeLondon.set(2013, Calendar.DECEMBER, 30, 1, 0, 0);

        Calendar timeMoscow = Calendar.getInstance(TimeZone.getTimeZone("GMT+4"));
        timeMoscow.set(2013, Calendar.DECEMBER, 30, 5, 0, 0);

        Calendar timeSydney = Calendar.getInstance(TimeZone.getTimeZone("GMT+10"));
        timeSydney.set(2013, Calendar.DECEMBER, 30, 11, 0, 0);

        Calendar timeNewYork = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
        timeNewYork.set(2013, Calendar.DECEMBER, 29, 20, 0, 0);

        // When
        deskClerk.setLocalTimeToCityClock(timeBeijing.getTime(), "Beijing");

        // Then
        assertEquals("Failure - the local time of Beijing should be 9"
                , timeBeijing.getTime()
                , deskClerk.getCityClock("Beijing").getLocalTime());
        assertEquals("Failure - the local time of London should be 1"
                , timeLondon, deskClerk.getCityClock("London").getLocalTime());
        assertEquals("Failure - the local time of Moscow should be 5"
                , timeMoscow, deskClerk.getCityClock("Moscow").getLocalTime());
        assertEquals("Failure - the local time of Sydney should be 11"
                , timeSydney, deskClerk.getCityClock("Sydney").getLocalTime());
        assertEquals("Failure - the local time of New York should be 20"
                , timeNewYork, deskClerk.getCityClock("NewYork").getLocalTime());
    }

}
