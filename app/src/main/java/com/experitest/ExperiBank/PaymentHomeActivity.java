package com.experitest.ExperiBank;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class PaymentHomeActivity extends Activity {
	private SharedPreferences userPreferences;
	private WebView balanceWebView;
	private Button makePaymentButton, morgageRequestButton, expenseReportButton, logoutButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paymenthome);
        
        userPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        
        balanceWebView = (WebView) findViewById(R.id.balanceWebView);
        makePaymentButton = (Button) findViewById(R.id.makePaymentButton);
        morgageRequestButton = (Button) findViewById(R.id.mortageRequestButton);
        expenseReportButton = (Button) findViewById(R.id.expenseReportButton);
        logoutButton = (Button) findViewById(R.id.logoutButton);
        
        String customHtml = "<html><body><h1 align='center'>Your balance is: <br/>" + String.format("%02.02f", userPreferences.getFloat("Balance", 100)) + "$" + "</h1></body></html>";
        balanceWebView.loadData(customHtml,"text/html", "UTF-8");
        
        makePaymentButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					startActivity(new Intent(PaymentHomeActivity.this, MakePaymentActivity.class));
				} catch (Exception ex) {
					Log.e(this.getClass().getName(), "Error : " + ex.getMessage(), ex);
				}
			}
		});
        morgageRequestButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					startActivity(new Intent(PaymentHomeActivity.this, MorgageRequestOneActivity.class));
				} catch (Exception ex) {
					Log.e(this.getClass().getName(), "Error : " + ex.getMessage(), ex);
				}
			}
		});
        expenseReportButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					startActivity(new Intent(PaymentHomeActivity.this, ExpenseReportActivity.class));
				} catch (Exception ex) {
					Log.e(this.getClass().getName(), "Error : " + ex.getMessage(), ex);
				}
			}
		});
        logoutButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					finish();
					startActivity(new Intent(PaymentHomeActivity.this, LoginActivity.class));
				} catch (Exception ex) {
					Log.e(this.getClass().getName(), "Error : " + ex.getMessage(), ex);
				}
			}
		});
    }
    
    @Override
	protected void onResume() {
		super.onResume();
		String customHtml = "<html><body><h1 align='center'>Your balance is: <br/>" + String.format("%02.02f", userPreferences.getFloat("Balance", 100)) + "$" + "</h1></body></html>";
        balanceWebView.loadData(customHtml,"text/html", "UTF-8");
    }
}
