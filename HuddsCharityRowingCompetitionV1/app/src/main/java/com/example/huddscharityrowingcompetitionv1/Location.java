package com.example.huddscharityrowingcompetitionv1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class Location extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        ImageView img = (ImageView)findViewById(R.id.map);

        img.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.google.com/maps/place/Sp%C3%A4rck+Jones+Building+-+University+of+Huddersfield/@53.6411995,-1.7807337,17z/data=!3m1!4b1!4m5!3m4!1s0x487bdc74b7b1d853:0x61647b4f712b5e0b!8m2!3d53.6411995!4d-1.778545"));
                startActivity(intent);
            }
        });

        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(2);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Log.d("text:", text);

        if (text.equals("Book Now")) {
            startActivity(new Intent(Location.this, BookPage.class));
        }
        else if (text.equals("Itinerary") ) {
            startActivity(new Intent(Location.this, Itinerary.class));
        }
        else if (text.equals("Home") ) {
            startActivity(new Intent(Location.this, DetailActivity.class));
        }
        else if (text.equals("Donate!") ) {
            startActivity(new Intent(Location.this, DonatePage.class));
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
