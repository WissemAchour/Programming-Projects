package com.example.tp33;

import java.util.ArrayList;
import java.util.List;

import android.app.DownloadManager.Query;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

public class ContactsManager {

	private ContactsDBHelper helper;
	private SQLiteDatabase db;
	
	private static final String col_nom="NOM";
	private static final String col_tel="TEL";
	private static final String col_email="EMAIL";
	private static final String create="Create Table";
	private static final String drop="Drop Table";
	private static final String table="Contact";
	
	public ContactsManager(Context context){

		helper = new ContactsDBHelper(context, "Contacts.db", null, 1);
	}
	
	
	void open(){
		
		
		//helper = new ContactsDBHelper(context, "Contact", null, 0);
		
		db=helper.getWritableDatabase();
		
		
	}
	
	
	public long insertContact(Contact unContact){
		ContentValues values = new ContentValues();
		
		values.put(col_nom, unContact.getNom());
		values.put(col_tel, unContact.getTel());
		values.put(col_email, unContact.getEmail());
		long verif;
		
		verif=db.insert("Contact", null, values);
		
		
		//
		
		return verif;//
	}
	
	
	public void updateContact(String name,Contact lecontact){
		
		ContentValues values = new ContentValues();
		values.put(col_tel, lecontact.getTel());
		values.put(col_email, lecontact.getEmail());
		db.update("Contact", values,col_nom+  "Like "+name, null);
		
	}
	
	public int deleteContact(String name){
		
		return db.delete("Contact", col_nom+" Like "+name, null);
	}
	
	
	private Contact cursorToContact(Cursor c){
		
		Contact lecontact = new Contact();
		
		lecontact.setNom(c.getString(0));
		lecontact.setTel(c.getString(1));
		lecontact.setEmail(c.getString(2));
		
		return lecontact;
		
	}
	
	public List<Contact> cursorToListOfContacts(Cursor c){
		
		List<Contact> lesContacts = new ArrayList<Contact>();
		
		while(c.moveToNext()){
			
			Contact lecontact = new Contact();
			
			lecontact.setNom(c.getString(0));
			lecontact.setTel(c.getString(1));
			lecontact.setEmail(c.getString(2));
			
			lesContacts.add(lecontact);
		}
		
		c.close();
		return lesContacts;
	}
	
	
	
	public Contact getContact(String nom){
	
		Cursor c = db.query( table, null, col_nom+" Like "+nom, null, null, null, null);
		
		
		return cursorToContact(c);
	}
	
	
public List<Contact> getAllContacts(){
	
	Cursor c = db.query( table, null, col_nom+" Like %", null, null, null, null);
	//Cursor c = db.query( table, null, "select * where "+col_nom, null, null, null, null);
		return cursorToListOfContacts(c);
}


}
