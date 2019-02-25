package com.experitest.ExperiBank;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ExpenseReportAdapter extends ArrayAdapter<String> {
	private String ACTIVITY_TAG = "ExpenseReportAdapter";

	private final ArrayList<String> titles;
	private final ArrayList<String> details;
	private final ArrayList<String> types;
	private LayoutInflater inflator;

	public ExpenseReportAdapter(Context context, ArrayList<String> titles, ArrayList<String> details, ArrayList<String> types) {
		super(context, R.id.titleTextView, titles);
		this.titles = titles;
		this.details = details;
		this.types = types;
		inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void remove(int position) {
		titles.remove(position);
		details.remove(position);
		types.remove(position);
		notifyDataSetChanged();
	}
	
	public void add(String title, String detail, String type) {
		titles.add(title);
		details.add(detail);
		types.add(type);
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		try {
			ViewHolder viewHolder;

			if (rowView == null) {
				rowView = inflator.inflate(R.layout.detailrow, null);
				viewHolder = new ViewHolder();
				viewHolder.title = (TextView) rowView.findViewById(R.id.titleTextView);
				viewHolder.detail = (TextView) rowView.findViewById(R.id.detailTextView);
				viewHolder.type = (TextView) rowView.findViewById(R.id.typeTextView);
				rowView.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) rowView.getTag();
			}
			viewHolder.title.setText(titles.get(position));
			viewHolder.detail.setText(details.get(position));
			viewHolder.type.setText(types.get(position));
			
			rowView.setTag(viewHolder);
		} catch (Exception ex) {
			Log.e(ACTIVITY_TAG, "Error : ", ex);
		}

		return rowView;
	}
	
	
}
