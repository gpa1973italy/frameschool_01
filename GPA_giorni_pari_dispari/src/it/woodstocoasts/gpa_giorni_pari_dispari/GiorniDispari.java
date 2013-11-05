package it.woodstocoasts.gpa_giorni_pari_dispari;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GiorniDispari extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_giorni_dispari);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.giorni_dispari, menu);
		return true;
	}

}
