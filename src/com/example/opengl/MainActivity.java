package com.example.opengl;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Button next;
	private EditText name,company,position,tel,email;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  
	      next = (Button) findViewById(R.id.next);  
	      next.setOnClickListener(new View.OnClickListener() {  
	          
	    	    @Override  
	    	    public void onClick(View v) {  
	    	    	name = (EditText) findViewById(R.id.nameInput);
	    	    	company = (EditText)findViewById(R.id.companyInput);
	    	    	position = (EditText)findViewById(R.id.positionInput);
	    	    	tel = (EditText)findViewById(R.id.telInput);
	    	    	email = (EditText)findViewById(R.id.emailInput);
	    	    	
	    	    	String namestr=name.getText().toString(); 
	    	    	String companystr=company.getText().toString(); 
	    	    	String positionstr=position.getText().toString(); 
	    	    	String telstr=tel.getText().toString(); 
	    	    	String emailstr=email.getText().toString(); 
	    	    	
	    	    	
	    	    	Card card = new Card();
	    	    	card.setName(namestr);
	    	    	card.setCompany(companystr);
	    	    	card.setPosition(positionstr);
	    	    	card.setTel(telstr);
	    	    	card.setEmail(emailstr);
	    	    	Bundle bundle = new Bundle();
	    	    	bundle.putSerializable("cardObject", card);  
	    	    	 Intent intent = new Intent();
	                 intent.setClass(MainActivity.this, SelectActivity.class);
	                 intent.putExtras(bundle);  
	                 startActivity(intent); 
	                 
	    	    } 
	    	    } 
	    	);
	      }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
