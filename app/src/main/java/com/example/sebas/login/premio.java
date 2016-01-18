package com.example.sebas.login;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class premio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premio);
/*
        ValueAnimator fondo = ObjectAnimator.ofInt
                (findViewById(R.id.animation_layout), "backgroundColor",
                        Color.rgb(0xFF, 0xFF, 0xFF), Color.rgb(0xFF, 0xD7, 0x00));
        fondo.setDuration(3000);
        fondo.setRepeatCount(ValueAnimator.INFINITE);
        fondo.setRepeatMode(ValueAnimator.REVERSE);
        fondo.setEvaluator(new ArgbEvaluator());
*/
        ImageView star1 = (ImageView)findViewById(R.id.star1);
        ImageView star2 = (ImageView)findViewById(R.id.star2);
        ImageView star3 = (ImageView)findViewById(R.id.star3);
        ImageView star4 = (ImageView)findViewById(R.id.star4);
        ImageView star5 = (ImageView)findViewById(R.id.star5);
  //      ImageView star6 = (ImageView)findViewById(R.id.star6);
        ImageView star7 = (ImageView)findViewById(R.id.star7);
        ImageView star8 = (ImageView)findViewById(R.id.star8);
        ImageView star9 = (ImageView)findViewById(R.id.star9);
        ImageView star10 = (ImageView)findViewById(R.id.star10);
        ImageView star11 = (ImageView)findViewById(R.id.star11);
        ImageView star12 = (ImageView)findViewById(R.id.star12);
        TextView msg=(TextView) findViewById(R.id.idTexto);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/TimKid.ttf");
        msg.setTypeface(myCustomFont);

        AnimatorSet star1Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.star1);
        star1Set.setTarget(star1);

        AnimatorSet star2Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.star2);
        star2Set.setTarget(star2);

        AnimatorSet star3Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.star3);
        star3Set.setTarget(star3);

        AnimatorSet star4Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.star4);
        star4Set.setTarget(star4);

        AnimatorSet star5Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.star5);
        star5Set.setTarget(star5);

//        AnimatorSet star6Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.star6);
//        star6Set.setTarget(star6);

        AnimatorSet star7Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.star7);
        star7Set.setTarget(star7);

        AnimatorSet star8Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.star8);
        star8Set.setTarget(star8);

        AnimatorSet star9Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.star9);
        star9Set.setTarget(star9);

        AnimatorSet star10Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.star10);
        star10Set.setTarget(star10);

        AnimatorSet star11Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.star11);
        star11Set.setTarget(star11);

        AnimatorSet star12Set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.star12);
        star12Set.setTarget(star12);


        //      fondo.start();

        star1Set.start();
        star2Set.start();
        star3Set.start();
        star4Set.start();
        star5Set.start();
//        star6Set.start();
        star7Set.start();
        star8Set.start();
        star9Set.start();
        star10Set.start();
        star11Set.start();
        star12Set.start();
    }
}
