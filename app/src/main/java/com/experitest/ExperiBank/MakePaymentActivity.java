package com.experitest.ExperiBank;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MakePaymentActivity extends Activity {
	public int COUNTRY_REQUEST_ID = 1000;
	private SharedPreferences userPreferences;
	private EditText phoneEditField, nameEditField, amountEditField, countryEditField;
	private Button countryButton, sendPaymentButton, cancelButton;
	private AlertDialog.Builder alertDialog;

	private boolean readyToMakePayment()
	{
		return (phoneEditField.getText().length() > 0 && nameEditField.getText().length() > 0 && 
				amountEditField.getText().length() > 0 && countryEditField.getText().length() > 0);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.makepayment);

		userPreferences = PreferenceManager.getDefaultSharedPreferences(this);

		countryButton = (Button) findViewById(R.id.countryButton);
		sendPaymentButton = (Button) findViewById(R.id.sendPaymentButton);
		sendPaymentButton.setEnabled(false);
		cancelButton = (Button) findViewById(R.id.cancelButton);
		
		phoneEditField = (EditText) findViewById(R.id.phoneTextField);
		phoneEditField.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				if (readyToMakePayment()) 
					sendPaymentButton.setEnabled(true);
				else 
					sendPaymentButton.setEnabled(false);
			}

			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
		});

		nameEditField = (EditText) findViewById(R.id.nameTextField);
		nameEditField.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				if (readyToMakePayment()) 
					sendPaymentButton.setEnabled(true);
				else 
					sendPaymentButton.setEnabled(false);
			}

			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
		});
		
		amountEditField = (EditText) findViewById(R.id.amountTextField);
		amountEditField.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				if (readyToMakePayment()) 
					sendPaymentButton.setEnabled(true);
				else 
					sendPaymentButton.setEnabled(false);
			}

			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
		});
		
		countryEditField = (EditText) findViewById(R.id.countryTextField);
		countryEditField.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				if (readyToMakePayment()) 
					sendPaymentButton.setEnabled(true);
				else 
					sendPaymentButton.setEnabled(false);
			}

			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
		});
		
		alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("EriBank");
		alertDialog.setMessage("Are you sure you want to send payment?");
		alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
		alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				float balance = userPreferences.getFloat("Balance", LoginActivity.INIT_BALANCE);
				float amount = Float.parseFloat(amountEditField.getEditableText().toString());

				SharedPreferences.Editor prefsEditr = userPreferences.edit();
				prefsEditr.putBoolean("Refilled", true);
				prefsEditr.putFloat("Balance", balance - amount);
				prefsEditr.commit();
				finish();
			}
		}).setNegativeButton("No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});

		countryButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Intent intent = new Intent(MakePaymentActivity.this, CountryListActivity.class);
					startActivityForResult(intent, COUNTRY_REQUEST_ID);
				} catch (Exception ex) {
					Log.e(this.getClass().getName(), "Error : " + ex.getMessage(), ex);
				}
			}
		});

		sendPaymentButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					if (phoneEditField.getEditableText().toString().length() > 0 && nameEditField.getEditableText().toString().length() > 0 && amountEditField.getEditableText().toString().length() > 0) {
						alertDialog.show();
					}
				} catch (Exception ex) {
					Log.e(this.getClass().getName(), "Error : " + ex.getMessage(), ex);
				}
			}
		});

		cancelButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					finish();
				} catch (Exception ex) {
					Log.e(this.getClass().getName(), "Error : " + ex.getMessage(), ex);
				}
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK && requestCode == COUNTRY_REQUEST_ID) {
			String country = data.getStringExtra("SelectedCountry");
			countryEditField.setText(country);
			if (readyToMakePayment()) 
				sendPaymentButton.setEnabled(true);
		}
	}
}
