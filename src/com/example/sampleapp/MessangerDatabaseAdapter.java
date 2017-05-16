package com.example.sampleapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.Gravity;
import android.widget.Toast;

public class MessangerDatabaseAdapter {
	
	static  String DATABASE_NAME="Messages.db";
	static final int VERSION=1;

	public static final String TABLE_SEND = "create table "+"PDBF"+"( "+"ID"+" integer primary key autoincrement,"+ "APPCODE  text,CONTENT text); ";
	
	private final Context context;
	
	
	SQLiteDatabase db;
	
	private MyDatabaseHelper dbHelper;

	public MessangerDatabaseAdapter(Context con) {
		context=con;
		dbHelper=new MyDatabaseHelper(context,DATABASE_NAME,null,VERSION);
	}

	public MessangerDatabaseAdapter open() throws SQLException{
		db=dbHelper.getReadableDatabase();
		return this;
	}
	
	public void close(){
		db.close();
	}

	public SQLiteDatabase getDSqLiteDatabase(){
		return db;
	}
	public String getSingleEntey(String userName) {
		Cursor cursor=db.query("PDBF", null, " APPCODE=?", new String[]{userName}, null, null, null);
		
		if(cursor.getCount()<1){

			cursor.close();
			return "NOT EXISTS";
		}
		
		cursor.moveToFirst();
		String password=cursor.getString(cursor.getColumnIndex("CONTENT"));
		cursor.close();
		return password;
	
	}

	public void insertEntery(String phone, String message,String date) {
		ContentValues values=new ContentValues();
		values.put("PHONE", phone);
		values.put("MESSAGE", message);
		values.put("DATE", date);
		
		db.insert("SENDMESSAGE", null, values);
		
		
	}

	public boolean checkingUsernameExists(String username) {
		Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{username}, null, null, null);
		if(cursor.getCount()>=1){
			
			return false;
		}
		
		else{
			return true;
		}
		
		
	}
	
	public void changePassword(String username,String password){
		ContentValues nwValues=new ContentValues();
		nwValues.put("APPCODE", username);
		nwValues.put("CONTENT", password);
		db.update("PDBF", nwValues, "APPCODE= ?", new String[]{username});
		Toast toast=Toast.makeText(context, "Information updated successfully", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
		
	}

	public void deleteEnteyfromDatabase(String name) {
		db.delete("LOGIN", " USERNAME=?", new String[]{name});
		
		Toast toast=Toast.makeText(context, "The Account named "+name+" Has been Deactivated ", Toast.LENGTH_LONG);
		
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
		
		
	}

	

}
