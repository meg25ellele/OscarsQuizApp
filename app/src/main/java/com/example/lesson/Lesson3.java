package com.example.lesson;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Lesson3 extends AppCompatActivity {

    Button lesson1;
    Button lesson2;
    Button home;
    Button tests;




    static  public boolean less1_read = false;
    static  public boolean less2_read = false;
    static  public boolean less3_read = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        less1_read = Lesson1.less1_read;
        less2_read = Lesson2.less2_read;
        less3_read = true;


        lesson1 = findViewById(R.id.but_les1_3);

        lesson1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Lesson3.this,Lesson1.class);
                startActivity(intent);

            }
        });

        lesson2 = findViewById(R.id.but_les2_3);

        lesson2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lesson3.this, Lesson2.class));
            }
        });

        home = findViewById(R.id.home_button);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson3.this,MainActivity.class);
                startActivity(intent);

            }
        });

        tests = findViewById(R.id.tests_button);

        tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(less1_read && less2_read && less3_read) {
                    Intent intent = new Intent(Lesson3.this, Test1.class);
                    startActivity(intent);
                } else
                {
                    Toast.makeText(getApplicationContext(),"Przeczytaj wszystkie lekcje!", Toast.LENGTH_SHORT).show();
                }

            }
        });





    }
}
