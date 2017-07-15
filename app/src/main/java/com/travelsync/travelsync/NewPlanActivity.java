package com.travelsync.travelsync;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class NewPlanActivity extends AppCompatActivity {
    Intent intent;
    Intent previous;
    Button b1;
    Button back;
    String[] contact_array;
    ListView listView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_plan);
        intent = new Intent(this, Plan.class);
        previous = new Intent(this, Home.class);
        editText = (EditText) findViewById(R.id.Title);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        b1=(Button)findViewById(R.id.button);
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
        listView = (ListView) findViewById(R.id.contact_list);
        contact_array = new String[] { "Alex", "Christian", "Tawsif",
                "Brendan", "Dan", "John", "Negin", "Divya", "Shubhangi", "Jake", "Patrick" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, contact_array);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String selected = contact_array[position];
                //listView.setItemChecked();
                listView.setItemChecked(position+1, true);
            }
        });
    }
}
