package com.example.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "usersManager";
	private static final String TABLE_USERS = "users";
	
	private static final String KEY_ID = "User_id";
	private static final String KEY_NAME = "name";
	private static final String KEY_EMAIL = "email";
	private static final String KEY_PW = "pw";
	
	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USERS + "(" 
				+ KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + "TEXT," 
				+KEY_EMAIL + " TEXT," + KEY_PW + " TEXT" + ")";
		db.execSQL(CREATE_USER_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
		onCreate(db);
	}
	public void addUser(User user) {
		
	}
	public User getUser(int id){
		
	}
	public List<User> getAllUsers() {
		
	}
	public int getListCount() {
		
	}
	public int updateUser(User user) {
		
	}
	public void deleteUser(User user) {
		
	}

}
