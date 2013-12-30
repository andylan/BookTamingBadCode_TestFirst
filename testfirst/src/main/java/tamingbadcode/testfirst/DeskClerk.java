package tamingbadcode.testfirst;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-12-27
 * Time: 下午1:02
 * To change this template use File | Settings | File Templates.
 */
public class DeskClerk {
    private HashMap<String, CityClock> cities = new HashMap<String, CityClock>();

    public void addCityClock(String cityName, CityClock cityClock) {
        this.cities.put(cityName, cityClock);
    }

    public void setLocalTimeToCityClock(int localTime, String cityName) {
        this.cities.get(cityName).setLocalTime(localTime);
        notifyAllCityClocks(this.cities.get(cityName).getUtcZeroTime(localTime));
    }

    private void notifyAllCityClocks(int utcZeroTime) {
        for (String cityName : this.cities.keySet()) {
            this.cities.get(cityName).setLocalTimeByUtcZeroTime(utcZeroTime);
        }
    }

    public CityClock getCityClock(String cityName) {
        return this.cities.get(cityName);
    }
}
