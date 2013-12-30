package tamingbadcode.testfirst;

import java.util.Calendar;
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
    private Calendar localTime;

    public CityClock(String cityName, TimeZone timeZone) {
        this.cityName = cityName;
        this.timeZone = timeZone;
    }

    public void setLocalTime(Calendar localTime) {
        this.localTime = localTime;
    }

    public int getLocalTime() {
        return localTime;
    }

    public long getUtcZeroTime(Calendar localTime) {
        return localTime.getTimeInMillis();
    }

    public void setLocalTimeByUtcZeroTime(long utcZeroTime) {
        Calendar time = Calendar.getInstance(this.timeZone);
        time.setTimeInMillis(utcZeroTime);
        this.localTime = time;
    }

    private int to24HourTime(int time) {
        return (time + 24) % 24;
    }
}
