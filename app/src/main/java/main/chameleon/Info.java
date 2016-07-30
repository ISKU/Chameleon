package main.chameleon;

/**
 * Created by KMH on 2016-07-05.
 */
public class Info {
    private int id;
    private String name;
    private int week;
    private int starttime;
    private int stoptime;
    private int wifi;
    private int sound;
    private int brightness;
    private int lte;
    private int bluetooth;
    private int airplane;
    private double latitude;
    private double longitude;
    private int toggle;

    public Info() {
        //
    }

    public Info(int id, String name, int week, int starttime, int stoptime, int wifi, int sound, int brightness, int lte, int bluetooth, int airplane, double latitude, double longitude, int toggle) {
        this.id = id;
        this.name = name;
        this.week = week;
        this.starttime = starttime;
        this.stoptime= stoptime;
        this.wifi = wifi;
        this.sound = sound;
        this.brightness = brightness;
        this.lte = lte;
        this.bluetooth = bluetooth;
        this.airplane = airplane;
        this.latitude = latitude;
        this.longitude = longitude;
        this.toggle = toggle;
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

    public int getWeek() {
        return week;
    }
    public void setWeek(int week) {
        this.week = week;
    }

    public int getStarttime() {
        return starttime;
    }
    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }

    public int getStoptime() {
        return stoptime;
    }
    public void setStoptime(int stoptime) {
        this.stoptime = stoptime;
    }

    public int getWifi() {
        return wifi;
    }
    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

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
        this.bluetooth = bluetooth;
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

    public int getToggle() {
        return toggle;
    }
    public void setToggle(int toggle) {
        this.toggle = toggle;
    }

    public String toString() {
        return String.format("%s", name);
    }

    public int testInt() { return 100; }
}