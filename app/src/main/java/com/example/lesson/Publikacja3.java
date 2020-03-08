package com.example.lesson;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Publikacja3 extends AppCompatActivity {


    String ans;

    TextView odp;

    TextView answ1;
    TextView answ2;
    TextView answ3;


    Button summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publikacja3);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        answ1 = findViewById(R.id.answer1_3);
        answ2 = findViewById(R.id.answer2_3);
        answ3 = findViewById(R.id.answer3_3);

        odp =findViewById(R.id.odpText);



        ans = Test3.answer.toString();

        odp.setText(ans);



        switch (ans){
            case "1":
                answ1.setBackgroundColor(Color.GREEN);
                break;
            case "2":
                answ1.setBackgroundColor(Color.GREEN);
                answ2.setBackgroundColor(Color.RED);
                break;
            case "3":
                answ3.setBackgroundColor(Color.RED);
                answ1.setBackgroundColor(Color.GREEN);
                break;
            case "0":
                answ2.setBackgroundColor(Color.RED);
                answ1.setBackgroundColor(Color.GREEN);
                answ3.setBackgroundColor(Color.RED);
                break;

        }

        summary = findViewById(R.id.podsumowanie_button);

        summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Publikacja3.this,Podsumowanie.class));
            }
        });



    }
}
