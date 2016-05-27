package com.example.x07_showdate;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.Person;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	List<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main2);
        personList = new ArrayList<Person>();
        
        SQLiteCreate sql = new SQLiteCreate(this, "people.db", null, 1);
        SQLiteDatabase  db = sql.getReadableDatabase();
        
        Cursor cursor = db.query("person", null, null, null, null, null, null, null);
		while(cursor.moveToNext()){
			int id = cursor.getInt(cursor.getColumnIndex("_id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			int age = cursor.getInt(cursor.getColumnIndex("age"));
			String salary = cursor.getString(cursor.getColumnIndex("salary"));
			Person person = new Person(id, name, age, salary);
			personList.add(person);
		}
	/*	
		//�Ѿ���ʱ��Ӧ�ø������listview
		LinearLayout ll =  (LinearLayout) findViewById(R.id.ll);
		//��ʾ��Android��Ļ    TextView
		for (Person p : personList) {
			TextView tv = new TextView(this);
			tv.setText(p.toString());
			tv.setTextSize(20);
			//��new����ÿһ��TextView��ӵ�LinearLayout�ڵ���
			ll.addView(tv);
		}
		*/
		
		
		
		//ʹ��ListView����ʾ����
		
		
		ListView lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(new BaseAdapter() {
			
			@Override           //����λ��                             //����View    
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				Person p = personList.get(position);
				
//				//��ͨtextview��ʾ
//				TextView tv = new TextView(MainActivity.this);
//				tv.setText(p.toString() + "lv");
//				tv.setTextSize(20);
//				System.out.println(arg0);
				
				
				//Ƕ�ײ����ļ�
				
				
				//�Ѳ����ļ����Ϊһ��View����
				
//				
//				//��ò������������
//				LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
//				//ʹ�ò����������䲼���ļ�
//				View v2 = inflater.inflate(R.layout.item_main, null);
//				
//				LayoutInflater inflater2 = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//				View v3 = inflater2.inflate(R.layout.item_main, null);
//				
//				
				View v = null;
				//�жϻ����Ƿ�Ϊ��
				if(convertView==null){
					v = View.inflate(MainActivity.this, R.layout.item_main, null);
				}else{
					v = convertView;
				}
			
				TextView tv_name = (TextView) v.findViewById(R.id.tv_name);
				TextView tv_age = (TextView) v.findViewById(R.id.tv_age);
				TextView tv_salary = (TextView) v.findViewById(R.id.tv_salary);
				
				tv_name.setText(p.getName());
				tv_age.setText(p.getAge() + "");
				tv_salary.setText(p.getSalary());
				
				return v;
			}
			
			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return personList.size();
			}
		});
		
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
