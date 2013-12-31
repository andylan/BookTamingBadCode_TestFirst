package tamingbadcode.testfirst;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * User: Ben
 * Date: 13-12-26
 * Time: 下午9:08
 */
public class CityClock {
    private TimeZone timeZone;
    private Calendar localTime;

    public CityClock(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setLocalTime(Calendar localTime) {
        this.localTime = localTime;
    }

    public Calendar getLocalTime() {
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
}
