package tamingbadcode.testfirst;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-12-26
 * Time: 下午9:08
 * To change this template use File | Settings | File Templates.
 */
public class CityClock {
    private int utcOffset;
    private int localTime;

    public CityClock(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public void setLocalTime(int localTime) {
        this.localTime = localTime;
    }

    public int getLocalTime() {
        return localTime;
    }

    public int getUtcZeroTime(int localTime) {
        return localTime - utcOffset;
    }

    public void setLocalTimeByUtcZeroTime(int utcZeroTime) {
        this.localTime = utcZeroTime + this.utcOffset;
    }
}
