package com.example.queerhack2020;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;

public class OtterActivity extends AppCompatActivity {

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
                otter_idle.setClickable(false);
                otter_idle.setImageDrawable(getResources().getDrawable(R.drawable.otter_jump_animation));
                AnimationDrawable otter_jump_animation = (AnimationDrawable)otter_idle.getDrawable();
                otter_jump_animation.start();
                CountDownTimer cooldown = new CountDownTimer(1400,1) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        otter_idle.setImageResource(R.drawable.otter_idle_animation);
                        AnimationDrawable otter_idle_animation = (AnimationDrawable)otter_idle.getDrawable();
                        otter_idle_animation.start();
                        otter_idle.setClickable(true);
                    }
                };
                cooldown.start();

            }
        });

        Button back = findViewById((R.id.back));
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}
