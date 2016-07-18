package main.chameleon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        startActivity(new Intent(this,SplashActivity.class));   // Splash
        setContentView(R.layout.activity_main);

        save_menu = new ArrayList<Info>();
        //scrollView = (ScrollView) findViewById(R.id.scroll_view);
        listView = (ListView) findViewById(R.id.showModeListView);
        save_menu.add(new Info(1, "서영학 김민호", 1, 34444, 77777, 1, 0, 1, 1, 1, 1, 1234, 123, 1));
        save_menu.add(new Info(1, "공대 5호관", 1, 33244, 77777, 1, 1, 0, 1, 1, 1, 1234, 123, 1));
        save_menu.add(new Info(1, "서영학 김민호", 1, 11144, 77731, 5, 0, 1, 1, 1, 1, 1234, 123, 1));
        save_menu.add(new Info(1, "서영학 김민호", 1, 44444, 77722, 1, 0, 1, 1, 1, 1, 1234, 123, 1));
        save_menu.add(new Info(1, "서영학 김민호", 1, 22, 44777, 1, 0, 1, 1, 1, 1, 1234, 123, 1));

        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //scrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        View header = getLayoutInflater().inflate(R.layout.each_list_header,null,false);
        listView.addHeaderView(header);
        myAdapter adapter = new myAdapter();
        listView.setAdapter(adapter);
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
            view.setStartNameText(save_menu.get(position).getStarttime() + "",weekList[save_menu.get(position).getWeek()]);
            view.setStopNameText(save_menu.get(position).getStoptime() + "");
            view.setBrightFunction(save_menu.get(position).getBrightness());
            view.setWifiFunction(save_menu.get(position).getWifi());
            view.setBluetoothFunction(save_menu.get(position).getBluetooth());
            view.setNetworkFunction(save_menu.get(position).getLte());
            view.setAirplaneFunction(save_menu.get(position).getAirplane());
            view.setSoundFunction(save_menu.get(position).getSound());
            return view;
        }
    }

    public void moveListSetting(View v){
        if(v.getId() == R.id.listToSettingButton){
            Intent intent_setListWindow = new Intent(this, SettingDataActivity.class);
            startActivity(intent_setListWindow);
        }
    }
}