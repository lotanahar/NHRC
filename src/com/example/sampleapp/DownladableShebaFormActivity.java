package com.example.sampleapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DownladableShebaFormActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_downladable_sheba_form);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.downladable_sheba_form, menu);
		return true;
	}

}
