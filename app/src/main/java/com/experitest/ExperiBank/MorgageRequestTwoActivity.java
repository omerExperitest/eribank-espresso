package com.experitest.ExperiBank;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class MorgageRequestTwoActivity extends Activity {

	private ListView typeOfLoanListView;
	private ArrayAdapter<String> typeOfLoanListAdapter;
	
	private ListView numberOfYearsListView;
	private ArrayAdapter<String> numberOfYearsListAdapter;
	
	private ListView typeOfOccupationListView;
	private ArrayAdapter<String> typeOfOccupationListAdapter;
	
	private ListView yearlyIncomeListView;
	private ArrayAdapter<String> yearlyIncomeListAdapter;
	
	private Button submitButton, backButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.morgagerequesttwo);

		typeOfLoanListView = (ListView) findViewById(R.id.typeOfLoanListView);
		String[] typeOfLoan = new String[] {"Home", "Car", "Personal", "Education", "Professional"};
		ArrayList<String> typeOfLoanList = new ArrayList<String>();
		typeOfLoanList.addAll(Arrays.asList(typeOfLoan));
		
		typeOfLoanListAdapter = new ArrayAdapter<String>(this, R.layout.simplerowcheck, typeOfLoanList);
		typeOfLoanListView.setAdapter(typeOfLoanListAdapter);
		typeOfLoanListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				CheckedTextView textView = (CheckedTextView) view;
				textView.toggle();
				textView.setChecked(!textView.isChecked());
			}
		});
		
		numberOfYearsListView = (ListView) findViewById(R.id.numberOfYearsListView);
		String[] numberOfYears = new String[] {"1", "2", "5", "10", "15", "20"};
		ArrayList<String> numberOfYearsList = new ArrayList<String>();
		numberOfYearsList.addAll(Arrays.asList(numberOfYears));
		numberOfYearsListAdapter = new ArrayAdapter<String>(this, R.layout.simplerowcheck, numberOfYearsList);
		numberOfYearsListView.setAdapter(numberOfYearsListAdapter);
		numberOfYearsListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				CheckedTextView textView = (CheckedTextView) view;
				textView.toggle();
				textView.setChecked(!textView.isChecked());
			}
		});

		typeOfOccupationListView = (ListView) findViewById(R.id.typeOfOccupationListView);
		String[] typeOfOccupations = new String[] {"None", "Private Job", "Government Job", "Agricultural", "Business", "Housewife", "None"};
		ArrayList<String> typeOfOccupationsList = new ArrayList<String>();
		typeOfOccupationsList.addAll(Arrays.asList(typeOfOccupations));
		typeOfOccupationListAdapter = new ArrayAdapter<String>(this, R.layout.simplerowcheck, typeOfOccupations);
		typeOfOccupationListView.setAdapter(typeOfOccupationListAdapter);
		typeOfOccupationListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				CheckedTextView textView = (CheckedTextView) view;
				textView.toggle();
				textView.setChecked(!textView.isChecked());
			}
		});
		
		yearlyIncomeListView = (ListView) findViewById(R.id.yearlyIncomeListView);
		String[] yearlyIncome = new String[] {"500,000", "1,000,000", "1,500,000", "2,000,000", "2,500,000", "5,000,000", "More"};
		ArrayList<String> yearlyIncomeList = new ArrayList<String>();
		yearlyIncomeList.addAll(Arrays.asList(yearlyIncome));
		yearlyIncomeListAdapter = new ArrayAdapter<String>(this, R.layout.simplerowcheck, yearlyIncome);
		yearlyIncomeListView.setAdapter(yearlyIncomeListAdapter);
		yearlyIncomeListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				CheckedTextView textView = (CheckedTextView) view;
				textView.toggle();
				textView.setChecked(!textView.isChecked());
			}
		});
		
		submitButton = (Button) findViewById(R.id.saveButton);
		submitButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Intent intent = getIntent();
					intent.putExtra("LoanSubmit", "Yes");
					setResult(RESULT_OK, intent);
					finish();
				} catch (Exception ex) {
					Log.e(this.getClass().getName(), "Error : " + ex.getMessage(), ex);
				}
			}
		});
		
		backButton = (Button) findViewById(R.id.backButton);
		backButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Intent intent = getIntent();
					intent.putExtra("LoanSubmit", "No");
					setResult(RESULT_OK, intent);
					finish();
				} catch (Exception ex) {
					Log.e(this.getClass().getName(), "Error : " + ex.getMessage(), ex);
				}
			}
		});
	}
}
