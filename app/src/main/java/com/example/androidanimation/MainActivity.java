package com.example.androidanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView kullanici, icerik1, icerik2, icerik3, icerik4, menu,
            pagetitle, pagesubtitle;

    Button btnguide;
    Animation animbir, animiki, animuc;
    ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animbir = AnimationUtils.loadAnimation(this, R.anim.animbir);
        animiki = AnimationUtils.loadAnimation(this, R.anim.animiki);
        animuc = AnimationUtils.loadAnimation(this, R.anim.animuc);

        kullanici = findViewById(R.id.usertxv);
        imageView3 = findViewById(R.id.imageView3);
        icerik1 = findViewById(R.id.birtxv);
        icerik2 = findViewById(R.id.ikitxv);
        icerik3 = findViewById(R.id.uctxv);
        icerik4 = findViewById(R.id.dorttxv);
        menu = findViewById(R.id.menutxt);

        pagetitle = findViewById(R.id.pagetitle);
        pagesubtitle = findViewById(R.id.pagesubtitle);

        btnguide = findViewById(R.id.btnguide);

        btnguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 21) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                    Intent a = new Intent(MainActivity.this, IkinciActivity.class);
                    startActivity(a,options.toBundle());
                }else {
                    Intent intent = new Intent(MainActivity.this, IkinciActivity.class);
                    startActivity(intent);

                }
            }
        });

        // pass an animation
        imageView3.startAnimation(animbir);
        pagetitle.startAnimation(animiki);
        pagesubtitle.startAnimation(animiki);
        btnguide.startAnimation(animuc);
    }
}
