package com.example.queerhack2020;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class OtterActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.otter_screen);

        ImageView otter_idle = (ImageView) findViewById(R.id.otter);
        otter_idle.setImageResource(R.drawable.otter_idle_animation);
        AnimationDrawable otter_idle_animation = (AnimationDrawable)otter_idle.getDrawable();
        otter_idle_animation.start();

        Button back = findViewById((R.id.back));
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(OtterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
