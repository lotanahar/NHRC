package com.example.sampleapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GooglemapActivity extends Activity {

	 MessangerDatabaseAdapter dbadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_googlemap);
		
		//dbadapter = new MessangerDatabaseAdapter(getApplicationContext());
        //dbadapter.open();
        
        WebView webView = (WebView) findViewById(R.id.googleWebView);
        //webView.setWebViewClient(new MyWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        
        webView.loadUrl("https://www.google.com.bd/maps/place/%E0%A6%AC%E0%A6%BE%E0%A6%82%E0%A6%B2%E0%A6%BE%E0%A6%A6%E0%A7%87%E0%A6%B6+%E0%A6%AE%E0%A6%BE%E0%A6%A8%E0%A6%AC%E0%A6%BE%E0%A6%A7%E0%A6%BF%E0%A6%95%E0%A6%BE%E0%A6%B0+%E0%A6%95%E0%A6%AE%E0%A6%BF%E0%A6%B6%E0%A6%A8/@23.746768,90.414771,17z/data=!4m7!1m4!3m3!1s0x3755b8fa92a35703:0xeb82fe9d14ffe6ff!2z4Kas4Ka-4KaC4Kay4Ka-4Kam4KeH4Ka2IOCmruCmvuCmqOCmrOCmvuCmp-Cmv-CmleCmvuCmsCDgppXgpq7gpr_gprbgpqg!3b1!3m1!1s0x3755b8fa92a35703:0xeb82fe9d14ffe6ff?hl=bn");
	}
	
	   private String makinglist(String appcode) {
	        SQLiteDatabase db = dbadapter.getDSqLiteDatabase();

	        Cursor cursor = db.query("PDBF", null, " APPCODE=?", new String[]{appcode}, null, null, null);

	        if (cursor.getCount() < 1) {

	            cursor.close();
	            return "NOT EXISTS";
	        }

	        cursor.moveToFirst();
	        String content = cursor.getString(cursor.getColumnIndex("CONTENT"));
	        cursor.close();

	        return content;

	    }
	   
	   private class MyWebViewClient extends WebViewClient {
		    @Override
		    public boolean shouldOverrideUrlLoading(WebView view, String url) {
		        if (Uri.parse(url).getHost().equals("https://www.google.com.bd/maps/place/%E0%A6%AC%E0%A6%BE%E0%A6%82%E0%A6%B2%E0%A6%BE%E0%A6%A6%E0%A7%87%E0%A6%B6+%E0%A6%AE%E0%A6%BE%E0%A6%A8%E0%A6%AC%E0%A6%BE%E0%A6%A7%E0%A6%BF%E0%A6%95%E0%A6%BE%E0%A6%B0+%E0%A6%95%E0%A6%AE%E0%A6%BF%E0%A6%B6%E0%A6%A8/@23.746768,90.414771,17z/data=!4m7!1m4!3m3!1s0x3755b8fa92a35703:0xeb82fe9d14ffe6ff!2z4Kas4Ka-4KaC4Kay4Ka-4Kam4KeH4Ka2IOCmruCmvuCmqOCmrOCmvuCmp-Cmv-CmleCmvuCmsCDgppXgpq7gpr_gprbgpqg!3b1!3m1!1s0x3755b8fa92a35703:0xeb82fe9d14ffe6ff?hl=bn")) {
		            // This is my web site, so do not override; let my WebView load the page
		            return false;
		        }
		        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
		        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		        startActivity(intent);
		        return true;
		    }
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.googlemap, menu);
		return true;
	}

}
