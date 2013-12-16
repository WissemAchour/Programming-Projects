package com.example.authentifationactivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AuthentificationActivity extends Activity {

	String s1="";
	String s2="";
	Button sign;
	Button update;
	EditText login;
	EditText pass;
	TextView date;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_authentification);
		
		 sign = (Button) findViewById(R.id.button1);
		
		update = (Button) findViewById(R.id.button2);
		
		login = (EditText) findViewById(R.id.editText1);
		pass = (EditText) findViewById(R.id.editText2);
		
		date= (TextView) findViewById(R.id.textView3);
		Date d = new Date();
		String cal = d.toString();
		date.setText(cal);
		sign.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 s1= login.getText().toString();
				 s2 = pass.getText().toString();
				if((s1+"pw").equals(s2)){
					Toast.makeText(v.getContext(), "Login correct", Toast.LENGTH_SHORT).show();
					Intent go = new Intent(v.getContext(),ComputeActivity.class);
					startActivity(go);
				}
				else{
					Toast.makeText(v.getContext(), "Login incorrect", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		update.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Date d = new Date();
				
				date.setText(d.toString());
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_authentification, menu);
		return true;
	}

}
