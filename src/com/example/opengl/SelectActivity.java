package com.example.opengl;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectActivity extends Activity implements View.OnClickListener{

	private Button UploadBut,SubmitBut;
	private ImageView imageView;
	private File sdcardTempFile;
	private AlertDialog dialog;
	private int crop = 180;
	private Bitmap bmp=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select); 
		
		Intent intent = this.getIntent();  
		
		imageView = (ImageView) findViewById(R.id.pic);
        sdcardTempFile = new File("/mnt/sdcard/", "tmp_pic_" + SystemClock.currentThreadTimeMillis() + ".jpg");
 
		
		 UploadBut = (Button) findViewById(R.id.uploadBut);  
		 UploadBut.setOnClickListener(this);
		 
		 SubmitBut = (Button) findViewById(R.id.submit);
		 SubmitBut.setOnClickListener(this );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.select, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if (v == UploadBut) {
                            Intent intent = new Intent("android.intent.action.PICK");
                            intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
                            intent.putExtra("output", Uri.fromFile(sdcardTempFile));
                            intent.putExtra("crop", "true");
                            intent.putExtra("aspectX", 1);// 裁剪框比例
                            intent.putExtra("aspectY", 1);
                            intent.putExtra("outputX", crop);// 输出图片大小
                            intent.putExtra("outputY", crop);
                            startActivityForResult(intent, 100);
                        
        }
		else if(v== SubmitBut){
			CardApplication card=(CardApplication)getApplication();
			 
	    	 Intent intent = new Intent();
             intent.setClass(this, ShowCardActivity.class);
             card.setPicture(bmp);
             startActivity(intent);

		}
		
	}
	
	
	
	  @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
	        if (resultCode == RESULT_OK) {
	            bmp = BitmapFactory.decodeFile(sdcardTempFile.getAbsolutePath());
	            imageView.setImageBitmap(bmp);
	        }
	    }

}
