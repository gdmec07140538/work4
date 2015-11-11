package com.example.wilsonreis.myapplication;

import java.util.Vector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MySQLiteHelper extends SQLiteOpenHelper{
	 //private static String DB_NAME="My_DB.db";  //���ݿ�����
	   // private static int DB_VERSION=1;  //�汾��
	    private Context context;
	    public  SQLiteDatabase db; //���ݿ��������
    //�������ߴ�һ�����ݿ�
    public MySQLiteHelper(Context context,String DB_NAME,int DB_VERSION){    	
    	 super(context,DB_NAME,null,DB_VERSION);//���ø���Ĺ��췽��,ȷ�����ݿ�����ֺͰ汾
    	 this.context=context;
    	 db=getWritableDatabase();//�򿪻��ߴ���һ�����ݿ�
    }
    
	//���ض����ݿ��״α�����ʱ�����Զ�ִ��onCreate��������ôӦ�ý���������ʼ��������ݵĲ������ڴ˷�����
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String createTableSql = "CREATE TABLE departement(name VARCHAR," + 
				 "address VARCHAR)";
			db.execSQL(createTableSql);
          Toast.makeText(context, "hello,onCreate�Ѿ���ִ��", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	public void showData(String  Sql){
		String sName;
		String address;
		Cursor cursor=db.rawQuery(Sql,null);
		while(cursor.moveToNext()){
		   //��ȡ�α굱ǰ�е�name����ֵ
		   int index=cursor.getColumnIndex("name");
		   sName=cursor.getString(index); 
		   //��ȡ�α굱ǰ�е�address����ֵ
		   index=cursor.getColumnIndex("address");
		   address=cursor.getString(index);
		   Toast.makeText(this.context, sName+":"+address, Toast.LENGTH_LONG).show();
		   
		}
	}
	public Vector getData(String  Sql){
		String sName;
		String address;
		Cursor cursor=db.rawQuery(Sql,null);
		ContentValues values;
		Vector vector=new Vector();//����һ��Vector���͵ļ��϶���
		int a[]=new int[10];//����һ���������飬��С��10��
		int b=100;
		while(cursor.moveToNext()){
		   //��ȡ�α굱ǰ�е�name����ֵ
		   int index=cursor.getColumnIndex("name");
		   sName=cursor.getString(index); 
		   //��ȡ�α굱ǰ�е�address����ֵ
		   index=cursor.getColumnIndex("address");
		   address=cursor.getString(index);
		   values=new ContentValues();//�½�һ��ContentValues����values
		   values.put("name", sName);
		   values.put("address", address);
		   //���ϵ������ǿ��Զ�̬�ش�����ݣ��������һ��ʼ����̶��Ĵ�С�������Եø����
		   vector.add(values);//��values����ŵ�һ��Vector������
		   Toast.makeText(this.context, sName+":"+address, Toast.LENGTH_LONG).show();
		   
		}
		return vector;
		
	}
	
	public  boolean execSQL(String  Sql)
	{
	       try{
	        	   
	    	        db.execSQL(Sql); //ִ�г���select����֮�������SQL��䣬����:crate,delete,update,inser��SQL����
	           }catch(Exception ex){
	        	   ex.printStackTrace();
				   return false;
			   }
			   return true;
	}

}
