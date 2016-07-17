package main.chameleon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by KMH on 2016-07-05.
 */
public class DBAdapter extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "chameleon.db";
    private static final String TABLE_NAME = "chameleon";

    private SQLiteDatabase db;

    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String WEEK = "week";
    private static final String STARTTIME = "starttime";
    private static final String STOPTIME = "stoptime";
    private static final String WIFI = "wifi";
    private static final String SOUND = "sound";
    private static final String LTE = "lte";
    private static final String BRIGHTNESS = "brightness";
    private static final String BLUETOOTH = "bluetooth";
    private static final String AIRPLANE = "airplane";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String TOGGLE = "toggle";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    ID + " integer primary key autoincrement, " +
                    NAME + " text not null, " +
                    WEEK + " text not null, " +
                    STARTTIME + " text not null, " +
                    STOPTIME + " text not null, " +
                    WIFI + " text not null, " +
                    SOUND + " text not null, " +
                    LTE + " text not null, " +
                    BRIGHTNESS + " text not null, " +
                    BLUETOOTH + " text not null, " +
                    AIRPLANE + " text not null, " +
                    LATITUDE + " text not null, " +
                    LONGITUDE + " text not null, " +
                    TOGGLE + " text not null )";

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

    // Create
    public boolean insertInfo(String name, int week, int starttime, int stoptime, int wifi, int sound, int lte, int brightness, int bluetooth, int airplane, double latitude, double longitude, int toggle) {
        ContentValues cv = new ContentValues();

        cv.put(NAME, name);
        cv.put(WEEK, week);
        cv.put(STARTTIME, starttime);
        cv.put(STOPTIME, stoptime);
        cv.put(WIFI, wifi);
        cv.put(SOUND, sound);
        cv.put(LTE, lte);
        cv.put(BRIGHTNESS, brightness);
        cv.put(BLUETOOTH, bluetooth);
        cv.put(AIRPLANE, airplane);
        cv.put(LATITUDE, latitude);
        cv.put(LONGITUDE, longitude);
        cv.put(TOGGLE, toggle);

        return db.insert(TABLE_NAME, null, cv) != -1;
    }

    // Read
    public ArrayList<Info> getAllInfo() {
        ArrayList<Info> info = new ArrayList<Info>();
        Cursor c = db.query(TABLE_NAME, new String[] {ID, NAME, WEEK, STARTTIME, STOPTIME, WIFI, SOUND, BRIGHTNESS, LTE, BLUETOOTH, AIRPLANE, LATITUDE, LONGITUDE, TOGGLE}, null, null, null, null, ID + " DESC");

        if (c.moveToFirst()) {
            final int indexId = c.getColumnIndex(ID);
            final int indexName = c.getColumnIndex(NAME);
            final int indexWeek = c.getColumnIndex(WEEK);
            final int indexStarttime = c.getColumnIndex(STARTTIME);
            final int indexStoptime = c.getColumnIndex(STOPTIME);
            final int indexWifi = c.getColumnIndex(WIFI);
            final int indexSound = c.getColumnIndex(SOUND);
            final int indexBrightness = c.getColumnIndex(BRIGHTNESS);
            final int indexLte = c.getColumnIndex(LTE);
            final int indexBluetooth = c.getColumnIndex(BLUETOOTH);
            final int indexAirplane = c.getColumnIndex(AIRPLANE);
            final int indexLatitude = c.getColumnIndex(LATITUDE);
            final int indexLongitude = c.getColumnIndex(LONGITUDE);
            final int indexToggle = c.getColumnIndex(TOGGLE);

            do {
                int id = c.getInt(indexId);
                String name = c.getString(indexName);
                int week = c.getInt(indexWeek);
                int starttime = c.getInt(indexStarttime);
                int stoptime = c.getInt(indexStoptime);
                int wifi = c.getInt(indexWifi);
                int sound = c.getInt(indexSound);
                int brightness = c.getInt(indexBrightness);
                int lte = c.getInt(indexLte);
                int bluetooth = c.getInt(indexBluetooth);
                int airplane = c.getInt(indexAirplane);
                double latitude = c.getDouble(indexLatitude);
                double longitude = c.getDouble(indexLongitude);
                int toggle = c.getInt(indexToggle);

                info.add(new Info(id, name, week, starttime, stoptime, wifi, sound, brightness, lte, bluetooth, airplane, latitude, longitude, toggle));
            } while (c.moveToNext());
        }
        c.close();

        return info;
    }

    // Update
    public boolean updateInfo(Info i) {
        ContentValues cv = new ContentValues();
        cv.put(NAME, i.getName());
        cv.put(WEEK, i.getWeek());
        cv.put(STARTTIME, i.getStarttime());
        cv.put(STOPTIME, i.getStoptime());
        cv.put(WIFI, i.getWifi());
        cv.put(SOUND, i.getSound());
        cv.put(BRIGHTNESS, i.getBrightness());
        cv.put(LTE, i.getLte());
        cv.put(BLUETOOTH, i.getBluetooth());
        cv.put(AIRPLANE, i.getAirplane());
        cv.put(LATITUDE, i.getLatitude());
        cv.put(LONGITUDE, i.getLongitude());
        cv.put(TOGGLE, i.getToggle());

        String[] params = new String[] { Integer.toString(i.getId()) };
        int result = db.update(TABLE_NAME, cv, ID + "=?", params);
        return result > 0;
    }

    // Delete
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