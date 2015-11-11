package com.example.wilsonreis.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class ProgressDialogDemo extends Activity {
	ProgressDialog dialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog=ProgressDialog.show(ProgressDialogDemo.this, "����","�����У����Ժ�..",true);
   	   //ʹ��һ���̣߳���4����Ƴ����ȶԻ���
   	   new Thread(){
   	      public void run(){
   	       try{
   	        sleep(4000);  
   	        
   	       }catch(Exception e){
   	        e.printStackTrace();
   	       }finally{
   	    	dialog.dismiss();
   	       }
   	      }
   	     }.start();       
    }   
    
}
