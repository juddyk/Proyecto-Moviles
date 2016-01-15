package com.example.sebas.login;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class afterSplash extends AppCompatActivity {
    private Button btn;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_splash);

        btn=(Button) findViewById(R.id.idBtnS);
        btn1=(Button) findViewById(R.id.Btn1);
        btn2=(Button) findViewById(R.id.Btn2);
        btn3=(Button) findViewById(R.id.Btn3);
        tv=(TextView) findViewById(R.id.tv1);
        iv=(ImageView) findViewById(R.id.idImg);

        //se define el tipo de fuente, se usa una externa
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/TimKid.ttf");

        //tipo de fuente
        btn.setTypeface(myCustomFont);
        btn1.setTypeface(myCustomFont);
        btn2.setTypeface(myCustomFont);
        btn3.setTypeface(myCustomFont);
        tv.setTypeface(myCustomFont);

        //vista inicial
        iv.setImageResource(R.drawable.ic_apprende);
        btn1.setBackgroundResource(R.drawable.button1);
        tv.setText(R.string.texto1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(afterSplash.this, MainActivity.class);
                startActivity(i);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(R.string.texto1);
                iv.setImageResource(R.drawable.ic_apprende);
                btn1.setBackgroundResource(R.drawable.button1);
                btn2.setBackgroundResource(R.drawable.button2);
                btn3.setBackgroundResource(R.drawable.button2);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(R.string.texto2);
                iv.setImageResource(R.drawable.palabras);
                btn1.setBackgroundResource(R.drawable.button2);
                btn2.setBackgroundResource(R.drawable.button1);
                btn3.setBackgroundResource(R.drawable.button2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(R.string.texto3);
                iv.setImageResource(R.drawable.plan);
                btn1.setBackgroundResource(R.drawable.button2);
                btn2.setBackgroundResource(R.drawable.button2);
                btn3.setBackgroundResource(R.drawable.button1);
            }
        });


    }

}
