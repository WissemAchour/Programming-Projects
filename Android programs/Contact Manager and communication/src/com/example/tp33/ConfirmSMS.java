package com.example.tp33;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ConfirmSMS extends Activity {
 EditText txt1;
 EditText txt2;
 Intent versM;
 Button b;
 Button b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_sms);
		
		txt1 =(EditText) findViewById(R.id.editText1);
		txt2 =(EditText) findViewById(R.id.editText2);
		b =(Button) findViewById(R.id.button2);
		b2 =(Button) findViewById(R.id.button1);
		
		Bundle extras = getIntent().getExtras();
		String phone = extras.getString("phone");
		String msg = extras.getString("msg");
		
		txt1.setText(phone.toString());
		txt2.setText(msg.toString());
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				versM = new Intent();
				versM.putExtra("cancel", "canceled from Fille" );
				setResult(RESULT_CANCELED,versM);
				finish();
				
			}
		});
		
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String phone = txt1.getText().toString();
				String msg = txt2.getText().toString();
				/*Uri uri = Uri.parse("sms:"+phone+"?body="+msg);
				Intent appel = new Intent(Intent.ACTION_SENDTO,uri);
				startActivity(appel);*/
				SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(phone, null,msg, null, null);
				
				
				
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_confirm_sms, menu);
		return true;
	}

}
