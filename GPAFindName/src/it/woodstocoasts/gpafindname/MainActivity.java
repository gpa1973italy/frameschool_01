package it.woodstocoasts.gpafindname;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	 EditText e;
	 TextView tv ;  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
		  e = (EditText) findViewById(R.id.editTextName);
		  tv = (TextView) findViewById(R.id.textViewEsito);  
       
        
        Button b = (Button) findViewById(R.id.btnFindName);
        
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		
				 String[] myNamesList = getResources().getStringArray(R.array.arNames);
				boolean b = false;
				 
				for(int iCounter = 0; iCounter < myNamesList.length; iCounter++)
				{
					
					if (e.getText().toString().equalsIgnoreCase(myNamesList[iCounter])) 
					{
						// ****** DEPRECATO!!!
						//tv.setText("TROVATO!");
						//break;
						b = true;
					}

				}
				
				tv.setText(b?"TROVATO!": "NON TROVATO");
				
				Toast.makeText(getApplicationContext(), b?"NOME \n TROVATO!": "NOME \n NON TROVATO", Toast.LENGTH_SHORT).show();
				
				// Scrivo nel LOG di LOGCAT
				Log.i(NOTIFICATION_SERVICE, "CIAO");
			}
		});
        

        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    // 
    public void Launch2ndActivity (View p){

    	// Creo l'Intent
    	Intent i = new Intent(getApplicationContext(), SecondActivity.class);
    	
    	// Lancio l'Intent
    	startActivity(i);
    	
    }
 }
    

