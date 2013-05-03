package com.example.finalproject;

public class User {
	int _id;
	String _name;
	String _email;
	String _password;
	
	public User() {
		
	}
	
	public User(int id, String name, String email, String password) {
		this._id = id;
		this._name = name;
		this._email = email;
		this._password = password;
	}
	public User(String name, String email, String password) {
		this._name = name;
		this._email = email;
		this._password = password;
	}
	
	public int getID() {
		return this._id;
	}
	public void setID(int id) {
		this._id = id;
	}
	public String getName() {
		return this._name;
	}
	public void setName(String name) {
		this._name = name;
	}
	public String getEmail() {
		return this._email;
	}
	public void setEmail(String email) {
		this._email = email;
	}
	public String getPassword() {
		return this._password;
	}
	public void setPassword(String password) {
		this._password = password;
	}
}
