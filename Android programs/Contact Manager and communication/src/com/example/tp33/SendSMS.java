package com.example.tp33;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMS extends Activity {

	EditText txt1;
	EditText txt2;
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_sms);
		txt1 =(EditText) findViewById(R.id.editText1);
		txt2 =(EditText) findViewById(R.id.editText2);
		b =(Button) findViewById(R.id.button1);
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent com = new Intent(SendSMS.this,ConfirmSMS.class);
				com.putExtra("phone", txt1.getText().toString());
				com.putExtra("msg", txt2.getText().toString());
				startActivityForResult(com,1);
				
			}
		});
	}

	protected void onActivityResult(int requestCode ,int resultCode ,Intent data){
		
		switch(resultCode){
		
		case RESULT_CANCELED:
			String s = data.getStringExtra("cancel");
			Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
		
		
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_send_sms, menu);
		return true;
	}

}
