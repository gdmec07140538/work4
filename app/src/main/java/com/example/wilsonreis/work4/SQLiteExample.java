package com.example.wilsonreis.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteExample extends SQLiteOpenHelper{
	

	private static String DB_NAME = "My_DB.db";  //���ݿ�����
	private static int DB_VERSION = 2;  //�汾��
	private  SQLiteDatabase db; //���ݿ��������
	public SQLiteExample(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		db=getWritableDatabase();  //��д��ʽ�����ݿ�
		 Log.v("db", "db is created");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
