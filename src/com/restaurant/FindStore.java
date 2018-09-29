package com.restaurant;

import com.restaurant.R;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class FindStore extends Activity {
	WebView mWebView;
	public void onCreate(Bundle savedInstanceState) {
	        
			super.onCreate(savedInstanceState);
	        setContentView(R.layout.findstore);
	        mWebView = (WebView) findViewById(R.id.webview);
	        mWebView.getSettings().setJavaScriptEnabled(true);
	        mWebView.loadUrl("http://www.maps.google.com");
	 }

}
