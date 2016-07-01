package main.chameleon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    Button toSaveListButton;
    Button toModeListButton;
    Intent aIntent;

    ListView listView;
    ScrollView scrollView;

    private ArrayList<Info> save_menu ;

    static double longitude;
    static double latitude;
    static long starttime;
    static long stoptime;

    final String[] weekList = {"월","화","수","목","금","토","일"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save_menu = new ArrayList<Info>();
        scrollView = (ScrollView) findViewById(R.id.scroll_view);
        listView = (ListView) findViewById(R.id.showModeListView);
        save_menu.add(new Info(1, "서영학", 1, 1, 0, 1, 0, 1, weekList[1], 32, 32, 1234, 123, 1));
        save_menu.add(new Info(1, "서영학", 0, 1, 0, 0, 0, 1, weekList[3], 32, 32, 1234, 123, 1));
        save_menu.add(new Info(1, "서영학", 1, 1, 1, 1, 1, 1, weekList[3], 32, 32, 1234, 123, 1));
        save_menu.add(new Info(1, "서영학", 1, 1, 1, 1, 1, 1, weekList[3], 32, 32, 1234, 123, 1));
        save_menu.add(new Info(1, "서영학", 0, 0, 0, 0, 0, 0, weekList[3], 32, 32, 1234, 123, 1));

        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                scrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        myAdapter adapter = new myAdapter();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("position_save", position);
                startActivity(intent);
            }
        });


        toModeListButton = (Button) findViewById(R.id.toModeListButton);
        toModeListButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                aIntent = new Intent(MainActivity.this, ModeActivity.class);
                startActivity(aIntent);
            }
        });


    }



    private class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return save_menu.size();
        }
        @Override
        public Object getItem(int position) {
            return save_menu.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            EachSaveListView view = new EachSaveListView(getApplicationContext());
            view.setListNameText(save_menu.get(position).getName());
            view.setWeekNameText(save_menu.get(position).getWeek());
            view.setStartNameText(save_menu.get(position).getStarttime() + "");
            view.setStopNameText(save_menu.get(position).getStoptime() + "");

            view.setBrightFunction(save_menu.get(position).getBrightness());
            view.setWifiFunction(save_menu.get(position).getWifi());
            view.setBluetoothFunction(save_menu.get(position).getBluetooth());
            view.setNetworkFunction(save_menu.get(position).getLte());
            view.setAirplaneFunction(save_menu.get(position).getAirplane());
            view.setSoundFunction(save_menu.get(position).getSound());

            return view;
            //  public Info(int id, String name, int sound, int brightness, int wifi, int lte, int bluetooth, int airplane, String week, double latitude, double longitude, long starttime, long stoptime, int toggle) {

        }
    }
}