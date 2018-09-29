package com.restaurant;


import com.restaurant.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.view.View.OnClickListener;;

public class OrderScreen extends Activity implements OnClickListener {
	TextView orderitem,devidetextview,temp;
	EditText Quantity,devide_quanity;
	 Button Place_Order;
	 String tempstring;
	 Integer i;
	 String s;
	 String quanityforsoup;
	 StringBuilder orderdata=null;
	DatabaseHelper orderHelper;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        orderHelper = new DatabaseHelper(OrderScreen.this);
        
        setContentView(R.layout.orderscren);
        devide_quanity=(EditText)findViewById(R.id.devide_quanity);
        devidetextview=(TextView)findViewById(R.id.devidetextview);
    
        
        orderitem =(TextView)findViewById(R.id.orderitem);
        Quantity =(EditText)findViewById(R.id.Quantity);
        Place_Order =(Button)findViewById(R.id.Place_Order_btn);
        
        s= getIntent().getStringExtra("order");
      
        String[] temp;
    
        String delimiter = "-";
        
        temp = s.split(delimiter);
      
        s=temp[0];
       
        if(s.equals("Veg Manchaw")||s.equals("Tomato")){	
    	   devide_quanity.setVisibility(View.VISIBLE);
    	   devidetextview.setVisibility(View.VISIBLE);
    	}
        else{
    	   devide_quanity.setVisibility(View.INVISIBLE);
    	   devidetextview.setVisibility(View.INVISIBLE);
       }
       orderitem.setText("You have ordered "+s);
      
       
       Quantity.setRawInputType(InputType.TYPE_CLASS_NUMBER);
       devide_quanity.setRawInputType(InputType.TYPE_CLASS_NUMBER);
      
      
       Place_Order.setClickable(true);
      
     
       Place_Order.setOnClickListener(this);
      
   	}
	@Override
	protected void onResume() {
		super.onResume();
		 Place_Order.setClickable(true);
		  	if(s.equals("Veg Manchaw")||s.equals("Tomato")){	
		  		devide_quanity.setVisibility(View.VISIBLE);
		  		devidetextview.setVisibility(View.VISIBLE);
		   }
	       else{
	    	   devide_quanity.setVisibility(View.INVISIBLE);
	    	   devidetextview.setVisibility(View.INVISIBLE);
	       }
		  orderHelper = new DatabaseHelper(OrderScreen.this);
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		 Place_Order.setClickable(true);
		  	if(s.equals("Veg Manchaw")||s.equals("Tomato")){	
		  		devide_quanity.setVisibility(View.VISIBLE);
		    	devidetextview.setVisibility(View.VISIBLE);
		    }
	       else{
	    	   devide_quanity.setVisibility(View.INVISIBLE);
	    	   devidetextview.setVisibility(View.INVISIBLE);
	       }
	}

	@Override
	public void onClick(View v) {

			
			Place_Order.setClickable(false);
			tempstring=Quantity.getText().toString();
		
			i=Integer.parseInt(tempstring); 
			Toast.makeText(OrderScreen.this, s, Toast.LENGTH_LONG);
			String  temps=s;
			s=s+"  "+ "quantity"+"  "+ i;
	      
			if((temps.equals("Tomato")||temps.equals("Veg Manchaw")) && !(devide_quanity.getText().toString().equals("")))  {	
				Log.e("temp","iside");
				s=s+"/"+devide_quanity.getText().toString();
			}	
	   
			boolean add = ModelClass.al.add(s);
		 
			orderHelper.addOrder(s);
			finish();
		
	}
	public boolean checkType()
	{
		return false;
	}
	
	public void onStop(){
		super.onStop();
		orderHelper.close();
	}
}