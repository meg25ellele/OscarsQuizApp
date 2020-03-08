package com.example.lesson;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.pm.ActivityInfo;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    static  public boolean less1_read = false;
    static  public boolean less2_read = false;
    static  public boolean less3_read = false;

    Button sumButton;
    Button restButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        less1_read = Lesson1.less1_read;
        less2_read = Lesson2.less2_read;
        less3_read = Lesson3.less3_read;

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final Button lessonB = findViewById(R.id.lesson_button);

        lessonB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Lesson1.class));
            }
        });

        final Button testB = findViewById(R.id.test_button);

        testB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(less1_read && less2_read && less3_read){

                    if(!Test1.test1_done){
                        startActivity(new Intent(MainActivity.this, Test1.class));
                    }
                   else if(!Test2.test2_done){
                        startActivity(new Intent(MainActivity.this, Test2.class));
                    }
                    else if (!Test3.test3_done)
                    {
                        startActivity(new Intent(MainActivity.this, Test3.class));
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Wszyskie testy zrobione, przejdź do Publikacji Testów!", Toast.LENGTH_SHORT).show();
                    }

                }
                else {

                    Toast.makeText(getApplicationContext(),"Przeczytaj wszystkie lekcje!", Toast.LENGTH_SHORT).show();

                }

            }
        });

        sumButton = findViewById(R.id.podsumowanie_button);

        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Test1.test1_done && Test2.test2_done && Test3.test3_done) {
                    startActivity(new Intent(MainActivity.this,Publikacja1.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Zrób wszystkie testy!", Toast.LENGTH_SHORT).show();

                }
            }
        });

        restButton = findViewById(R.id.restart_button);

        restButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Test1.test1_done = false;
                Test2.test2_done = false;
                Test3. test3_done = false;

            }
        });


    }
}
