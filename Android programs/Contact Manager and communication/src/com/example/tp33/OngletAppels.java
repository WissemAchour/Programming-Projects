package com.example.tp33;

import com.example.tp33.R.id;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class OngletAppels extends Activity {
TabHost host;
TabHost host2;
TabHost host3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_onglet_appels);
		
		host=(TabHost) findViewById(android.R.id.tabhost);
		host.setup();
	
		TabSpec spec = host.newTabSpec("AppAbs");
		spec.setIndicator("App_Abs", getResources().getDrawable(android.R.drawable.sym_call_missed));
		spec.setContent(R.id.tab1);
		
		host.addTab(spec);
		
		host.addTab(host.newTabSpec("AppRecu").setIndicator("App_Reçus").setContent(R.id.tab2));
		host.addTab(host.newTabSpec("AppEmis").setIndicator("App_Emis").setContent(R.id.tab3));
		
		
		host.setOnTabChangedListener(
				
				new TabHost.OnTabChangeListener() {
					
					@Override
					public void onTabChanged(String tabId) {
						// TODO Auto-generated method stub
				
						Toast.makeText(OngletAppels.this,"tab "+ tabId+" est activé", Toast.LENGTH_SHORT).show();
					}
				}
				
				);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_onglet_appels, menu);
		return true;
	}

}
