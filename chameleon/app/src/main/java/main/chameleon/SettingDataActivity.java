package main.chameleon;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.fenjuly.mylibrary.ToggleExpandLayout;
import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.kyleduo.switchbutton.SwitchButton;
import com.sleepbot.datetimepicker.time.RadialPickerLayout;
import com.sleepbot.datetimepicker.time.TimePickerDialog;

import java.util.Calendar;

/**
 * Created by 10 on 2016-07-01.
 */
public class SettingDataActivity extends FragmentActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    public static final String DATEPICKER_TAG = "datepicker";
    public static final String TIMEPICKER_TAG = "timepicker";
    public static float temp = 0;


    @TargetApi(21)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_data);
        final ToggleExpandLayout layout = (ToggleExpandLayout) findViewById(R.id.toogleLayout);
        final ToggleExpandLayout layout2 = (ToggleExpandLayout) findViewById(R.id.toogleLayout2);
        SwitchButton switchButton = (SwitchButton) findViewById(R.id.switch_button);
        SwitchButton switchButton2 = (SwitchButton) findViewById(R.id.switch_button2);

        layout.setOnToggleTouchListener(new ToggleExpandLayout.OnToggleTouchListener() {

            @Override
            public void onStartOpen() {

            }

            @Override
            public void onOpen() {
                ToggleExpandLayout t1 = (ToggleExpandLayout) findViewById(R.id.toogleLayout);
                ToggleExpandLayout t2 = (ToggleExpandLayout) findViewById(R.id.toogleLayout2);
                temp = (t2.getY() - t1.getY())*4;
                t2.setY( t2.getY() + temp);
            }
            @Override
            public void onStartClose() {
            }
            @Override
            public void onClosed() {
                ToggleExpandLayout t1 = (ToggleExpandLayout) findViewById(R.id.toogleLayout);
                ToggleExpandLayout t2 = (ToggleExpandLayout) findViewById(R.id.toogleLayout2);
                t2.setY( t2.getY() - temp );
            }
        });

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    layout.open();
                } else {
                    layout.close();
                }
            }
        });


        layout2.setOnToggleTouchListener(new ToggleExpandLayout.OnToggleTouchListener() {

            @Override
            public void onStartOpen() {

            }

            @Override
            public void onOpen() {
            }
            @Override
            public void onStartClose() {
            }
            @Override
            public void onClosed() {

            }
        });

        switchButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    layout2.open();
                } else {
                    layout2.close();
                }
            }
        });



        final Calendar calendar = Calendar.getInstance();

        final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        final TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(this, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false, false);

        findViewById(R.id.dateList).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               // datePickerDialog.setVibrate(isVibrate());
                datePickerDialog.setYearRange(1985, 2028);
                //datePickerDialog.setCloseOnSingleTapDay(isCloseOnSingleTapDay());
                datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);

            }
        });

        findViewById(R.id.timeList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // timePickerDialog.setVibrate(isVibrate());
               // timePickerDialog.setCloseOnSingleTapMinute(isCloseOnSingleTapMinute());
                timePickerDialog.show(getSupportFragmentManager(), TIMEPICKER_TAG);
            }
        });

        if (savedInstanceState != null) {
            DatePickerDialog dpd = (DatePickerDialog) getSupportFragmentManager().findFragmentByTag(DATEPICKER_TAG);
            if (dpd != null) {
                dpd.setOnDateSetListener(this);

            }

            TimePickerDialog tpd = (TimePickerDialog) getSupportFragmentManager().findFragmentByTag(TIMEPICKER_TAG);
            if (tpd != null) {
                tpd.setOnTimeSetListener(this);

            }
        }

    }

    /*private boolean isVibrate() {
        return ((CheckBox) findViewById(R.id.checkBoxVibrate)).isChecked();
    }

    private boolean isCloseOnSingleTapDay() {
        return ((CheckBox) findViewById(R.id.checkBoxCloseOnSingleTapDay)).isChecked();
    }

    private boolean isCloseOnSingleTapMinute() {
        return ((CheckBox) findViewById(R.id.checkBoxCloseOnSingleTapMinute)).isChecked();
    }*/

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
        Toast.makeText(SettingDataActivity.this, "new date:" + year + "-" + month + "-" + day, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        Toast.makeText(SettingDataActivity.this, "new time:" + hourOfDay + "-" + minute, Toast.LENGTH_LONG).show();
    }
}
