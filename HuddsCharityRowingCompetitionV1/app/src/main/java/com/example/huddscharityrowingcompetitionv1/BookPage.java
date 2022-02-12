package com.example.huddscharityrowingcompetitionv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BookPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_page);
        Spinner spinner = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.pages2, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(4);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Log.d("text:", text);

        if (text.equals("Home")) {
            startActivity(new Intent(BookPage.this, DetailActivity.class));
        } else if (text.equals("Itinerary")) {
            startActivity(new Intent(BookPage.this, Itinerary.class));
        } else if (text.equals("Location")) {
            startActivity(new Intent(BookPage.this, Location.class));
        } else if (text.equals("Donate!")) {
            startActivity(new Intent(BookPage.this, DonatePage.class));
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void finishBook(View view) {
        startActivity(new Intent(BookPage.this, RequestCompleted.class));
    }

    public void goToDonate(View view) {
        startActivity(new Intent(BookPage.this, DonatePage.class));
    }
}
