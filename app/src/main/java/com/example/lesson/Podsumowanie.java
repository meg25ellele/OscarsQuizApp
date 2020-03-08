package com.example.lesson;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Podsumowanie extends AppCompatActivity {


    Button home;

    ImageView winning_gif;
    TextView score;

    Integer scoreI = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podsumowanie);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        winning_gif =findViewById(R.id.gossling);
        score = findViewById(R.id.scoreText);


        if(Test1.answer == 2) {
            scoreI++;
        }

        if(Test2.answer == 1) {
            scoreI++;
        }

        if(Test3.answer == 1) {
            scoreI++;
        }


        String scoreS = scoreI.toString() + "/3";

        score.setText(scoreS);

        switch (scoreI) {
            case 0:
                winning_gif.setImageResource(R.drawable.bad);
                break;
            case 1:
                winning_gif.setImageResource(R.drawable.bad);
                break;
            case 2:
                winning_gif.setImageResource(R.drawable.good);
                break;
            case 3:
                winning_gif.setImageResource(R.drawable.best);
                break;
        }
        home = findViewById(R.id.home_button);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Podsumowanie.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
