package tamingbadcode.testfirst;

import java.util.Calendar;
import java.util.HashMap;

/**
 * User: Ben
 * Date: 13-12-27
 * Time: 下午1:02
 */
public class ClockTimeManager {
    private HashMap<String, CityClock> cities = new HashMap<String, CityClock>();

    public void addCityClock(String cityName, CityClock cityClock) {
        this.cities.put(cityName, cityClock);
    }

    public void setLocalTimeToCityClock(Calendar localTime, String cityName) {
        this.cities.get(cityName).setLocalTime(localTime);
        notifyAllCityClocks(this.cities.get(cityName).getUtcZeroTime(localTime));
    }

    private void notifyAllCityClocks(long utcZeroTime) {
        for (String cityName : this.cities.keySet()) {
            this.cities.get(cityName).setLocalTimeByUtcZeroTime(utcZeroTime);
        }
    }

    public CityClock getCityClock(String cityName) {
        return this.cities.get(cityName);
    }
}
