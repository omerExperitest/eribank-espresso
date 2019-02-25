package com.experitest.ExperiBank;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CountryListActivity extends Activity {
	ListView countryListView;
	private ArrayAdapter<String> listAdapter;
	private String[] countriesArray = new String[] { "India", "USA", "Iceland", "Greenland", "Switzerland", "Norway", "New Zealand", "Greece", "Italy", "Ireland", "China", "Japan", "France", "Russia", "Australlia", "Canada", "Brazil", "Indonesia",
			"Nigeria", "Bangladesh", "Mexico", "Philippines", "Vietnam", "Ethiopia", "Egypt", "Germany", "Iran", "Turkey", "Thailand", "United Kingdom", "South Africa", "South Korea", "Myanmar", "Spain", "Colombia", "Ukraine", "Tanzania",
			"Argentina" };


	@Override
	public void onCreate(Bundle savedInstanceState) {


		super.onCreate(savedInstanceState);
		setContentView(R.layout.countrylist);

		countryListView = (ListView) findViewById(R.id.countryList);
		ArrayList<String> countryList = new ArrayList<String>();
		countryList.addAll(Arrays.asList(countriesArray));
		listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, countryList);
		countryListView.setAdapter(listAdapter);

		countryListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = getIntent();
				intent.putExtra("SelectedCountry", countriesArray[position]);
				setResult(RESULT_OK, intent);
				finish();
			}
		});
	}
}
