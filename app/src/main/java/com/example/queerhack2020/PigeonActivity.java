package com.example.queerhack2020;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PigeonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pigeon);

        ImageView pigeon_walk= (ImageView) findViewById(R.id.pigeon);
        pigeon_walk.setImageResource(R.drawable.pigeon_walk_animation);
        AnimationDrawable pigeon_walk_animation = (AnimationDrawable)pigeon_walk.getDrawable();
        pigeon_walk_animation.start();


        pigeon_walk.setClickable(true);
        pigeon_walk.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v)
           {
               int duration = 1400;
               pigeon_walk.setImageDrawable(getResources().getDrawable(R.drawable.pigeon_peck_animation));
               AnimationDrawable pigeon_peck_animation = (AnimationDrawable)pigeon_walk.getDrawable();
               pigeon_peck_animation.start();

               CountDownTimer cooldown = new CountDownTimer(duration,1) {
                   @Override
                   public void onTick(long millisUntilFinished) {

                   }

                   @Override
                   public void onFinish() {
                       pigeon_walk.setImageResource(R.drawable.pigeon_walk_animation);
                       AnimationDrawable pigeon_walk_animation = (AnimationDrawable)pigeon_walk.getDrawable();
                       pigeon_walk_animation.start();
                       pigeon_walk.setClickable(true);
                   }
               };
               cooldown.start();
           }

       });

        ImageButton back = findViewById((R.id.backButton));
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}