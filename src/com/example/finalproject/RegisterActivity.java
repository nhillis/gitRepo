package com.example.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity {
	Button mButton;
	EditText mNameText, mEmailText, mPasswordText;
	String name, email, password;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_layout);
		
		
		mButton = (Button) findViewById(R.id.buttonRegister);
		mNameText = (EditText) findViewById(R.id.reg_fullname);
		mEmailText = (EditText) findViewById(R.id.reg_email);
		mPasswordText = (EditText) findViewById(R.id.reg_password);
		
		mButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				name = mNameText.getText().toString();
				email = mEmailText.getText().toString();
				password = mPasswordText.getText().toString();
				
				DatabaseHandler db = new DatabaseHandler(getBaseContext());
				
				db.addUser(new User(name, email, password));
				
				
				finish();
			}
		});
		
		
		
		
		
		TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
		
		loginScreen.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				finish();
			}
		});
	}
}
