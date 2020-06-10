package com.gzeinnumer.autotextviewcostumarrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    private void initView() {
        final AutoCompleteTextView act = findViewById(R.id.act);
        final ArrayList<AdapterAutoCompleteText.ModelClass> listName = new ArrayList<>();

        listName.add(new AdapterAutoCompleteText.ModelClass(1,"M."));
        listName.add(new AdapterAutoCompleteText.ModelClass(2,"Fadli"));
        listName.add(new AdapterAutoCompleteText.ModelClass(3,"Zein"));

        AdapterAutoCompleteText adapter = new AdapterAutoCompleteText(getApplicationContext(), listName);
        act.setText(listName.get(0).getName(), false);
        act.setAdapter(adapter);

        act.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                act.setText(listName.get(position).getName(), false);
            }
        });
    }
}