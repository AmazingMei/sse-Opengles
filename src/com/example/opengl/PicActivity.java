package com.example.opengl;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PicActivity extends Activity{

	 private Button btn_take_photo, btn_pick_photo, btn_cancel;  
	    private LinearLayout layout;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pic);
		
		btn_take_photo = (Button) this.findViewById(R.id.btn_take_photo);  
        btn_pick_photo = (Button) this.findViewById(R.id.btn_pick_photo);  
        btn_cancel = (Button) this.findViewById(R.id.btn_cancel);  
          
        layout=(LinearLayout)findViewById(R.id.pop_layout);  
        layout.setOnClickListener(new View.OnClickListener() {  
            
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
                Toast.makeText(getApplicationContext(), "提示：点击窗口外部关闭窗口！",   
                        Toast.LENGTH_SHORT).show();   
            }  
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pic, menu);
		return true;
	}
	public boolean onTouchEvent(MotionEvent event){  
        finish();  
        return true;  
    }  
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 switch (v.getId()) {  
	        case R.id.btn_take_photo:  
	            break;  
	        case R.id.btn_pick_photo:                 
	            break;  
	        case R.id.btn_cancel:                 
	            break;  
	        default:  
	            break;  
	        }  
	        finish(); 
	}

}
