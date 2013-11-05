package it.woodstocoasts.gpacalcoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void CalcAndSendTO (View v){
    	
    	EditText b = (EditText) findViewById(R.id.editTextBase);
    	EditText a = (EditText) findViewById(R.id.editTextAltezza);
    	
    	Intent i = new Intent(getApplicationContext(), SecondActivity.class);
 
    	i.putExtra("base", Integer.parseInt(b.getText().toString()));
    	i.putExtra("altezza", Integer.parseInt(a.getText().toString()));
    	
    	startActivity(i);
    
    	
    	
    }
    
}
