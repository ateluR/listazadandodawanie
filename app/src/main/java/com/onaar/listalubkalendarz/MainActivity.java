package com.onaar.listalubkalendarz;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> items;
    ArrayAdapter<String> arrayAdapter;
    EditText input;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        input = findViewById(R.id.editTextText);
        enter = findViewById(R.id.button);

        items = new ArrayList<>();
        items.add("Zakupy: chlep, masło, ser");
        items.add("Do zrobienia: obiad, umyć podłogi");
        items.add("weekend: kino, spacer z psem");

        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                items);

        listView.setAdapter(arrayAdapter);
        enter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String rzeczDozrobienia = input.getText().toString();
                        items.add(rzeczDozrobienia);
                        arrayAdapter.notifyDataSetChanged();
                        input.setText("");
                    }
                }
        );
    }
}