package com.example.wilsonreis.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class IntentDemo2 extends Activity {
    private Button button;
    String value;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo2);
        button=(Button)this.findViewById(R.id.button1);
        Intent intent=this.getIntent();//��ȡ�ⲿActivity��������Intent����       
        Bundle bundle=intent.getExtras();//��ȡIntent�е�Bundle����
        value=bundle.getString("value");//��ȡ�ؼ��֡�value������Ӧ����ֵ        
        button.setOnClickListener(new OnClickListener(){			
			public void onClick(View v) {		
				value=value.toUpperCase();//���ַ�ת���ɴ�д
				Intent intent=new Intent();
				intent.putExtra("result", value);//ֱ����intentд�����ݣ��ô���Ŀ������ʾ��ʹ��BundleҲ������������
				//setResult��ʾ����һ��Activity���ؽ��
				IntentDemo2.this.setResult(RESULT_OK, intent);//IntentDemo2.this��ʾ����һ��Activity
				IntentDemo2.this.finish();
			}
        	
        }
        );
        
    }

   
}
