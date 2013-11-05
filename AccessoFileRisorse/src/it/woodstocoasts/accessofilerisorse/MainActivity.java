package it.woodstocoasts.accessofilerisorse;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView myTxt = (TextView)findViewById(R.id.testodaarray);
        
        String[] arValori = getResources().getStringArray(R.array.dati);
        
        String sTmp ="";
        
        for(int i = 0; i < arValori.length; i++ )
        
        {
        	
        	sTmp = sTmp + arValori[i] + "\n";
        			
        }
        
        myTxt.setText(sTmp);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
