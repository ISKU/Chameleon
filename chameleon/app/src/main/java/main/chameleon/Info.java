package main.chameleon;

/**
 * Created by SeoYoungHak on 2016-06-26.
 */
public class Info {
    private int id;
    private String name;
    private int sound;
    private int brightness;
    private int wifi;
    private int lte;
    private int bluetooth;
    private int airplane;
    private String week;
    private double latitude;
    private double longitude;
    private long starttime;
    private long stoptime;
    private int toggle;
    private int gpsinterval;
    private int timeinterval;

    public Info(int id, String name, int sound, int brightness, int wifi, int lte, int bluetooth, int airplane, String week, double latitude, double longitude, long starttime, long stoptime, int toggle) {
        this.id = id;
        this.name = name;
        this.sound = sound;
        this.brightness = brightness;
        this.wifi = wifi;
        this.lte = lte;
        this.bluetooth = bluetooth;
        this.airplane = airplane;
        this.latitude = latitude;
        this.longitude = longitude;
        this.starttime = starttime;
        this.stoptime= stoptime;
        this.toggle = toggle;
        this.week = week;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getWeek(){return week; }
    public void setWeek(String week){this.week=week;}


    public int getSound() {
        return sound;
    }
    public void setSound(int sound) {
        this.sound = sound;
    }

    public int getBrightness() {
        return brightness;
    }
    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getWifi() {
        return wifi;
    }
    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public int getLte() {
        return lte;
    }
    public void setLte(int lte) {
        this.lte = lte;
    }

    public int getBluetooth() {
        return bluetooth;
    }
    public void setBluetooth(int bluetooth) {
        this.sound = bluetooth;
    }

    public int getAirplane() {
        return airplane;
    }
    public void setAirplane(int airplane) {
        this.airplane = airplane;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude =longitude;
    }

    public long getStarttime() {
        return starttime;
    }
    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    public long getStoptime() {
        return stoptime;
    }
    public void setStoptime(long stoptime) {
        this.stoptime = stoptime;
    }

    public int getToggle() {
        return toggle;
    }
    public void setToggle(int toggle) {
        this.toggle = toggle;
    }

    public int getGpsinterval() {
        return gpsinterval;
    }
    public void setGpsinterval(int gpsinterval) {
        this.gpsinterval = gpsinterval;
    }

    public int getTimeinterval() {
        return timeinterval;
    }
    public void setTimeinterval(int timeinterval) {
        this.timeinterval = timeinterval;
    }

    public String toString() {
        return String.format("%s", name);
    }
}
