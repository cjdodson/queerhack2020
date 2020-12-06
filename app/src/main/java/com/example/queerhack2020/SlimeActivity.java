package com.example.queerhack2020;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SlimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slime);

        ImageView slime_walk= (ImageView) findViewById(R.id.slime);
        slime_walk.setImageResource(R.drawable.slime_walk_animation);
        AnimationDrawable slime_walk_animation = (AnimationDrawable)slime_walk.getDrawable();
        slime_walk_animation.start();


        slime_walk.setClickable(true);
        slime_walk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                int duration = 1400;
                slime_walk.setImageDrawable(getResources().getDrawable(R.drawable.slime_jump_animation));
                AnimationDrawable slime_jump_animation = (AnimationDrawable)slime_walk.getDrawable();
                slime_jump_animation.start();

                CountDownTimer cooldown = new CountDownTimer(duration,1) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        slime_walk.setImageResource(R.drawable.slime_walk_animation);
                        AnimationDrawable slime_walk_animation = (AnimationDrawable)slime_walk.getDrawable();
                        slime_walk_animation.start();
                        slime_walk.setClickable(true);
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