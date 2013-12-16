package com.example.tp33;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class DeleteContact extends Activity {

	ListView list;
	TextView nom;
	TextView tel;
	List<Contact> contacts ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete_contact);

		list = (ListView) findViewById(R.id.listView1);
		
		List<HashMap<String, String>> list_contacts = new ArrayList<HashMap<String,String>>();
		
		contacts = new ArrayList<Contact>();
		ContactsManager man = new ContactsManager(getApplicationContext());
		contacts= man.getAllContacts();
		
		HashMap<String, String> element;
		
		for (int i = 0; i < contacts.size(); i++) {
			
			element = new HashMap<String, String>();
			element.put("nom", contacts.get(i).getNom());
			element.put("tel", contacts.get(i).getTel());
			list_contacts.add(element);
		}
		
		String[] from = new String[]{"nom","tel"};
		int[] lesVues = new int[]{android.R.id.text1,android.R.id.text2};
		
		
		ListAdapter adapt = new SimpleAdapter(this, list_contacts, android.R.layout.simple_list_item_2, from, lesVues);
		
		list.setAdapter(adapt);
		
		
		
	}

	public void onListItemClick(ListView parent , View v ,int position , long id){
		
		//Intent i = new Intent(DeleteContact.this,Con);
		
		Intent com = new Intent(DeleteContact.this,ConfirmDelete.class);
		com.putExtra("nom", contacts.get(position).getNom().toString());
		com.putExtra("tel", contacts.get(position).getTel().toString());
		com.putExtra("email", contacts.get(position).getEmail().toString());
		startActivityForResult(com,1);
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_delete_contact, menu);
		return true;
	}

}
