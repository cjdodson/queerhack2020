package com.example.queerhack2020;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_screen);

        ImageView otter_main = (ImageView) findViewById(R.id.otter_main);
        otter_main.setImageResource(R.drawable.otter_idle_main_animation);
        AnimationDrawable otter_main_animation = (AnimationDrawable) otter_main.getDrawable();
        otter_main_animation.start();

        ImageView pigeon_main = (ImageView) findViewById(R.id.pigeon_main);
        pigeon_main.setImageResource(R.drawable.pigeon_walk_animation);
        AnimationDrawable pigeon_main_animation = (AnimationDrawable) pigeon_main.getDrawable();
        pigeon_main_animation.start();

        ImageView slime_main = (ImageView) findViewById(R.id.slime_main);

        String[] options = {"friend", "enemy", "lover"};

        Spinner spinner = findViewById(R.id.menu);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 0) {
                    otter_main.setVisibility(View.VISIBLE);
                    pigeon_main.setVisibility(View.INVISIBLE);
                    slime_main.setVisibility(View.INVISIBLE);
                }
                if (position == 1) {
                    otter_main.setVisibility(View.INVISIBLE);
                    pigeon_main.setVisibility(View.VISIBLE);
                    slime_main.setVisibility(View.INVISIBLE);
                }
                if (position == 2) {
                    otter_main.setVisibility(View.INVISIBLE);
                    pigeon_main.setVisibility(View.INVISIBLE);
                    slime_main.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                //literally do nothing
            }

        });


        ImageButton otter_button = findViewById((R.id.otter_main));
        otter_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OtterActivity.class);
                startActivity(intent);
            }
        });
    }
}