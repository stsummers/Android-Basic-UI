package com.example.helloweixin;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, OnLongClickListener{

	static Integer counter = 0;
	static Boolean flag = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button)findViewById(R.id.button02);
		button.setOnClickListener(this);
		
		button = (Button)findViewById(R.id.button1);
		button.setOnLongClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onClick(View v) {
		counter += 1;
		String sOut = "I'm clicked ";
		sOut +=	counter.toString();
		sOut += " times";
		
		EditText editText = (EditText)findViewById(R.id.editText1);
		editText.setText(sOut, TextView.BufferType.NORMAL);
		
		Log.e(sOut, "Tester");
		
	}

	@Override
	public boolean onLongClick(View v) {

		String sOut = "Click flag is ";
		flag = (flag == true)?(false):(true);
		sOut += flag.toString();

		// reset the counter 
		counter = 0;

		EditText editText = (EditText)findViewById(R.id.editText1);
		editText.setText(sOut, TextView.BufferType.NORMAL);
		
		Log.e(sOut,  "Tester");
		
		// Show image!
		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		if(flag == true)
		{
			imageView.setImageResource(R.drawable.fast);
		}
		else
		{
			imageView.setImageResource(R.drawable.monkey);
		}
		
		return false;
	}
}
