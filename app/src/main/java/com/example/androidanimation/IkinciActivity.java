package com.example.androidanimation;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class IkinciActivity extends AppCompatActivity {

    TextView pagetitle, pagesubtitle;
    ImageView packagePlace;
    SeekBar packageRange;
    Animation animbir, packageimg;
    Button bitti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci);

        animbir = AnimationUtils.loadAnimation(this, R.anim.animbir);
        packageimg = AnimationUtils.loadAnimation(this, R.anim.packageimg);

        pagetitle = findViewById(R.id.pagetitle);
        pagesubtitle = findViewById(R.id.pagesubtitle);

        packagePlace = findViewById(R.id.packagePlace);

        packageRange = findViewById(R.id.packageRange);

        bitti = findViewById(R.id.bittibtn);

        if(Build.VERSION.SDK_INT>=21) {
            Explode enterTransition = new Explode();
            enterTransition.setDuration(1500);
            getWindow().setEnterTransition(enterTransition);
            getWindow().setAllowEnterTransitionOverlap(false);
        }





        packageRange.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress == 35){
                    pagetitle.setText("Başla");
                    pagesubtitle.setText("Aşağıdaki bir 'SeekBar'. Hareket etirerek görseli değiştir");
                    packagePlace.setImageResource(R.drawable.imac);

                    // pass animation
                    packagePlace.startAnimation(packageimg);
                    pagetitle.startAnimation(animbir);
                    pagesubtitle.startAnimation(animbir);
                }
                else if(progress == 75){
                    pagetitle.setText("Oyun Konsolu");
                    pagesubtitle.setText("Aşağıdaki bir 'SeekBar'. Hareket etirerek görseli değiştir");
                    packagePlace.setImageResource(R.drawable.gamepad);

                    // pass animation
                    packagePlace.startAnimation(packageimg);
                    pagetitle.startAnimation(animbir);
                    pagesubtitle.startAnimation(animbir);
                }
                else if(progress == 100){
                    pagetitle.setText("Yazıcı");
                    pagesubtitle.setText("Aşağıdaki bir 'SeekBar'. Hareket etirerek görseli değiştir");
                    packagePlace.setImageResource(R.drawable.printer);

                    // pass animation
                    packagePlace.startAnimation(packageimg);
                    pagetitle.startAnimation(animbir);
                    pagesubtitle.startAnimation(animbir);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        bitti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=21) {
                    finishAfterTransition();
                }
                else {
                    finish();
                }
            }
        });

    }
}
