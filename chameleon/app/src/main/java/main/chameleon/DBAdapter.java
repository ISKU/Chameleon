package main.chameleon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by SeoYoungHak on 2016-06-26.
 */
public class DBAdapter extends SQLiteOpenHelper{
    private static final String DB_NAME = "chameleon.db";
    private static final int VERSION = 1;
    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String SOUND = "sound";
    private static final String BRIGHTNESS = "brightness";
    private static final String WIFI = "wifi";
    private static final String LTE = "lte";
    private static final String BLUETOOTH = "bluetooth";
    private static final String AIRPLANE = "airplane";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String STARTTIME = "starttime";
    private static final String STOPTIME = "stoptime";
    private static final String TOGGLE = "toggle";
    private static final String GPSINTERVAL = "gpsinterval";
    private static final String TIMEINTERVAL = "timeinterval";
    private static final String WEEK = "week";
    private static final String TABLE_NAME = "chameleon";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    ID + " integer primary key autoincrement, " +
                    NAME + " text not null, " +
                    SOUND + " text not null, " +
                    BRIGHTNESS + " text not null, " +
                    WIFI + " text not null, " +
                    LTE + " text not null, " +
                    BLUETOOTH + " text not null, " +
                    AIRPLANE + " text not null, " +
                    WEEK + " text not null, " +
                    LATITUDE + " text not null, " +
                    LONGITUDE + " text not null, " +
                    STARTTIME + " text not null, " +
                    STOPTIME + " text not null, " +
                    TOGGLE + " text not null, " +
                    GPSINTERVAL + " text not null, " +
                    TIMEINTERVAL + " text not null )";


    private SQLiteDatabase db;

    public DBAdapter(Context context) {
        super(context, DB_NAME, null, VERSION);
        db = this.getWritableDatabase();
    }



    @Override
    public synchronized void close() {
        db.close();
        super.close();
    }

    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // create
    public boolean insertInfo(String name, int sound, int brightness, int wifi, int lte, int bluetooth, int airplane, String week,double latitude, double longitude, long starttime, long stoptime, int toggle, int gpsinterval, int timeinterval) {
        ContentValues cv = new ContentValues();

        cv.put(NAME, name);
        cv.put(SOUND, sound);
        cv.put(BRIGHTNESS, brightness);
        cv.put(WIFI, wifi);
        cv.put(LTE, lte);
        cv.put(BLUETOOTH, bluetooth);
        cv.put(AIRPLANE, airplane);
        cv.put(WEEK,week);
        cv.put(LATITUDE, latitude);
        cv.put(LONGITUDE, longitude);
        cv.put(STARTTIME, starttime);
        cv.put(STOPTIME, stoptime);
        cv.put(TOGGLE, toggle);
        cv.put(GPSINTERVAL, gpsinterval);
        cv.put(TIMEINTERVAL, timeinterval);

        return db.insert(TABLE_NAME, null, cv) != -1;
    }

    // read
    public ArrayList<Info> getAllInfo() {
        ArrayList<Info> info = new ArrayList<Info>();
        Cursor c = db.query(TABLE_NAME, new String[] {ID, NAME, SOUND, BRIGHTNESS, WIFI, LTE, BLUETOOTH, AIRPLANE, LATITUDE, LONGITUDE, STARTTIME, STOPTIME, TOGGLE, GPSINTERVAL, TIMEINTERVAL}, null, null, null, null, ID + " DESC");

        if (c.moveToFirst()) {
            final int indexId = c.getColumnIndex(ID);
            final int indexName = c.getColumnIndex(NAME);
            final int indexSound = c.getColumnIndex(SOUND);
            final int indexBrightness = c.getColumnIndex(BRIGHTNESS);
            final int indexWifi = c.getColumnIndex(WIFI);
            final int indexLte = c.getColumnIndex(LTE);
            final int indexBluetooth = c.getColumnIndex(BLUETOOTH);
            final int indexAirplane = c.getColumnIndex(AIRPLANE);
            final int indexLatitude = c.getColumnIndex(LATITUDE);
            final int indexLongitude = c.getColumnIndex(LONGITUDE);
            final int indexStarttime = c.getColumnIndex(STARTTIME);
            final int indexStoptime = c.getColumnIndex(STOPTIME);
            final int indexToggle = c.getColumnIndex(TOGGLE);
            final int indexGpsinterval = c.getColumnIndex(GPSINTERVAL);
            final int indexTimeinterval = c.getColumnIndex(TIMEINTERVAL);
            final int indexWeek = c.getColumnIndex(WEEK);

            do {
                int id = c.getInt(indexId);
                String name = c.getString(indexName);
                int sound = c.getInt(indexSound);
                int brightness = c.getInt(indexBrightness);
                int wifi = c.getInt(indexWifi);
                int lte = c.getInt(indexLte);
                int bluetooth = c.getInt(indexBluetooth);
                int airplane = c.getInt(indexAirplane);
                String week = c.getString(indexWeek);
                double latitude = c.getDouble(indexLatitude);
                double longitude = c.getDouble(indexLongitude);
                long starttime = c.getLong(indexStarttime);
                long stoptime = c.getLong(indexStoptime);
                int toggle = c.getInt(indexToggle);
                int gpsinterval = c.getInt(indexGpsinterval);
                int timeinterval = c.getInt(indexTimeinterval);

                info.add(new Info(id, name, sound, brightness, wifi, lte, bluetooth, airplane, week, latitude, longitude, starttime, stoptime, toggle) );
            } while (c.moveToNext());
        }
        c.close();

        return info;
    }

    // update
    public boolean updateInfo(Info i) {
        ContentValues cv = new ContentValues();
        cv.put(NAME, i.getName());
        cv.put(SOUND, i.getSound());
        cv.put(BRIGHTNESS, i.getBrightness());
        cv.put(WIFI, i.getWifi());
        cv.put(LTE, i.getLte());
        cv.put(BLUETOOTH, i.getBluetooth());
        cv.put(AIRPLANE, i.getAirplane());
        cv.put(LATITUDE, i.getLatitude());
        cv.put(LONGITUDE, i.getLongitude());
        cv.put(STARTTIME, i.getStarttime());
        cv.put(STOPTIME, i.getStoptime());
        cv.put(TOGGLE, i.getToggle());
        cv.put(GPSINTERVAL, i.getGpsinterval());
        cv.put(TIMEINTERVAL, i.getTimeinterval());
        String[] params = new String[] { Integer.toString(i.getId()) };
        int result = db.update(TABLE_NAME, cv, ID + "=?", params);
        return result > 0;
    }

    // delete
    public boolean deleteInfo(int id) {
        String[] params = new String[] { Integer.toString(id) };
        int result = db.delete(TABLE_NAME, ID + "=?", params);
        return result > 0;
    }

    public boolean deleteAll() {
        int result=db.delete(TABLE_NAME, null, null);
        return result > 0;
    }
}
