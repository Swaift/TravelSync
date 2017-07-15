package com.travelsync.travelsync;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NewPlanActivity extends AppCompatActivity {
    Intent intent;
    Button b1;
    String[] contact_array = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plan);
        intent = new Intent(this, Plan.class);

        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        ListView listView = (ListView) findViewById(R.id.contact_list);
        String[] values = new String[] { "Alex", "Christian", "Tawsif",
                "Brendan", "Dan", "John" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);
    }

}
