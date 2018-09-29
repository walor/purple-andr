package com.restaurant;

import com.restaurant.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InfoScreen extends Activity {
	Button help;
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.info);
	        help=(Button)findViewById(R.id.Help);
	        help.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i=new Intent(InfoScreen.this,HelpGuide.class);
					startActivity(i);
					
				}
			});

}
}