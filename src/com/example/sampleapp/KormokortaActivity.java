package com.example.sampleapp;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.Window;
import android.webkit.WebView;

public class KormokortaActivity extends Activity {

	 MessangerDatabaseAdapter dbadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_kormokorta);
		dbadapter = new MessangerDatabaseAdapter(getApplicationContext());
        dbadapter.open();
        
        WebView webView = (WebView) findViewById(R.id.kormokortaWebView);
        String customHtml = makinglist("KormokortaInformation");
        webView.loadData(customHtml, "text/html; charset=UTF-8", null);
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kormokorta, menu);
		return true;
	}

}
