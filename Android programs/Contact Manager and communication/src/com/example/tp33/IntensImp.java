package com.example.tp33;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntensImp extends Activity {

	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intens_imp);
		
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b5 = (Button) findViewById(R.id.button5);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Uri uri = Uri.parse("tel:5556");
				Intent appel = new Intent(Intent.ACTION_CALL,uri);
				startActivity(appel);
			}
		});
		
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("content://call_log/calls");
				Intent appel = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(appel);
				
				
			}
		});
		
		b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("content://contacts/people");
				Intent appel = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(appel);
			}
		});
		
		b4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("content://contacts/people/1");
				Intent appel = new Intent(Intent.ACTION_EDIT,uri);
				startActivity(appel);
			}
		});
		
		b5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Uri uri = Uri.parse("content://sms/inbox");
				Intent appel = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(appel);
			}
		});
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_intens_imp, menu);
		return true;
	}

}
