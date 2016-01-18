package com.example.sebas.login;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Mostrar extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        final String name=getIntent().getStringExtra("nombre");

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/TimKid.ttf");

        btn=(Button) findViewById(R.id.continuar);
        btn.setTypeface(myCustomFont);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Mostrar.this, addChild.class);
                i.putExtra("nombre",name);
                startActivity(i);
            }
        });

    }


    }
