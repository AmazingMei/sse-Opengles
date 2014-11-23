package com.example.opengl;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class SelectActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select); 
		Intent intent = this.getIntent();  
		Bundle bundle = intent.getExtras();  
		Card card = (Card)bundle.getSerializable("cardObject");
		TextView name = (TextView)findViewById(R.id.name);  
		//String a = card.getName();
		//System.out.println(a);
		
		name.setText(card.getName());  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select, menu);
		return true;
	}

}
