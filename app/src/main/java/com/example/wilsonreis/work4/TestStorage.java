package com.example.wilsonreis.myapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
/*
 * ������˲���SQlite���ݿ�֮�⣬���ṩ�˲���Sharepreferences���ļ��ȼ������ݴ洢����
 */
public class TestStorage extends Activity {
	MySQLiteHelper myhelper;
	String Sql;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite_activity);
		myhelper= new MySQLiteHelper(this,"My_DB.db",1);// �����ݿ⣬��һ�δ����û�п⣬���ȴ���
	}

	// ��ȡSharedPreferences�е�����
	void ReadSharedPreferences() {
		String strName, strPassword;

		SharedPreferences user=getSharedPreferences("user",0);
		
		// ��ȡ�ؼ���ΪNAME����ֵ
		strName = user.getString("NAME", "");
		strPassword = user.getString("PASSWORD", "");
		int age = user.getInt("AGE", 9);
		Toast.makeText(this, "����Ϊ="+strName+",����Ϊ=:"+strPassword+",����="+age, Toast.LENGTH_LONG).show();
		

	}

	// ʹ��SharedPreferencesд������
	void WriteSharedPreferences(String strName, String strPassword) {
		SharedPreferences user = getSharedPreferences("user", 0);
		Editor editor = user.edit();// �������ڱ༭״̬
		// "NAME"�͡�PASSWORD�����ǹؼ��֣�strName��strPassword����ֵ
		// ��ؼ���ΪNAME��д����ֵ
		int age = 10;
		editor.putString("NAME", strName);
		editor.putString("PASSWORD", strPassword);
		editor.putInt("AGE", age);		
		editor.commit();// ����ύ�޸ĺ������
	}
	public void dialog1() {
		AlertDialog dialog = new AlertDialog.Builder(this).create();
		dialog.setTitle("��ʾ");
		dialog.setMessage("ȷ�ϸ�����");		
		dialog.setIcon(android.R.drawable.ic_dialog_alert);
		// ��������������
		DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				if (which == DialogInterface.BUTTON_POSITIVE) {// ����ȷ��
//					Sql="delete from person  where name='adam'";
//		     		myhelper.execSQL(Sql);
					myhelper.db.delete("person", "name='adam'", null);
					myhelper.showData("select * from person");
					dialog.dismiss();
					
				} else if (which == DialogInterface.BUTTON_NEGATIVE) {// ����ȡ��
					dialog.dismiss();
				}
			}

		};
		dialog.setButton(DialogInterface.BUTTON_POSITIVE, "ȷ��", listenter);
		dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "ȡ��", listenter);
		dialog.show();
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		String Sql;
		switch (item.getItemId()) {
		case 0:
			WriteSharedPreferences("adam", "123");
			break;
		case 1:
			ReadSharedPreferences();
			break;		
		case 2:
			writeFile();
			break;
		case 3:
			readFile();
			break;	
		case 4:			
			Sql = "CREATE TABLE IF NOT EXISTS person (name VARCHAR," + 
					 "address VARCHAR)";
			myhelper.execSQL(Sql);// ������			
			break;
		case 5:
			Sql = "insert into person values('adam','�㶫')";
			myhelper.execSQL(Sql);// ��������
			myhelper.showData("select * from person");//��ʾ����
			break;
		case 6:
					
			Sql="update person set address='����' where name='adam'";
     		myhelper.execSQL(Sql);
			//ʹ������һ�ַ�������ʾ����;
			Vector vector=myhelper.getData("select * from person");
			String sName,sAddress;
			for(int i=0;i<vector.size();i++){
				ContentValues values=(ContentValues)vector.get(i);
				sName=(String)values.get("name");
				sAddress=(String)values.get("address");				
				Toast.makeText(this, sName+":"+sAddress, Toast.LENGTH_LONG).show();
			}
			break;
			
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main_activity3, menu);
		menu.add(Menu.NONE, 0, Menu.NONE, "д��Share");
		menu.add(Menu.NONE, 1, Menu.NONE, "��ȡShare");
		menu.add(Menu.NONE, 2, Menu.NONE, "д�ļ�");
		menu.add(Menu.NONE, 3, Menu.NONE, "���ļ�");		
		menu.add(Menu.NONE, 4, Menu.NONE, "������");
		menu.add(Menu.NONE, 5, Menu.NONE, "��������");
		menu.add(Menu.NONE, 6, Menu.NONE, "�޸�����");

		// SubMenu file=menu.addSubMenu("�ļ�");
		// SubMenu edit=menu.addSubMenu("�༭");
		// file.add(0,1,0,"�½�");
		// file.add(0,2,0,"��");
		// ʹ��add��������һ���˵��add����ִ����󣬻᷵��һ���˵������,��MenuItem
		// MenuItem item1=menu.add(1,Menu.NONE,Menu.NONE,R.string.itemtitle1);
		// item1.setIcon(R.drawable.icon);
		// item1.setVisible(false);
		// item1.setEnabled(false);

		// menu.add(1,Menu.NONE,Menu.NONE,R.string.itemtitle2);

		return true;
	}

	void writeFile() {
		String s = "Hello";
		s = s + "\n" + "Nice to meet you!";
		try {
			FileOutputStream fos = openFileOutput("text1.txt", 0);
			OutputStreamWriter outWriter = new OutputStreamWriter(fos);
			BufferedWriter bufferedWriter = new BufferedWriter(outWriter);
			bufferedWriter.write(s);
			bufferedWriter.flush();
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();// ����쳣�Ĵ�����Ϣ
		}
	}
	void readFile() {
		try {
			FileInputStream fis = openFileInput("text1.txt");
			// ���ֽ���ת�����ַ���
			InputStreamReader inReader = new InputStreamReader(fis);
			// ת���ɴ������bufferedReader
			BufferedReader bufferedReader = new BufferedReader(inReader);
			String s;
			while ((s = bufferedReader.readLine()) != null) {
				Toast.makeText(this,s, Toast.LENGTH_LONG).show();				
			}
			fis.close(); // �ر�������
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
