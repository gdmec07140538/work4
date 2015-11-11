package com.example.wilsonreis.myapplication;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

public class DatePickerDialogDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog_demo);
        dialog9();
    }

    public void dialog9(){
  	   Calendar d = Calendar.getInstance(Locale.CHINA);
  	 //����һ����������d��ͨ����̬����getInstance() ��ָ��ʱ�� Locale.CHINA ���һ������ʵ��
  	 Date myDate=new Date();
  	 //����һ��Dateʵ��
  	 d.setTime(myDate);
  	 //����������ʱ�䣬��һ���½�Dateʵ��myDate����
  	 int year=d.get(Calendar.YEAR);
  	 int month=d.get(Calendar.MONTH);
  	 int day=d.get(Calendar.DAY_OF_MONTH);
  	 //��������е� year month day
  	 DatePickerDialog dlg=new DatePickerDialog(this,new OnDateSetListener(){
  		
  		public void onDateSet(DatePicker view, int year, int monthOfYear,
  				int dayOfMonth) {
  			String date=Integer.toString(year) + "-" +
  				    Integer.toString(monthOfYear) + "-" + 
  				    Integer.toString(dayOfMonth);
  			Toast.makeText(DatePickerDialogDemo.this, date, Toast.LENGTH_SHORT);
  		}}
  	 ,year,month,day);
  	 //�½�һ��DatePickerDialog ���췽����         
  	 //     ���豸�����ģ�OnDateSetListenerʱ�����ü�������Ĭ���꣬Ĭ���£�Ĭ���գ�
  	 dlg.show();
  	 //��DatePickerDialog��ʾ����
     }

    
}
