package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	Button mButton;
	EditText mEmailText, mPasswordText;
	String email, password;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		
		mButton = (Button) findViewById(R.id.buttonLogin);
		mEmailText = (EditText) findViewById(R.id.email);
		mPasswordText = (EditText) findViewById(R.id.password);
		
		mButton.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				
				email = mEmailText.getText().toString();
				password = mPasswordText.getText().toString();
				
				
				DatabaseHandler db = new DatabaseHandler(getBaseContext());
				
				if(db.getListCount() == 1) {
					Toast.makeText(getBaseContext(), "login", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
		
		TextView registerScreen= (TextView) findViewById(R.id.register_link);
		
		registerScreen.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(i);
			}
		});
		
		
	}
}
