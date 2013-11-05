package it.woodstocoasts.gpa_giorni_pari_dispari;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.util.Calendar;

public class GiorniPari extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        
        Calendar calendario = Calendar.getInstance();
        int giorno = calendario.get(Calendar.DATE);
        
        if (giorno%2 == 0)
        {
        	setContentView(R.layout.activity_giorni_pari);
        }
        else
        {
        	setContentView(R.layout.activity_giorni_dispari);
        }
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.giorni_pari, menu);
        return true;
    }
    
}
