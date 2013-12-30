package tamingbadcode.testfirst;

import java.util.TimeZone;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-12-26
 * Time: 下午9:08
 * To change this template use File | Settings | File Templates.
 */
public class CityClock {
    private String cityName;
    private TimeZone timeZone;
    private int localTime;

    public CityClock(String cityName, TimeZone timeZone) {
        this.cityName = cityName;
        this.timeZone = timeZone;
    }

    public void setLocalTime(int localTime) {
        this.localTime = localTime;
    }

    public int getLocalTime() {
        return localTime;
    }

    public int getUtcZeroTime(int localTime) {
        return localTime - timeZone;
    }

    public void setLocalTimeByUtcZeroTime(int utcZeroTime) {
        this.localTime = to24HourTime(utcZeroTime + this.timeZone);
    }

    private int to24HourTime(int time) {
        return (time + 24) % 24;
    }
}
