package com.example.robert.zeittest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class TimetableActivity extends ActionBarActivity {

    ListView listView;
    ArrayList<String> leftList = new ArrayList<String>();
    ArrayList<String> rightList = new ArrayList<String>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        listView = (ListView) findViewById(R.id.lv_country);
        listView.setAdapter(new EfficientAdapter(this));

        leftList.addAll(Arrays.asList(CountriesList.abbreviations));
        rightList.addAll(Arrays.asList(CountriesList.countries));

        leftList.add(leftList.size(), "EndLinks");
        rightList.add(rightList.size(), "EndRechts");
    }

    private class EfficientAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public EfficientAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return CountriesList.abbreviations.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.timetablerow, null);
                holder = new ViewHolder();
                holder.text1 = (TextView) convertView.findViewById(R.id.TextView01);
                holder.text2 = (TextView) convertView.findViewById(R.id.TextView02);

                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            //holder.text1.setText(CountriesList.abbreviations[position]);
            holder.text1.setText(leftList.get(position));
            holder.text2.setText(rightList.get(position));

            return convertView;
        }

        class ViewHolder {
            TextView text1;
            TextView text2;
        }
    }

}


