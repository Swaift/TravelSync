package com.travelsync.travelsync;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;


public class Homeaway extends AppCompatActivity{
    Intent intent;
    Intent previous;
    Button b1;
    Button back;
    String city  = ((EditText) findViewById(R.id.cityInput )).getText().toString();
    String state = ((EditText) findViewById(R.id.stateInput)).getText().toString();
    String min   = ((EditText) findViewById(R.id.minInput  )).getText().toString();
    String max   = ((EditText) findViewById(R.id.maxInput  )).getText().toString();
    String bed   = ((EditText) findViewById(R.id.bedInput  )).getText().toString();

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
                String url = "https://www.homeaway.com/results/keywords:" +
                        city + "+" +
                        state + "/minNightlyPrice/" +
                        min + "/maxNightlyPrice/" +
                        max + "/minSleeps/" +
                        bed;
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
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
