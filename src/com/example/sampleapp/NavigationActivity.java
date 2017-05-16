package com.example.sampleapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class NavigationActivity extends Activity {
	Button b1, b2, b3, b4, b5, b6, b7, b8, b9;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_navigation);

		b1 = (Button) findViewById(R.id.button1);
		//b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button7);
		//b5 = (Button) findViewById(R.id.button4);
		//b6 = (Button) findViewById(R.id.button5);
		b7 = (Button) findViewById(R.id.button6);
		b8 = (Button) findViewById(R.id.button8);
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(NavigationActivity.this,
						AboutActivity.class);
				startActivity(intent);

			}
		});
	/*	b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(NavigationActivity.this,
						ProkolpoActivity.class);
				startActivity(intent);

			}
		}); */

		b3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(NavigationActivity.this,
						KormokortaActivity.class);
				startActivity(intent);

			}
		});
		b4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(NavigationActivity.this,
						JogajogActivity.class);
				startActivity(intent);

			}
		});
		/*
		b5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(NavigationActivity.this,
						JogajogActivity.class);
				startActivity(intent);

			}
		});
		b6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(NavigationActivity.this,
						GooglemapActivity.class);
				startActivity(intent);

			}
		});*/
		b7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(NavigationActivity.this,
						GooglemapActivity.class);
				startActivity(intent);

			}
		});
		b8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(NavigationActivity.this,
						UpActivity.class);
				startActivity(intent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.navigation, menu);
		return true;
	}

}
