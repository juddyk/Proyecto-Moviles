package com.example.sebas.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.firebase.client.Firebase;

public class KidRegister extends AppCompatActivity {
    String kidSex;
    private Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid_register);

        //FIREBASE
        Firebase.setAndroidContext(this);
        //mi base de datos en FIREBASE
        mRef=new Firebase("https://clasefirebase.firebaseio.com/");

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/TimKid.ttf");

        final EditText name=(EditText) findViewById(R.id.eNameKid);
        final Spinner sex = (Spinner) findViewById(R.id.spinSex);
        final Spinner language = (Spinner) findViewById(R.id.spinLanguage);
        final DatePicker date = (DatePicker) findViewById(R.id.dpFecha);
        final Button finish = (Button) findViewById(R.id.bFinish);
        final TimePicker time = (TimePicker) findViewById(R.id.timepick);

        name.setTypeface(myCustomFont);
        finish.setTypeface(myCustomFont);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = name.getText().toString();
                kidSex = sex.getSelectedItem().toString();
                int day = date.getDayOfMonth();
                int month = date.getMonth();
                int year = date.getYear();
                int hour = time.getCurrentHour();
                int min = time.getCurrentMinute();
                String lengua = language.getSelectedItem().toString();

                Intent i = new Intent(KidRegister.this, addChild.class);
                i.putExtra("nombre", nombre);
                i.putExtra("sex", kidSex);
                i.putExtra("day", day);
                i.putExtra("month", month);
                i.putExtra("year", year);
                i.putExtra("language", lengua);
                i.putExtra("hour", hour);
                i.putExtra("min", min);
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        });
    }

}
