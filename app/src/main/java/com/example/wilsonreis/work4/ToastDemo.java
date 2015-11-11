package com.example.wilsonreis.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ToastDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        setContentView(R.layout.activity_toast_demo);
        getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, android.R.drawable.ic_dialog_alert);        
        Button button1=(Button)this.findViewById(R.id.button1);
        Button button2=(Button)this.findViewById(R.id.button2);
        Button button3=(Button)this.findViewById(R.id.button3);
        button1.setOnClickListener(showToast1);
        button2.setOnClickListener(showToast2);
        button3.setOnClickListener(showToast3);
    }
    OnClickListener showToast1=new OnClickListener(){		
		public void onClick(View v) {
		   Toast.makeText(ToastDemo.this, "ֱ�������Ϣ", Toast.LENGTH_SHORT).show();		   
		}   	
    	
    };
    OnClickListener showToast2=new OnClickListener(){		
		public void onClick(View v) {
			//��ȡLayoutInflater����   
			LayoutInflater li=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    	//��ȡһ��View����
			View view=li.inflate(R.layout.toastinfo,null);
            Toast toast=new Toast(ToastDemo.this);
            toast.setView(view);
            toast.show();		   
		}      	
    };
    OnClickListener showToast3=new OnClickListener(){		
		public void onClick(View v) {
			//1 ����Toast
			Toast toast = Toast.makeText(ToastDemo.this, "ͼ����ʾ", Toast.LENGTH_LONG);
			//2 ����Layout��������Ϊˮƽ����
            LinearLayout mLayout = new LinearLayout(ToastDemo.this);
		    mLayout.setOrientation(LinearLayout.VERTICAL);
			ImageView mImage = new ImageView(ToastDemo.this); //������ʾͼ���ImageView
			mImage.setImageResource(R.drawable.icon);
			View toastView = toast.getView(); //��ȡ��ʾ���ֵ�Toast View
			mLayout.addView(mImage); //��ͼƬ��ӵ�Layout
			mLayout.addView(toastView);
			//3 ����Toast��ʾ��View,����Ϊ�������ɵ�Layout
            toast.setView(mLayout);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);			
            toast.show();   
		}      	
    };
} 
