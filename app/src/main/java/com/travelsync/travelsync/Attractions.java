package com.travelsync.travelsync;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Attractions extends AppCompatActivity{
    ListView listView;
    String[] attractions_array;
    Button b1;
    Button back;
    Intent intent;
    Intent previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);
        intent = new Intent(this, Homeaway.class);
        previous = new Intent(this, Plan.class);

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(previous);
            }
        });

        listView = (ListView) findViewById(R.id.attraction_list);
        attractions_array = new String[] { "Space Needle", "Experience Music Project Music", "Pike Place Market",
                "Olympic Sculpture Park", "Gum Wall", "Gas Works Park", "Seattle Aquarium", "Woodland Park Zoo", "Kerry Park", "Chihuly Garden and Glass", "Museum of Flight" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, attractions_array);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String selected = attractions_array[position];
                //listView.setItemChecked();
                listView.setItemChecked(position+1, true);
            }
        });
    }
}
