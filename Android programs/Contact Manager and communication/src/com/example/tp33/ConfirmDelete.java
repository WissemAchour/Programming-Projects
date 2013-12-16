package com.example.tp33;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmDelete extends Activity {

	TextView t1;
	TextView t2;
	TextView t3;
	Button b ;
	String nom;
	String tel;
	String email;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_delete);
		

		Bundle extras = getIntent().getExtras();
		 nom = extras.getString("nom");
		tel = extras.getString("tel");
		email = extras.getString("email");
		
		
		t1=(TextView) findViewById(R.id.textView2);
		t2=(TextView) findViewById(R.id.textView4);
		t3=(TextView) findViewById(R.id.textView6);
		b=(Button) findViewById(R.id.button1);
		
b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				t1.setText(nom);
				t1.setText(tel);
				t1.setText(email);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_confirm_delete, menu);
		return true;
	}

}
