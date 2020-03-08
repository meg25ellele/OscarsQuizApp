package com.example.lesson;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lesson1 extends AppCompatActivity {

    Button lesson2;
    Button lesson3;
    Button home;

     static  public boolean less1_read = false;
     static  public boolean less2_read = false;
     static  public boolean less3_read = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        less1_read = true;
        less2_read = Lesson2.less2_read;
        less3_read = Lesson3.less3_read;

       lesson2 = findViewById(R.id.but_les2_1);

        lesson2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson1.this, Lesson2.class);
                startActivity(intent);

            }
        });

        lesson3 = findViewById(R.id.but_les3_1);

        lesson3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson1.this, Lesson3.class);
                startActivity(intent);
            }
        });

        home = findViewById(R.id.home_button);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson1.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
