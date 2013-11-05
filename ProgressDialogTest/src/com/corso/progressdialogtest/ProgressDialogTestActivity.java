package com.corso.progressdialogtest;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.SearchManager.OnCancelListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

public class ProgressDialogTestActivity extends Activity {

	// Identificatore della ProgressDialog
	private final static int PROGRESS_DIALOG = 1;

	// Riferimento alla ProgressDialog
	private ProgressDialog progressDialog;
	
	// Riferimento al Thread di simulazione job
	private CustomThread workerThread;

	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

	}

	public void manageIndeterminate(View view) {
		ProgressDialog.show(this,"Attendere... premere ESC per interrompere", "Elaborazione in corso",
				false, true, new DialogInterface.OnCancelListener() {

					@Override
					public void onCancel(DialogInterface dialog) {
						
						Toast.makeText(ProgressDialogTestActivity.this,
								"Elaborazione interrotta", Toast.LENGTH_LONG).show();

					}

				});
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case PROGRESS_DIALOG:
			return createProgressDialog();
		default:
			return null;
		}
	}
	
	
	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		switch (id) {
		case PROGRESS_DIALOG:
			workerThread.start();
			break;
		default:
			// None
		}
	}

	public void manageProgress(View view) {
		showDialog(PROGRESS_DIALOG);
	}
	
	
	/*
	 * Medoto di creazione della finestra di dialogo ProgressDialog
	 * il widget ProgressDialog() viene creato al volo
	 */
	private ProgressDialog createProgressDialog() {
		progressDialog = new ProgressDialog(this);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.setMessage("Caricamento...");
		progressDialog.setOnCancelListener(new OnCancelListener() {

			public void onCancel(DialogInterface dialog) {
				// Fermiamo il Thread
				Toast.makeText(ProgressDialogTestActivity.this,
						"Elaborazione interrotta", Toast.LENGTH_LONG).show();

				workerThread.stop();
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				
			}

		});
		workerThread = new CustomThread(myHandler);
		return progressDialog;
	}
	
	/*
	 * Definiamo un Handler per l'interazione tra il thread di gestion della UI
	 * ed un thread per l'eecuzione di una attività
	 */
	final Handler myHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			int currentValue = msg.getData().getInt("currentValue");
			progressDialog.setProgress(currentValue);
			if (currentValue >= 100) {
				dismissDialog(PROGRESS_DIALOG);
				workerThread.stop();
			}
		}
	};

	private class CustomThread implements Runnable {
		// Incremento del valore di progress
		final int INC = 2;
		// Riferimento all'Handler per l'invio dei messaggi
		Handler myHandler;
		// Stato del Thread
		boolean running = false;
		// Valore da visualizzare
		int progressValue;
		// Thread currente
		Thread thread;

		public CustomThread(Handler myHandler) {
			this.myHandler = myHandler;
		}

		// Corpo del Thread
		@Override
		public void run() {
			while (running) {
				// Attendiamo
				try {
					Thread.sleep(50);
				} catch (InterruptedException ie) {
				}
				progressValue += INC;
				// Notifichiamo il valore attraverso l'Handler
				notifyValue(progressValue);
			}

		}

		public void start() {
			if (!running) {
				running = true;
				progressValue = 0;
				thread = new Thread(this);
				thread.start();
			}
		}

		public void stop() {
			if (running) {
				running = false;
				thread = null;
			}
		}

		/*
		 * Notifica del valore attraverso l'handler
		 */
		private void notifyValue(int value) {
			Message msg = myHandler.obtainMessage();
			Bundle b = new Bundle();
			b.putInt("currentValue", value);
			msg.setData(b);
			myHandler.sendMessage(msg);
		}
	}

}