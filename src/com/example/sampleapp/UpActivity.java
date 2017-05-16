package com.example.sampleapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class UpActivity extends Activity {

	 MessangerDatabaseAdapter dbdapter;
	 Button up;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_up);
		up = (Button) findViewById(R.id.Upbutton);
		dbdapter=new MessangerDatabaseAdapter(getApplicationContext());
        dbdapter.open();
        
        up.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 for(int i=0;i<8;i++)
	                    new DataReader().execute();
				
			}
		});
        
	}
    public class DataReader extends AsyncTask {
        Dialog dialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            dialog = new Dialog(getApplicationContext());
            dialog.setTitle("Please wait");
            dialog.show();
        }

        @Override
        public Object doInBackground(Object... params) {
            //MainActivity.content=null;
            HttpClient client = new DefaultHttpClient();
            HttpConnectionParams.setConnectionTimeout(client.getParams(), 100000); //Timeout Limit
            HttpResponse response;
            JSONObject json = new JSONObject();
            String data = " {\"app_id\":\"136\"} ";

            StringEntity entity1 = null;
            try {
                entity1 = new StringEntity(data);
            } catch (UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }


            System.out.println("data: " + data);
            //  Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
            try {
                HttpPost post = new HttpPost("http://api.national500apps.com/index.php?r=apiMenu/Getmenu");
                post.setEntity(new StringEntity(data));

                entity1.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                //post.setEntity(se);
                response = client.execute(post);



                HttpEntity entity = response.getEntity();
                InputStream is = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();

                String line = null;
                try {
                    while ((line = reader.readLine()) != null) {
                        sb.append((line + "\n"));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    JSONObject jsonObject = new JSONObject(sb.toString());
                    System.out.println("Response" + jsonObject.toString());
                    System.out.println("SB" + sb.toString());
                    JSONArray jarray = jsonObject.getJSONArray("Menu");


                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject oob = jarray.getJSONObject(i);
                        String appcode = oob.getString("app_code");
                        System.out.println("APPCODE==  " + appcode);
                        String contentt = oob.getString("content");
                        System.out.println("CONTENT==  " + contentt);

                        String dbcontent=dbdapter.getSingleEntey(appcode);

                        if(!dbcontent.equals(contentt)){

                            dbdapter.changePassword(appcode,contentt);
                        }




                    }

                    //Toast.makeText(getApplicationContext(), jsonObject.toString(), Toast.LENGTH_SHORT).show();


                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
                // createDialog("Error", "Cannot Estabilish Connection");
            }
            if (dialog.isShowing()) {

                dialog.dismiss();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object result) {
            // TODO Auto-generated method stub

            System.out.println("sample\n\n\n");
        }


    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.up, menu);
		return true;
	}

}
