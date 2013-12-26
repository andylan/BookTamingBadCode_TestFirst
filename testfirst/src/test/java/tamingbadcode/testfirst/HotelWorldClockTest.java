package tamingbadcode.testfirst;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-12-26
 * Time: 下午6:30
 * To change this template use File | Settings | File Templates.
 */
@RunWith(JUnit4.class)
public class HotelWorldClockTest {
    @Test
    public void WHEN_BeijingIsSetToNineOclock() {
        // Given
        CityClock beijingClock = new BeijingClock(8);
        CityClock londonClock = new LondonClock(0);
        CityClock moscowClock = new MoscowClock(4);
        CityClock sydneyClock = new SydneyClock(10);
        CityClock newYorkClock = new NewYorkClock(-5);

        // When
        beijingClock.setLocalTime(9);

        // Then
        assertEquals("Failure - the local time of London should be 1", 1, londonClock.getLocalTime());
    }
}
