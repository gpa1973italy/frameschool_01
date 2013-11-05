package it.woodstocoasts.gpascambiodati;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		int myPassedValue = getIntent().getIntExtra("eta", 0);
		
		TextView t1 = (TextView) findViewById(R.id.showvalue);
		
		t1.setText("Il mio valore è:" + myPassedValue);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
