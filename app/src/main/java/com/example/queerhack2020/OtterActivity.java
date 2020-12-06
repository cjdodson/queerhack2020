package com.example.queerhack2020;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;

public class OtterActivity extends AppCompatActivity {
    private final int JUMP = 0;
    private final int SPIN = 1;
    private final int SLEEP = 2;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.otter_screen);

        ImageView otter_idle = (ImageView) findViewById(R.id.otter);
        otter_idle.setImageResource(R.drawable.otter_idle_animation);
        AnimationDrawable otter_idle_animation = (AnimationDrawable)otter_idle.getDrawable();
        otter_idle_animation.start();
        otter_idle.setClickable(true);
        otter_idle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int action = r.nextInt(3);
                int duration = 0;
                otter_idle.setClickable(false);
                switch(action){
                    case JUMP:
                        duration = 1500;
                        otter_idle.setImageDrawable(getResources().getDrawable(R.drawable.otter_jump_animation));
                        AnimationDrawable otter_jump_animation = (AnimationDrawable)otter_idle.getDrawable();
                        otter_jump_animation.start();
                        break;
                    case SPIN:
                        duration = 1100;
                        otter_idle.setImageDrawable(getResources().getDrawable(R.drawable.otter_spin_animation));
                        AnimationDrawable otter_spin_animation = (AnimationDrawable)otter_idle.getDrawable();
                        otter_spin_animation.start();
                        break;
                    case SLEEP:
                        duration = 1800;
                        otter_idle.setImageDrawable(getResources().getDrawable(R.drawable.otter_sleep_animation));
                        AnimationDrawable otter_sleep_animation = (AnimationDrawable)otter_idle.getDrawable();
                        otter_sleep_animation.start();
                        break;
                    default:
                        break;
                }

                CountDownTimer cooldown = new CountDownTimer(duration,1) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        if (action!=SLEEP){
                            otter_idle.setImageResource(R.drawable.otter_idle_animation);
                            AnimationDrawable otter_idle_animation = (AnimationDrawable)otter_idle.getDrawable();
                            otter_idle_animation.start();
                        }
                        otter_idle.setClickable(true);
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
