package com.example.queerhack2020;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_screen);

        ImageView otter_main = (ImageView) findViewById(R.id.otter_main);
        otter_main.setImageResource(R.drawable.otter_idle_main_animation);
        AnimationDrawable otter_main_animation = (AnimationDrawable)otter_main.getDrawable();
        otter_main_animation.start();

        ImageButton otter_button = findViewById((R.id.otter_main));
        otter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                setContentView(R.layout.otter_screen);

                ImageView otter_idle = (ImageView) findViewById(R.id.otter_idle);
                otter_idle.setImageResource(R.drawable.otter_idle_animation);
                AnimationDrawable otter_idle_animation = (AnimationDrawable)otter_idle.getDrawable();
                otter_idle_animation.start();
            }
        });
    }
}