package com.example.wilsonreis.myapplication;

import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerDialogDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_dialog_demo);
        dialog10();
    }

    public void dialog10(){
  	   Calendar calendar = Calendar.getInstance(Locale.CHINA); 

  	   new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener() {
  		    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
  		    	String time=hourOfDay + ":" + minute;
  		    	Toast.makeText(TimePickerDialogDemo.this, time, Toast.LENGTH_SHORT);
  		    	
  		    }
  		   },calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true).show();


     }

    
}
