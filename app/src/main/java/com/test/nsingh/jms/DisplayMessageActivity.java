package com.test.nsingh.jms;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DisplayMessageActivity extends Activity {
    @Override
    protected void onPause() {
        Log.d("NAREN:", "OnPause-DisplayMessageActivity");
        super.onPause();
    }

    @Override
    protected void onStart() {
        Log.d("NAREN:", "onStart-DisplayMessageActivity");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d("NAREN:", "onRestart-DisplayMessageActivity");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d("NAREN:", "onResume-DisplayMessageActivity");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.d("NAREN:", "onStop-DisplayMessageActivity");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("NAREN:", "onDestroy-DisplayMessageActivity");
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent =  getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        String color = intent.getStringExtra("color").toLowerCase();
        Log.d("Naren:", "Got color as: " + color);

//        LinearLayout display_activity_view = (LinearLayout)findViewById(R.id.display_activity_background);
//        textView.setBackgroundColor(Color.GREEN);

        int color_code = Color.BLACK;
        try
        {
            color_code = Color.parseColor(color) ;
        }
        catch(IllegalArgumentException ex){
            Log.d("NAREN:", "Error caught while parsing color : " + ex.getMessage());
        }
        finally {
            Log.d("NAREN:", "Unknown Exception");
        }

        textView.setBackgroundColor(color_code);
        setContentView(textView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
