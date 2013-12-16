package com.example.authentifationactivity;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ComputeActivity extends Activity {

	RadioGroup group;
	RadioButton radio1;
	RadioButton radio2;
	EditText min;
	EditText max;
	EditText even;
	Button calculate;
	TextView textmin;
	TextView textmax;
	TextView texteven;
	TextView finale;
	
	int actual=0;
	String x="";
	String y="";
	String z="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compute);
		
		group= (RadioGroup) findViewById(R.id.radioGroup1);
		radio1=(RadioButton) group.findViewById(R.id.radio0);
		radio2=(RadioButton) group.findViewById(R.id.radio1);
		min = (EditText) findViewById(R.id.editText1);
		max = (EditText) findViewById(R.id.editText2);
		even = (EditText) findViewById(R.id.editText3);
		
		calculate = (Button) findViewById(R.id.button1);
		textmin=(TextView) findViewById(R.id.textView2);
		textmax=(TextView) findViewById(R.id.textView3);
		texteven=(TextView) findViewById(R.id.textView5);
		
		finale= (TextView) findViewById(R.id.textView6);
		
		finale.setText("");
		even.setVisibility(View.INVISIBLE);
		texteven.setVisibility(View.INVISIBLE);
		
		
		radio1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(v.getContext(), "Login incorrect", Toast.LENGTH_SHORT).show();
				textmin.setVisibility(View.VISIBLE);
				textmin.setText("Min Value");
				min.setVisibility(View.VISIBLE);
				textmax.setVisibility(View.VISIBLE);
				max.setVisibility(View.VISIBLE);
				
				texteven.setVisibility(View.INVISIBLE);
				even.setVisibility(View.INVISIBLE);
				actual=0;
				
				
			}
		});
		
		
		radio2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textmin.setVisibility(View.VISIBLE);
				textmin.setText("Even Number");
				min.setVisibility(View.VISIBLE);
				textmax.setVisibility(View.INVISIBLE);
				max.setVisibility(View.INVISIBLE);
				
				//texteven.setVisibility(View.VISIBLE);
				//even.setVisibility(View.VISIBLE);
				
				actual=1;
				
			}
		});
		
		calculate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				if(actual==0){
					
				
				x =min.getText().toString();
				y=max.getText().toString();
				int x1 =Integer.parseInt(x);
				int y1 =Integer.parseInt(y);
				Boolean test=true;
				String result ="Result : {";
				for (int i = x1; i <= y1; i++) {
					
					if(isPremier(i)){
					result+=i+", ";
					}
					
				}
				finale.setText(result.substring(0, result.length()-2)+"}");
				}
				
				if(actual==1){
					//Toast.makeText(v.getContext(), "Login incorrect", Toast.LENGTH_SHORT).show();
					
					
					//x =min.getText().toString();
					z=min.getText().toString();
					int z1 =Integer.parseInt(z);
					String s="";
					Boolean test=true;
					
					
					
					if(z1%2!=0){
						Toast.makeText(v.getContext(), "Nombre impaire", Toast.LENGTH_SHORT).show();
					}
					else{
						
					     for (int i = 1; i <= z1/2; i++) {
					           
					            for (int j = z1; j >= z1/2; j--) {
					              
					                if((i+j)==z1){
					                    
					                    if(isPremier(i)&&isPremier(j)){
					                    	s+="("+i+","+j+"),";
					                    }
					                }
					            }
					        }
				
						finale.setText(s.substring(0, s.length()-1));
					}
					
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_compute, menu);
		return true;
	}
	

	
	public boolean isPremier(int x){

        boolean test = true;
        for (int i = 2; i <= x / 2; i++) {

            if (x % i == 0) {
                test = false;
            }

        }
        return test;
	}
}
