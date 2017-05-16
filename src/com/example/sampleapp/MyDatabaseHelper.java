package com.example.sampleapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyDatabaseHelper extends SQLiteOpenHelper {

	public MyDatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(MessangerDatabaseAdapter.TABLE_SEND);

 	  
 	   
 	  ContentValues values1=new ContentValues();
 	  values1.put("APPCODE", "DoptorInformation");
 	  values1.put("CONTENT","<html><body><h3><strong> জাতীয় মানবাধিকার কমিশন প্রতিষ্ঠা (এনএইচআরসি)</strong></h3>"+

   "<p style=\"text-align:justify\">বাংলাদেশ জাতীয় মানবাধিকার কমিশন মানবাধিকার প্রচার এবং সুরক্ষার জন্য একটি জাতীয় অ্যাডভোকেসি প্রতিষ্ঠান হিসেবে 2009 সালে পুনর্গঠিত হয় । " +
   "বাংলাদেশ স্বাক্ষরকারী যা বাংলাদেশ এবং বিভিন্ন আন্তর্জাতিক মানবাধিকার নিয়মাবলী এবং চুক্তি গণপ্রজাতন্ত্রী সংবিধানে সন্নিবেশিত হিসাবে এটা, মর্যাদা, মূল্য এবং প্রত্যেক মানুষের স্বাধীনতা সহ একটি বৃহত্তর অর্থে মানবাধিকার," +
   " নিষ্পাদন করতে প্রতিশ্রুতিবদ্ধ হয়। </p>" +
   "<p style=\"text-align:justify\">এরকম গৌরবমন্ডিত প্রতিষ্ঠান প্রতিষ্ঠার উদ্দেশ্য গণতন্ত্রের মৌলিক আদেশ রক্ষাকবচ হিসেবে মানুষের মর্যাদা ও অখণ্ডতা এর প্রতিমূর্তি রক্ষা করা যাতে সব মানুষের অবিচ্ছেদ্য মৌলিক অধিকার রক্ষা  হয় এবং দেশে মানবাধিকার উন্নত হয় ।</p>" +
   "<p style=\"text-align:justify\">এনএইচআরসি আন্তর্জাতিক মানবাধিকার আইন বাংলাদেশের অঙ্গীকারের সঙ্গে সাদৃশ্য রেখে জাতীয় মানবাধিকার কমিশন আইন, ২০০৯ দ্বারা প্রতিষ্ঠিত,কমিশনটি মানুষের অধিকার আদায় এর জন্য একটি প্রক্রিয়া হিসেবে কাজ করছে। এর উদ্দেশ্য মানবাধিকার বিষয়ে সাধারন মানুষকে জ্ঞানদান এর মাধ্যমে " +
   "একটি মানবাধিকার সংস্কৃতি তৈরি করা যাতে দেশের জনগণ প্রগতিশীল আশা-আকাঙ্খার সঙ্গে দেশের বৃহত্তর শান্তি ও নিরাপত্তা পালন অবদান রাখতে পারে। </p></body></html>");
 	  db.insert("PDBF", null, values1);
 	  
 	  ContentValues values2=new ContentValues();
 	 values2.put("APPCODE", "ProkolpoInformation");
	  values2.put("CONTENT","<html><body>এনএইচআরসি কৌশলগত পরিকল্পনা খসড়া (২০১৫-২০১৮)<br/>কৌশলগত পরিকল্পনা (২০১০-১০১৫)</body></html>");
	  db.insert("PDBF", null, values2);

        ContentValues values3=new ContentValues();
        values3.put("APPCODE", "KormokortaInformation");
        values3.put("CONTENT","<html><body><strong>প্রফেসর ড মিজানুর রহমান, চেয়ারম্যান </strong><br/><br/>" +
        		"<strong>কাজী রিয়াজুল হক, সম্পূর্ণ সদস্য </strong><br/><br/>" +
        		"<strong>অধ্যাপক মাহফুজা খানম, অনারারি সদস্য </strong><br/><br/>" +
        		"<strong>সেলিনা হোসেন, অনারারি সদস্য </strong><br/><br/>" +
        		"<strong>অরমা,অনারারি সদস্য </strong><br/><br/>" +
        		"<strong>সুবাস দত্ত, অনারারি সদস্য </strong><br/><br/>" +
        		"<strong>নিরুপা দেওয়ান, অনারারি সদস্য</strong><br/></body></html>");
        db.insert("PDBF", null, values3);

        ContentValues values4=new ContentValues();
        values4.put("APPCODE", "SebaInformation");
        values4.put("CONTENT","<html><body><h3><strong> জাতীয় মানবাধিকার কমিশন প্রতিষ্ঠা (এনএইচআরসি)</strong></h3>"+

   "<p>বাংলাদেশ জাতীয় মানবাধিকার কমিশন মানবাধিকার প্রচার এবং সুরক্ষার জন্য একটি জাতীয় অ্যাডভোকেসি প্রতিষ্ঠান হিসেবে 2009 সালে পুনর্গঠিত হয় । " +
   "বাংলাদেশ স্বাক্ষরকারী যা বাংলাদেশ এবং বিভিন্ন আন্তর্জাতিক মানবাধিকার নিয়মাবলী এবং চুক্তি গণপ্রজাতন্ত্রী সংবিধানে সন্নিবেশিত হিসাবে এটা, মর্যাদা, মূল্য এবং প্রত্যেক মানুষের স্বাধীনতা সহ একটি বৃহত্তর অর্থে মানবাধিকার," +
   " নিষ্পাদন করতে প্রতিশ্রুতিবদ্ধ হয় । </p></body></html>");
        db.insert("PDBF", null, values4);

        ContentValues values5=new ContentValues();
        values5.put("APPCODE", "JogajogInformation");
        values5.put("CONTENT","<html><body>জাতীয় মানবাধিকার কমিশন<br>গুলফ্যাশন  প্লাজা (১১ তলা)<br>" +
        		"৮, শহীদ সাংবাদিক  সেলিনা পারভীন সড়ক, মগবাজ়ার <br>ঢাকা-১২১৭, বাংলাদেশ<br><br><br>" +
        		"<strong>ফোন: <strong><a style=\"color:black; text-decoration: none\" href=\"tel: ৮৮-০২-৮ ৩৩১৪৯২\" >৮৮-০২-৮ ৩৩১৪৯২</a>;<br>" +
        		"<strong>চেয়ারম্যান: <strong> <a style=\"color:black; text-decoration: none\" href=\"tel: ৮৮-০২-৯৩৩৫৬১৩\" >৮৮-০২-৯৩৩৫৬১৩</a>;<br>" +
        		"<strong>সম্পূর্ণ সময় সদস্য: </strong><a style=\"color:black; text-decoration: none\" href= \"tel: ৮৮-০২-৯৩৩৬৩৬৩\" >৮৮-০২-৯৩৩৬৩৬৩</a>;<br>" +
        		"<strong>সচিব: </strong><a style=\" color:black; text-decoration: none\" href=\"tel: ৮৮-০২-৯৩৩৯৮৯৩\" >৮৮-০২-৯৩৩৯৮৯৩</a>;<br>" +
        		"ফ্যাক্স: ৮৮-০২-৮৩৩৩২১৯;<br>" +
        		" <strong>ইমেইল: <stnong>nhrc.bd@gmail.com</body></html>");
        db.insert("PDBF", null, values5);

        ContentValues values6=new ContentValues();
        values6.put("APPCODE", "GoogleMapInformation");
        values6.put("CONTENT","<html><body><p>hello from all Google map</p></body></html>");
        db.insert("PDBF", null, values6);

        ContentValues values7=new ContentValues();
        values7.put("APPCODE", "OvijogInformation");
        values7.put("CONTENT","<html><body>অভিযোগ পেশ করুন</body></html>");
        db.insert("PDBF", null, values7);

        ContentValues values8=new ContentValues();
        values8.put("APPCODE", "DownloadAbleFormInformation");
        values8.put("CONTENT","<html><body><p>hello from all Download</p></body></html>");
        db.insert("PDBF", null, values8);

		Log.w("DATABASE: ", db.getPath());
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + "PDBFS");

		onCreate(db);

	}

}
