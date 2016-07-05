package main.chameleon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

/**
 * Created by SeoYoungHak on 2016-06-26.
 */

public class EachSaveListView extends LinearLayout{
    TextView listName;
    TextView weekName;
    TextView startName;
    TextView stopName;
    ImageView wifiFunction;
    ImageView soundFunction;
    ImageView networkFunction;
    ImageView brightFunction;
    ImageView bluetoothFunction;
    ImageView airplaneFunction;
    ToggleButton toggle_selector;
    ArrayList<Info> save;
    ToggleButton toggle_save;

    public EachSaveListView(Context context) {
        super(context);
        LayoutInflater listInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        listInflater.inflate(R.layout.each_menu_list,this,true);

        listName = (TextView) findViewById(R.id.listName);
        //weekName= (TextView) findViewById(R.id.weekName);
        startName= (TextView) findViewById(R.id.startName);
        stopName= (TextView) findViewById(R.id.stopName);

        wifiFunction = (ImageView) findViewById(R.id.wifi_function);
        soundFunction= (ImageView)findViewById(R.id.sound_function);
        networkFunction= (ImageView)findViewById(R.id.network_function);
        brightFunction= (ImageView)findViewById(R.id.bright_function);
        bluetoothFunction= (ImageView)findViewById(R.id.bluetooth_function);
        airplaneFunction= (ImageView)findViewById(R.id.airplane_function);
        toggle_selector= (ToggleButton)findViewById(R.id.toggle_save);
    }

    public void setListNameText(String text){
        listName.setText("  "+text);
    }
   /* public void setWeekNameText(String text){
        weekName.setText("    "+text+" : ");
    }*/
    public void setStartNameText(String text, String week){
        int hour = Integer.parseInt(text) /3600;
        int min = Integer.parseInt(text) /60 - hour*60;
        startName.setText(hour+"시"+ min + "분 / " +week);
    }
    public void setStopNameText(String text){
        int hour = Integer.parseInt(text) /3600;
        int min = Integer.parseInt(text) /60 - hour*60;
        stopName.setText(" ~ "+hour+"시" +min+"분");
    }
    public void setWifiFunction(int text){
        if(text==1)
            wifiFunction.setImageResource(R.drawable.wifi_function);
        else
            wifiFunction.setImageResource(R.drawable.wifi_function_off);
    }
    public void setSoundFunction(int text){
        if(text==1) {
            soundFunction.setImageResource(R.drawable.sound_function);
        }else if(text==0){
            soundFunction.setImageResource(R.drawable.mute_function);
        }else{
            soundFunction.setImageResource(R.drawable.vibration_function);
        }
    }
    public void setNetworkFunction(int text){
        if(text==1)
            networkFunction.setImageResource(R.drawable.network_function);
        else
            networkFunction.setImageResource(R.drawable.network_function_off);
    }
    public void setBrightFunction(int text){
        if(text==1)
            brightFunction.setImageResource(R.drawable.bright_function);
        else if(text==0)
            brightFunction.setImageResource(R.drawable.bright_function_off);
    }
    public void setBluetoothFunction(int text){
        if(text==1)
            bluetoothFunction.setImageResource(R.drawable.bluetooth_function);
        else
            bluetoothFunction.setImageResource(R.drawable.bluetooth_function_off);
    }
    public void setAirplaneFunction(int text){
        if(text==1)
            airplaneFunction.setImageResource(R.drawable.airplane_function);
        else
            airplaneFunction.setImageResource(R.drawable.airplane_function_off);
    }
    public void setToggle(final Context context, final int position, final ArrayList<Info> save_menu) {
        if(save.get(position).getToggle() == 1)
            toggle_save.setChecked(true);
        else
            toggle_save.setChecked(false);

        toggle_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (toggle_save.isChecked()) {
                    save.get(position).setToggle(1);
                } else {
                    save.get(position).setToggle(0);
                }
            }
        });
    }

}

