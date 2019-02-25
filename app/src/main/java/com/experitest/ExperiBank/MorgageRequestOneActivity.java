package com.experitest.ExperiBank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MorgageRequestOneActivity extends Activity {
	public int COUNTRY_REQUEST_ID = 1000;
	public int SUBMIT_REQUEST_ID = 2000;

	private EditText countryEditField;
	private Button countryButton, nextButton, cancelButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.morgagerequestone);

		countryEditField = (EditText) findViewById(R.id.countryTextField);
		countryButton = (Button) findViewById(R.id.countryButton);
		nextButton = (Button) findViewById(R.id.nextButton);
		cancelButton = (Button) findViewById(R.id.cancelButton);

		countryButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Intent intent = new Intent(MorgageRequestOneActivity.this, CountryListActivity.class);
					startActivityForResult(intent, COUNTRY_REQUEST_ID);
				} catch (Exception ex) {
					Log.e(this.getClass().getName(), "Error : " + ex.getMessage(), ex);
				}
			}
		});

		nextButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Intent intent = new Intent(MorgageRequestOneActivity.this, MorgageRequestTwoActivity.class);
					startActivityForResult(intent, SUBMIT_REQUEST_ID);
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
		} else if (resultCode == RESULT_OK && requestCode == SUBMIT_REQUEST_ID) {
			String submit = data.getStringExtra("LoanSubmit");
			if(submit.equalsIgnoreCase("yes"))
				finish();
		}
	}
}
