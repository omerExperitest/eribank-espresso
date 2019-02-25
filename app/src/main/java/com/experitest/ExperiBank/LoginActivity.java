package com.experitest.ExperiBank;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.Toast;

public class LoginActivity extends Activity {
	/** Called when the activity is first created. */
	final Context context = this;
	public static float INIT_BALANCE = 100;
	private SharedPreferences userPreferences;
	private EditText userNameEditField, passwordEditField;
	private Button loginButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		startService();
		setContentView(R.layout.main);

		try {
			PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
			pInfo.versionName = pInfo.versionName + "." + getVersion();
			setTitle("Build Version : " + pInfo.versionName);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

		userPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		userNameEditField = (EditText) findViewById(R.id.usernameTextField);
		passwordEditField = (EditText) findViewById(R.id.passwordTextField);
		loginButton = (Button) findViewById(R.id.loginButton);

		loginButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					if (userNameEditField.getEditableText().toString().trim().equalsIgnoreCase("company") && passwordEditField.getEditableText().toString().trim().equalsIgnoreCase("company")) {

						Boolean isRefilled = userPreferences.getBoolean("Refilled", false);
						if (!isRefilled) {
							SharedPreferences.Editor prefsEditr = userPreferences.edit();
							prefsEditr.putBoolean("Refilled", true);
							prefsEditr.putFloat("Balance", INIT_BALANCE);
							prefsEditr.commit();
						}
						finish();
						startActivity(new Intent(LoginActivity.this, PaymentHomeActivity.class));
					} else {
						AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
						alertDialog.setTitle("Error").setMessage("Invalid username or password!");
						alertDialog.setNeutralButton("Close", null).show();
					}
				} catch (Exception ex) {
					Log.e(this.getClass().getName(), "Error : " + ex.getMessage(), ex);
				}
			}
		});
	}
//	public void startService() {
//		startService(new Intent(getBaseContext(), com.experitest.android.InstService.class)); //was experience
//	}
	public String getVersion() {
		String valueToReturn = "Not valid";
		String temp;
		Properties buildNum = new Properties();
		try {
			InputStream rawResource = getResources().openRawResource(R.raw.version_number);
			buildNum.load(rawResource);
			temp = buildNum.getProperty("build.number");
		} catch (Resources.NotFoundException e) {
			System.err.println("Did not find raw resource: " + e);
			return valueToReturn;
		} catch (IOException e) {
			System.err.println("Failed to open property file");
			return valueToReturn;
		} catch (Exception e) {
			System.err.println("Failed to get 'build.number' property frome version_number file.");
			return valueToReturn;
		}
		if (temp != null) {
			if (temp.length() > 0) {
				valueToReturn = temp.toString().trim();
			}
		}
		return valueToReturn;
	}
//	public void stopService() {
//		stopService(new Intent(getBaseContext(), com.experitest.android.InstService.class));
//	}
//
//	@Override
//	public void onDestroy(){
//		super.onDestroy();
//		stopService();
//	}

}