package com.example.finalproject;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		}
		
		if(savedInstanceState == null) {
			DetailsFragment details = new DetailsFragment();
			details.setArguments(getIntent().getExtras());
			getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
			
		}
		
		
		
	}
		/*DownloadJsonTask myTask = new DownloadJsonTask();
		myTask.execute("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/in_theaters.json?apikey=mvcsjd4jfd6tdgg3hpsvstta");
		
		

		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	private class DownloadJsonTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			String blah = "json";
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(arg0[0]);
			try {
				HttpResponse response = client.execute(get);
				HttpEntity entity = response.getEntity();
				if(null != entity) {
					String result = EntityUtils.toString(entity);
					//do more stuff
					return result;
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		protected void onPostExecute(String result) {
			
		}
		
	}*/
	

}
