package com.example.opengl;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectActivity extends Activity {

	private Button UploadBut;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select); 
		Intent intent = this.getIntent();  
		Bundle bundle = intent.getExtras();  
		Card card = (Card)bundle.getSerializable("cardObject");  
		
		 UploadBut = (Button) findViewById(R.id.uploadBut);  
	      UploadBut.setOnClickListener(new View.OnClickListener() {  

	    	    @Override  
	    	    public void onClick(View v) { 
	    	    	 Intent intent = new Intent();
	                 intent.setClass(SelectActivity.this, PicActivity.class);
	                //intent.putExtras(bundle);  
	                 startActivity(intent); 
	                 
	    	    }
	      });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select, menu);
		return true;
	}

}
