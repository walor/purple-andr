package com.restaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class RestaurantActivity extends Activity {
    
	Button go_to_menu,go_to_order_list,findstore,info;
	String user_name;
	@Override
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Intent myintent = getIntent();
        Bundle extras = myintent.getExtras();
        user_name = extras.getString("cust_name");
        Toast.makeText(RestaurantActivity.this, "Welcome " + user_name ,Toast.LENGTH_LONG ).show();
        
        go_to_menu=(Button)findViewById(R.id.Go_To_Menu);
        
        go_to_order_list=(Button)findViewById(R.id.Go_To_Order_List);
       
        findstore=(Button)findViewById(R.id.FindStore);
        
        info=(Button)findViewById(R.id.Info);
        
        ModelClass.createlist();
        info.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent i =new Intent(RestaurantActivity.this,InfoScreen.class);
				RestaurantActivity.this.startActivity(i);
			}
		});
        go_to_menu.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent i =new Intent(RestaurantActivity.this,MenuScreen.class);
				RestaurantActivity.this.startActivity(i);
			}
		});
    
        findstore.setOnClickListener( new OnClickListener() {
			
			public void onClick(View v) {
				Intent i =new Intent(RestaurantActivity.this,FindStore.class);
				RestaurantActivity.this.startActivity(i);
			}
		});
        go_to_order_list.setOnClickListener( new OnClickListener() {
			
			public void onClick(View v) {
				Intent i =new Intent(RestaurantActivity.this,OrderList.class);
				RestaurantActivity.this.startActivity(i);
			}
		});
    }
}