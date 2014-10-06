package com.test.nsingh.jms;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MyActivity extends Activity {

    LinearLayout background;
    Button btnGreen;
    Button btnBlue;
    ImageButton btnImg;
    Button btnSend;
    EditText colorEditText;

    public static final String EXTRA_MESSAGE = "Hi!! here is the message from Naren: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my);
        setContentView(R.layout.home_screen);  //home_screen.xml is the layout file

        background = (LinearLayout) findViewById(R.id.home_screen_background);
        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnGreen = (Button) findViewById(R.id.btnGreen);
        btnImg = (ImageButton) findViewById(R.id.btnImg);
        btnSend = (Button) findViewById(R.id.btnSend);
        colorEditText = (EditText) findViewById(R.id.colorEditText);

        colorEditText.requestFocus();
        colorEditText.setText("Enter Color here...");

        colorEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // click button code here.
                Log.d("NAREN:", "I am going to wipe edit text content" );
                colorEditText.setText("");
            }
        });


        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // click button code here.
                String text_from_res = getResources().getString(R.string.hello_world);
                Log.d("NAREN:", "I am going to print string resource " + text_from_res );
//                TextView textView = new TextView(MyActivity.this);
//                textView.setText(text_from_res);

                background.setBackgroundColor(Color.GREEN);
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundColor(Color.BLUE);
            }
        });

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundColor(Color.BLACK);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, DisplayMessageActivity.class);
                EditText text = (EditText) findViewById(R.id.editText);
                String message = text.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);

                String color = colorEditText.getText().toString();
                Log.d("Naren:", "Got color as: " + color);
                intent.putExtra("color", color);
                startActivity(intent);
            }
        });
    }

/*    public void sendMessage(View v)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText text = (EditText) findViewById(R.id.editText);
        String message = text.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
