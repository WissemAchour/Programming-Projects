package com.example.tp33;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Gestion extends Activity {

	TextView t1;
	TextView t2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gestion);
		t1 = (TextView) findViewById(R.id.textView1);
        t2 = (TextView) findViewById(R.id.textView2);
        registerForContextMenu(t1);
        registerForContextMenu(t2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_gestion, menu);
		
		return true;
	}

	
	
	public boolean onOptionsItemSelected(MenuItem menu){
		
		Intent go ;
		switch(menu.getItemId()){
		
			
			case R.id.ajout:
				go=new Intent(this,AddContact.class);
				startActivity(go);
				return true;
			case R.id.supp:
				 go = new Intent(this,DeleteContact.class);
				startActivity(go);
				return true;
			case R.id.modif:
				 go = new Intent(this,UpdateContact.class);
				startActivity(go);
		
				return true;
				
			case R.id.item2:
				 go = new Intent(this,OngletAppels.class);
				startActivity(go);
		
				return true;
				
				default:
					return super.onOptionsItemSelected(menu);
					//return true;
		}
	
	}
	
	public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo menuinfo){
		
		menu.add(Menu.NONE,Menu.FIRST,Menu.NONE,"Rouge");
		menu.add(Menu.NONE,Menu.FIRST+1,Menu.NONE,"Vert");
		menu.add(Menu.NONE,Menu.FIRST+2,Menu.NONE,"Jaune");
	
	}
	
	public boolean onContextItemSelected(MenuItem item){
		
		switch(item.getItemId()){
		
		case Menu.FIRST:
			Toast.makeText(Gestion.this,"rouge", Toast.LENGTH_SHORT).show();
			if(((AdapterContextMenuInfo) item.getMenuInfo()).targetView.getId()==R.id.textView1){
				t1.setTextColor(Color.RED);
			}else{
				t2.setTextColor(Color.RED);
			}
			return true;
			
		case Menu.FIRST+1:
			Toast.makeText(Gestion.this,"Vert", Toast.LENGTH_SHORT).show();
		if(((AdapterContextMenuInfo) item.getMenuInfo()).targetView.getId()==R.id.textView1){
			t1.setTextColor(Color.GREEN);
		}else{
			t2.setTextColor(Color.GREEN);
		}
			return true;
		
		case Menu.FIRST+2:
			Toast.makeText(Gestion.this,"jaune", Toast.LENGTH_SHORT).show();
		if(((AdapterContextMenuInfo) item.getMenuInfo()).targetView.getId()==R.id.textView1){
			t1.setTextColor(Color.YELLOW);
		}else{
			t2.setTextColor(Color.YELLOW);
		}
			return true;
		
		default:
			return super.onContextItemSelected(item);
		}
		
	}
}
