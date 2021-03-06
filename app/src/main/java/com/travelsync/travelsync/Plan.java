package com.travelsync.travelsync;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class Plan extends AppCompatActivity {
    CalendarView calendar;
    Intent intent;
    Intent previous;
    Button b1;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        intent = new Intent(this, Attractions.class);
        previous = new Intent(this, NewPlanActivity.class);

        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(previous);
            }
        });

        calendar=(CalendarView)findViewById(R.id.calendarView);
    }
}
