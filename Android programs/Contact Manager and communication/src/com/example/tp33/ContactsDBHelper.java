package com.example.tp33;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactsDBHelper extends SQLiteOpenHelper {

	private static final String col_nom="NOM";
	private static final String col_tel="TEL";
	private static final String col_email="EMAIL";
	private static final String create="Create Table";
	private static final String drop="Drop Table";
	private static final String table="Contact";
	
	public ContactsDBHelper(Context contex,String name,CursorFactory factory,int version){
		
		super(contex,name,factory,version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		
		db.execSQL(create+" "+table+ " ("+col_nom +" TEXT PRIMARY KEY,"
		+col_tel+" TEXT,"
		+col_email+ " TEXT);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int vOld, int vNew) {
		// TODO Auto-generated method stub
		 db.execSQL(drop+" IF EXISTS "+table);
		 onCreate(db);
		
	}
	
	
}
