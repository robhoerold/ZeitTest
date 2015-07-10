package com.example.robert.zeittest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class WorkerMain extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_main);

        final Button loginButton = (Button) findViewById(R.id.id_button_login);
        final Button logoutButton = (Button) findViewById(R.id.id_button_logout);
        final TextView loggedinText = (TextView) findViewById(R.id.id_loggedin_text);
        final TextView loggedoutText = (TextView) findViewById(R.id.id_loggedout_text);

        loginButton.setVisibility(View.VISIBLE);
        logoutButton.setVisibility(View.INVISIBLE);
        loggedinText.setVisibility(View.INVISIBLE);
        loggedoutText.setVisibility(View.VISIBLE);
    }

    public void sendMessage_login(View view)
    {
        final Button loginButton = (Button) findViewById(R.id.id_button_login);
        final Button logoutButton = (Button) findViewById(R.id.id_button_logout);
        loginButton.setVisibility(View.INVISIBLE);
        logoutButton.setVisibility(View.VISIBLE);

        final TextView loggedinText = (TextView) findViewById(R.id.id_loggedin_text);
        final TextView loggedoutText = (TextView) findViewById(R.id.id_loggedout_text);
        loggedinText.setVisibility(View.VISIBLE);
        loggedoutText.setVisibility(View.INVISIBLE);

        final TextView timestampText = (TextView) findViewById(R.id.id_timestamp_text);
        SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String format = s.format(new Date());
        timestampText.setText(format);

    }

    public void sendMessage_logout(View view)
    {
        final Button loginButton = (Button) findViewById(R.id.id_button_login);
        final Button logoutButton = (Button) findViewById(R.id.id_button_logout);
        logoutButton.setVisibility(View.INVISIBLE);
        loginButton.setVisibility(View.VISIBLE);

        final TextView loggedinText = (TextView) findViewById(R.id.id_loggedin_text);
        final TextView loggedoutText = (TextView) findViewById(R.id.id_loggedout_text);
        loggedinText.setVisibility(View.INVISIBLE);
        loggedoutText.setVisibility(View.VISIBLE);

        final TextView timestampText = (TextView) findViewById(R.id.id_timestamp_text);
        SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String format = s.format(new Date());
        timestampText.setText(format);
    }

    public void sendMessage_timetable(View view)
    {
        Intent intent = new Intent(this, TimetableActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_worker_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
