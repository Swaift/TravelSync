package com.travelsync.travelsync;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class Plan extends AppCompatActivity {
    CalendarView calendar;
    Intent previous;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        previous = new Intent(this, NewPlanActivity.class);

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
