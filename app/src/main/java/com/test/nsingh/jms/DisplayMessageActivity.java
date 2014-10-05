package com.test.nsingh.jms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
