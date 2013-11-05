package it.woodstocoast.gpahelloworld;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    // onCreate quando l'Activity viene generata
	// Bundle sono le tabelle hash in cui registra i dati della Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // questa "tira su la schermata" di Activity_main
        setContentView(R.layout.activity_main);
        
        TextView testo = (TextView) findViewById(R.id.textView1);
        testo.setText("AWANAGANA!");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
