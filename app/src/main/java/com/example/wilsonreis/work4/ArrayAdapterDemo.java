package com.example.wilsonreis.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;



public class ArrayAdapterDemo extends Activity {
	private EditText filterText = null;
	ArrayAdapter  adapter = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //����һ�������ļ���Ϊlistviewdemo���ڲ����ļ������һ���б�idΪlist_view
        
        setContentView(R.layout.arrayadapter);
        ListView listView = (ListView) findViewById(R.id.list_view); 
        //�б�������         
        String[] weeks={"������","����һ","���ڶ�","������","������","������","������"};
        //String[] weeks={"abc","bcd","efg","efa","cae","hijka","lmna"};
        filterText = (EditText) findViewById(R.id.search_box);
        //filterText.addTextChangedListener(filterTextWatcher);
        filterText.addTextChangedListener(new TextWatcher() {

        	  public void afterTextChanged(Editable s) {
        	  }

        	  public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        	  }

        	  public void onTextChanged(CharSequence s, int start, int before, int count) {
        	   adapter.getFilter().filter(s.toString());
        	  }
        	  });


        //��������������         
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,weeks);
         adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,weeks);
        
         //ΪListView����������       
        listView.setAdapter(adapter);   
        //��Listview��Ӽ���       
        
        listView.setOnItemClickListener(new OnItemClickListener() {
        	  public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        			// �ں����б�д����������Ĵ������
        			Toast.makeText(ArrayAdapterDemo.this, "you are pressing:"+(position+1), Toast.LENGTH_SHORT).show();
        	  }        	  
        	});

    }
/*
    private TextWatcher filterTextWatcher = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                int count) {
            adapter.getFilter().filter(s);
           
        }

    };

*/

    
}
