package com.example.huddscharityrowingcompetitionv1;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.Matrix;
import android.widget.Spinner;
import android.widget.TextView;

import static android.view.View.*;

public class DetailActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


int rotationAngle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(0);

        ImageView img = (ImageView)findViewById(R.id.cancerImage);

        img.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.cancerresearchuk.org/"));
                startActivity(intent);
            }
        });





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String text = parent.getItemAtPosition(position).toString();
            Log.d("text:", text);

            if (text.equals("Book Now")) {
                startActivity(new Intent(DetailActivity.this, BookPage.class));
            }
            else if (text.equals("Itinerary") ) {
                startActivity(new Intent(DetailActivity.this, Itinerary.class));
        }
            else if (text.equals("Location") ) {
                startActivity(new Intent(DetailActivity.this, Location.class));
            }
            else if (text.equals("Donate!") ) {
                startActivity(new Intent(DetailActivity.this, DonatePage.class));
            }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.arrow:
                try {
                    TextView textView = (TextView)findViewById(R.id.aboutText);

                    ImageView arrow1 = (ImageView) findViewById(R.id.arrow);
                    ObjectAnimator anim = ObjectAnimator.ofFloat(arrow1, "rotation",rotationAngle, rotationAngle + 180);
                    anim.setDuration(500);
                    anim.start();
                    rotationAngle += 180;
                    rotationAngle = rotationAngle%360;

                    if (textView.getText() == ""){
                        textView.setText("We fund scientists, doctors and nurses to help beat cancer sooner. We also provide cancer information to the public. Support us now.");
                    } else {
                        textView.setText("");
                    }



                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void onButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.bookButton:
                try {
                    Button bookButton1 = (Button) findViewById(R.id.bookButton);
                    Animation animation = AnimationUtils.loadAnimation(DetailActivity.this, R.anim.fadein);
                    bookButton1.startAnimation(animation);
                    startActivity(new Intent(DetailActivity.this, BookPage.class));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }



}
