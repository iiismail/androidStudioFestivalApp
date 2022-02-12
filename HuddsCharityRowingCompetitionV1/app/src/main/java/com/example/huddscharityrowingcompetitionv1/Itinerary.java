package com.example.huddscharityrowingcompetitionv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Itinerary extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary);
        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(3);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position , long l) {
        String text = parent.getItemAtPosition(position).toString();
        Log.d("text:", text);

        if (text.equals("Book Now")) {
            startActivity(new Intent(Itinerary.this, BookPage.class));
        }
        else if (text.equals("Home") ) {
            startActivity(new Intent(Itinerary.this, DetailActivity.class));
        }
        else if (text.equals("Location") ) {
            startActivity(new Intent(Itinerary.this, Location.class));
        }
        else if (text.equals("Donate!") ) {
            startActivity(new Intent(Itinerary.this, DonatePage.class));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void donateBtnClicked(View view) {
        startActivity(new Intent(Itinerary.this, DonatePage.class));
    }

    public void bookBtnClicked(View view) {
        startActivity(new Intent(Itinerary.this, BookPage.class));

    }
}
