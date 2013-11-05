package it.woodstocoasts.gpacalcoli;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		int base = getIntent().getIntExtra("base", 0);
		int altezza = getIntent().getIntExtra("altezza", 0);
		
		TextView t = (TextView) findViewById(R.id.risultato);
		
		int perimetro = base * 2 + altezza * 2;
		int area = base * altezza;
		
		t.setText("Il perimetro è: " + perimetro + "\n" + "L'area è: " + area);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
