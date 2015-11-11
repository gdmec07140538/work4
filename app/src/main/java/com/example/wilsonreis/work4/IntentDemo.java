package com.example.wilsonreis.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class IntentDemo extends Activity {
	private EditText eText;
	private Button button;
	private TextView tText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_demo);
		eText = (EditText) this.findViewById(R.id.editText1);
		button = (Button) this.findViewById(R.id.button1);
		tText = (TextView) this.findViewById(R.id.textView1);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
                  Bundle bundle=new Bundle();
                  bundle.putString("value", eText.getText().toString());
                  Intent intent=new Intent(IntentDemo.this, IntentDemo2.class);
                  intent.putExtras(bundle);
                  startActivityForResult(intent,10);                  
			}

		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode){
		case 10:			
			Bundle bundle=data.getExtras();//getExtras����һ��Bundle����
			tText.setText(bundle.getString("result"));
		}
		
	}
	

}
