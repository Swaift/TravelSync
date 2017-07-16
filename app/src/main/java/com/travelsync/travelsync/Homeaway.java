package com.travelsync.travelsync;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;


public class Homeaway extends AppCompatActivity{
    Intent intent;
    Intent previous;
    Button b1;
    Button back;
    String city, state, min, max, bed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeaway);
        intent = new Intent(this, Homeaway.class);
        previous = new Intent(this, Plan.class);
        final AppCompatActivity homeaway = this;


        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city  = ((EditText) findViewById(R.id.cityInput )).getText().toString();
                state = ((EditText) findViewById(R.id.stateInput)).getText().toString();
                min   = ((EditText) findViewById(R.id.minInput  )).getText().toString();
                max   = ((EditText) findViewById(R.id.maxInput  )).getText().toString();
                bed   = ((EditText) findViewById(R.id.bedInput  )).getText().toString();

                String url = "https://www.homeaway.com/results/arrival:2017-07-16/departure:2017-07-20/keywords:" +
                        city + "+" +
                        state + "/minNightlyPrice/" +
                        min + "/maxNightlyPrice/" +
                        max + "/minSleeps/" +
                        bed;
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(0x3030F9F);
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(homeaway, Uri.parse(url));
                //startActivity(intent);
            }
        });
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(previous);
            }
        });
    }
}
