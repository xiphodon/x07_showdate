package com.example.test;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.Person;
import com.example.x07_showdate.SQLiteCreate;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

public class Test extends AndroidTestCase {
	
	List<Person> personList;
	private SQLiteCreate sql;
	private SQLiteDatabase db;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		sql = new SQLiteCreate(getContext(), "people.db", null, 1);
		db = sql.getReadableDatabase();
		personList = new ArrayList<Person>();
	}
	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		db.close();
	}
	
	public void insert(){
		ContentValues values = new ContentValues();
		for(int i=0;i<50;i++){
			values.put("name", "ะกร๗" + i);
			values.put("age", "1" + i);
			values.put("salary", 15000 + i + "");
			db.insert("person", null, values);
			values.clear();
		}
	}
	
	/*public void select(){
		Cursor cursor = db.query("person", null, null, null, null, null, null, null);
		while(cursor.moveToNext()){
			int id = cursor.getInt(cursor.getColumnIndex("_id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			int age = cursor.getInt(cursor.getColumnIndex("age"));
			String salary = cursor.getString(cursor.getColumnIndex("salary"));
			Person person = new Person(id, name, age, salary);
			personList.add(person);
		}
	}*/
}
