package it.woodstocoasts.gpalistener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	// se la definisco come final mi diventa una costante
	int iContatore = 0;
    
	// definisco la TextView
	
	TextView t;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button b = (Button) findViewById(R.id.btnConta);
        
        // associo la textview chiamata output dove
        // visualizzo il valore incrementatp
       
        t = (TextView) findViewById(R.id.tvOutput);
        
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				// qui incremento per ogni click il contatore
				// occorre fare un cast SAFE (come dice CSO)
				// prima di incrementare il valore demtro la textview 
				// t.setText(Integer.toString(++iContatore));	
				t.setText(Integer.toString(++iContatore));	
			}
		}
        );
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void aggiornaTesto(View v){
    	
    	Button b = (Button) v;
    	b.setText("AGGIORNATO");
    	
    
    	
    	t.setText(Integer.toString(++iContatore));
    }
    
}
