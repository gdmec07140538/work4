package com.example.wilsonreis.myapplication;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CharacterPickerDialogDemo extends Activity {
	
	private RelativeLayout mainView = null;      
	private TextView tv = null;       
	private Button button = null;      
	private CharacterPickerDialog cpd = null;     
	public void onCreate(Bundle savedInstanceState) {         
		super.onCreate(savedInstanceState);          
		mainView = new RelativeLayout(this);         
		tv = new TextView(this);           
		RelativeLayout.LayoutParams lp_tv = new RelativeLayout.LayoutParams(-2,-2);    
		lp_tv.addRule(RelativeLayout.CENTER_IN_PARENT);         
		tv.setLayoutParams(lp_tv);   
		tv.setGravity(Gravity.CENTER_HORIZONTAL);  
		tv.setText(" shown here result");   
		button = new Button(this);      
		RelativeLayout.LayoutParams lp_button = new RelativeLayout.LayoutParams(-2, -2);   
		lp_button.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM); 
		lp_button.addRule(RelativeLayout.CENTER_HORIZONTAL);   
		button.setLayoutParams(lp_button);     
		button.setText("open");     
		button.setOnClickListener(new Button.OnClickListener() {  
			public void onClick(View v) {        
				if (cpd == null) {            
					cpd_init();         
					}                  
				cpd.show();             
				}         
			});           
		mainView.addView(tv);      
		mainView.addView(button);   
		setContentView(mainView);       
		}       // Cpd initialization 
	void cpd_init() {       
		EditText et=new EditText(this);    
		et.setLayoutParams(new LinearLayout.LayoutParams(-1,-2));      
		final String options="0123456789ABCDEF";         
		cpd= new CharacterPickerDialog(this, new View(this), null,options,false){     
			public void onClick (View v){            
				//tv.setText("????"+((Button)v).getText().toString());    
				dismiss();           
				}             
			public void onItemClick (AdapterView parent, View view, int position, long id){    
				tv.setText("You pressed Button"+((Button)view).getText().toString()+"\n");    
				tv.append("the Button's position is"+position+"\n"); 
				tv.append("the buton ID"+id);              
				dismiss();             
				}         
			};        
			}   
			
		
	}

