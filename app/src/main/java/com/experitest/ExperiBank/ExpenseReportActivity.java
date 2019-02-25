package com.experitest.ExperiBank;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ExpenseReportActivity extends Activity {

	private ListView expenseListView;
	private ExpenseReportAdapter expenseListAdapter;

	private Button addButton, backButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.expernsereport);

		expenseListView = (ListView) findViewById(R.id.expenseListView);
		String[] titlesArray = new String[] { "Expense : 1" };
		String[] detailsArray = new String[] { "Press 'Add' to add row" };
		String[] typesArray = new String[] { "Tap on row to remove it" };
		
		ArrayList<String> titlesList = new ArrayList<String>();
		titlesList.addAll(Arrays.asList(titlesArray));
		
		ArrayList<String> detailsList = new ArrayList<String>();
		detailsList.addAll(Arrays.asList(detailsArray));
		
		ArrayList<String> typesList = new ArrayList<String>();
		typesList.addAll(Arrays.asList(typesArray));
		
		expenseListAdapter = new ExpenseReportAdapter(this, titlesList, detailsList, typesList);
		expenseListView.setAdapter(expenseListAdapter);
		expenseListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				expenseListAdapter.remove(position);
			}
		});

		addButton = (Button) findViewById(R.id.addButton);
		addButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					expenseListAdapter.add("Expense : " + (expenseListAdapter.getCount() + 1), 
							"Detail goes here" , "Type goes here");
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
					finish();
				} catch (Exception ex) {
					Log.e(this.getClass().getName(), "Error : " + ex.getMessage(), ex);
				}
			}
		});
	}
}
