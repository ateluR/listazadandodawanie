package com.onaar.listalubkalendarz;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Todo> items;
    ArrayAdapter<Todo> arrayAdapter;
    EditText input;
    Button enter;

   private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        input = findViewById(R.id.editTextText);
        spinner = findViewById(R.id.spinner);

        items = new ArrayList<>();
        items.add(new Todo("Zakupy: chlep, masło, ser", (byte) 1));
        items.add(new Todo("Do zrobienia: obiad, umyć podłogi", (byte) 2));
        items.add(new Todo("weekend: kino, spacer z psem", (byte) 0));

        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                items);

       listView.setAdapter(arrayAdapter);
        enter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String rzeczDozrobienia = input.getText().toString();
                        byte piorytetRzeczy  = (byte)spinner.getSelectedItemPosition();
                       items.add(new Todo(rzeczDozrobienia, piorytetRzeczy));
                        arrayAdapter.notifyDataSetChanged();
                        input.setText("");
                    }
                }
        );
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        view.setBackgroundColor(Color.GRAY);
                        TextView textView = (TextView) view;
                        textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                        if(items.get(i).isCzyWykonane())
                        {

                            textView.setPaintFlags(Paint.ANTI_ALIAS_FLAG);
                            items.get(i).setCzyWykonane(false);
                        }
                        else{
                            textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                            items.get(i).setCzyWykonane(true);

                        }
                    }
                }
        );
        listView.setOnItemClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long i) {
                        items.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                        return false;
                    }
                }
        );
    }
}