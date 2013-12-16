package com.example.tp33;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContact extends Activity {

	EditText nom;
	EditText tel;
	EditText email;
	Button ajouter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_contact);
		
		nom = (EditText) findViewById(R.id.editText1);
		tel = (EditText) findViewById(R.id.editText2);
		email = (EditText) findViewById(R.id.editText3);
		ajouter=(Button) findViewById(R.id.ajout);
		
		ajouter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String name = nom.getText().toString();
				String telf = tel.getText().toString();
				String em = email.getText().toString();
				
				//ContactsDBHelper helper = new ContactsDBHelper(getApplicationContext(), "", factory, version)
				ContactsManager man = new ContactsManager(getApplicationContext());
				man.open();
				Contact c = new Contact();
				c.setNom(name);
				c.setTel(telf);
				c.setEmail(em);
				man.insertContact(c);
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_add_contact, menu);
		return true;
	}

}
