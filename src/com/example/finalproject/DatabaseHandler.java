package com.example.finalproject;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, user.getName());
		values.put(KEY_EMAIL, user.getEmail());
		values.put(KEY_PW, user.getPassword());
		
		db.insert(TABLE_USERS, null, values);
		db.close();
	}
	public User getUser(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.query(TABLE_USERS, new String[] {KEY_ID, 
				KEY_NAME, KEY_EMAIL, KEY_PW } , KEY_ID + "=?",
				new String[] {String.valueOf(id) }, null, null, null, null);
		
		if(cursor != null)
			cursor.moveToFirst();
		
		User user = new User(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2), cursor.getString(3));
		
		return user;
		
	}
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
		
		String selectQuery = "SELECT * FROM " + TABLE_USERS;
		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		
		if(cursor.moveToFirst()){
			do {
				User user = new User();
				user.setID(Integer.parseInt(cursor.getString(0)));
				user.setName(cursor.getString(1));
				user.setEmail(cursor.getString(2));
				user.setPassword(cursor.getString(3));
				
				userList.add(user);
			} while(cursor.moveToNext());
		}
		
		return userList;
	}
	public int getListCount() {
		String countQuery = "SELECT * FROM " + TABLE_USERS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();
		
		return cursor.getCount();
	}
	public int updateUser(User user) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, user.getName());
		values.put(KEY_EMAIL, user.getEmail());
		values.put(KEY_PW, user.getPassword());
		
		return db.update(TABLE_USERS, values, KEY_ID + " =?",
				new String[] { String.valueOf(user.getID()) } );
		
	}
	public void deleteUser(User user) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_USERS, KEY_ID + " =?", 
				new String[] { String.valueOf(user.getID()) });
		db.close();
	}

}
