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
        if ("Beijing".equals(cityName)) {
            this.cities.get("London").setLocalTime(1);
            this.cities.get("Moscow").setLocalTime(5);
            this.cities.get("Sydney").setLocalTime(11);
            this.cities.get("NewYork").setLocalTime(20);
        }
        if ("London".equals(cityName)) {
            this.cities.get("Beijing").setLocalTime(13);
            this.cities.get("Moscow").setLocalTime(9);
            this.cities.get("Sydney").setLocalTime(15);
            this.cities.get("NewYork").setLocalTime(0);
        }
    }

    public CityClock getCityClock(String cityName) {
        return this.cities.get(cityName);
    }
}
