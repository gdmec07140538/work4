package com.example.wilsonreis.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;



public class SimpleAdapterDemo2 extends ListActivity {
	 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
  
         SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.activity_simple_adapter_demo,
                 new String[]{"imge","title","info"},
                 new int[]{R.id.imageView,R.id.titleView,R.id.infoView});
         setListAdapter(adapter);
     }
  
     private List<Map<String, Object>> getData() {
         List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
  
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("title", "G1");
         map.put("info", "google 1");
         map.put("imge", R.drawable.icon);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "G2");
         map.put("info", "google 2");
         map.put("imge", R.drawable.icon);
         list.add(map);
  
         map = new HashMap<String, Object>();
         map.put("title", "G3");
         map.put("info", "google 3");
         map.put("imge", R.drawable.icon);
         list.add(map);
          
         return list;
     }

    

    
}
