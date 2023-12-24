package com.example.ls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        String[] studentNames = {"Milad Majidi", "Ali Norozi", "Ali moradi", "Yasna Moradi", "Yalda niazi",
                "Mina Lavandi", "Hasan Hoseini", "Fateme Moradi", "Fateme Malekan", "Babak Karimi"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_student, R.id.textViewName, studentNames);
        listView.setAdapter(adapter);
    }
}
