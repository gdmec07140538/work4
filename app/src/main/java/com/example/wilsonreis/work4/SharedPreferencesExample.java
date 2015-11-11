package com.example.wilsonreis.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SharedPreferencesExample extends Activity {
	String strName,strPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		
        setContentView(R.layout.secondlayout);   
        TextView tName=(TextView)this.findViewById(R.id.tName);
		TextView iAge=(TextView)this.findViewById(R.id.iAge);
		Bundle localBundle = getIntent().getExtras();       
		int age=localBundle.getInt("age");
		String name=localBundle.getString("name");
		 
		 tName.setText(name);
		 
		 iAge.setText(String.valueOf(age));
        WriteSharedPreferences("adam","123");
        ReadSharedPreferences();
        SQLiteExample sqlite=new SQLiteExample(this);
        
	}

	void ReadSharedPreferences() {
		SharedPreferences user = getSharedPreferences("user", 0);
		strName = user.getString("NAME", "");
		strPassword = user.getString("PASSWORD", "");
		Log.v("NAME", strName);
		Log.v("PASSWORD", strPassword);
	}

	void WriteSharedPreferences(String strName, String strPassword) {
		SharedPreferences user = getSharedPreferences("user", 0);
		Editor editor = user.edit();
		editor.putString("NAME", strName);
		editor.putString("PASSWORD", strPassword);
		editor.commit();
	}
}
