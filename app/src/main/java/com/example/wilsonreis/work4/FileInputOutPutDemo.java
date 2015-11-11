package com.example.wilsonreis.myapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;

public class FileInputOutPutDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputoutputdemo);
        write();
        read();
       
    }
    public void read(){
    	 try{	
    	    	FileInputStream fis=openFileInput("text1.txt"); 
    	    	InputStreamReader inReader=new InputStreamReader(fis);
    	    	BufferedReader bufferedReader = new BufferedReader(inReader);//InputStreamReader ת���ɴ������bufferedReader    	    	
    	    	String s;   
    	    	while((s = bufferedReader.readLine())!=null){   
    	    		System.out.println(s);  
    	    	}  
                    	    	
    	    	fis.close(); //�ر������� 
    	    	 }catch(Exception ex){
    	    		 ex.printStackTrace();
    	    	 }
    }
    public void write(){
    	 String s="Hello";
    	 s=s+"\n"+"Nice to meet you!";
    	 try{
         	
    	        FileOutputStream fos=openFileOutput("text1.txt",0); 
    	        OutputStreamWriter outWriter=new OutputStreamWriter(fos);
    	        BufferedWriter bufferedWriter = new BufferedWriter(outWriter);   

    	        bufferedWriter.write(s);
    	        bufferedWriter.flush();
    	        fos.close();   

    	        }catch(Exception ex){
    	        	ex.printStackTrace();
    	        }
    }
    
    
}
