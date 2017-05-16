package com.example.sampleapp;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.format.Time;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class StartActivity extends Activity {

	int timerDelay = 3000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_start);
		
	new Timer().schedule(timerTask,timerDelay);
		
		/*Thread splash_screen = new Thread(){
            public void run(){
                try{
                    sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally{
                    startActivity(new Intent(getApplicationContext(), NavigationActivity.class));
                    finish();
                }
            }
        };
        splash_screen.start(); */
	}

	TimerTask timerTask = new TimerTask() {
		
		@Override
		public void run() {
			startActivity(new Intent(StartActivity.this, NavigationActivity.class));
			finish();
		}
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

}
