package com.example.wilsonreis.myapplication;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;



public class SimpleCursorAdapterDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewdemo);
        ListView mListView = (ListView) findViewById(R.id.list_view);        
        //getContentResolver()����һ��ContentResolver����
        //query()�������һ��ָ��ϵͳͨѶ¼���ݿ��Cursor����
        //���в���projection��ʾ���ص��У�����selection��ʾSQL��where��ѯ������
        //����selectionArgs��ʾwhere����б��ʽ��?ռλ�����б�����sortOrder��ʾ���ĸ��ֶν��������ǽ���
        Cursor mCursor = getContentResolver().query(Uri.parse("content://contacts/people/"), null, null, null, null);
        //��Cursor������Activity��������Cursor���������ں�Activity���ܹ��Զ�ͬ����ʡȥ�Լ��ֶ�����Cursor
        startManagingCursor(mCursor);
        //SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_1, mCursor, new String[]{People.NAME}, new int[]{android.R.id.text1});
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.mylistitem, mCursor, new String[]{People.NAME,People.NOTES}, new int[]{R.id.titleView,R.id.infoView});
        mListView.setAdapter(mAdapter);
        //mAdapter.notifyDataSetChanged();
    }  

    
}
