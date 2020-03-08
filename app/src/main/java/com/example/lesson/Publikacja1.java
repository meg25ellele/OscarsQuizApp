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

public class Publikacja1 extends AppCompatActivity {

    String ans;

    TextView odp;

    TextView answ1;
    TextView answ2;
    TextView answ3;


    Button pub2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publikacja1);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Test3.test3_done =true;

        answ1 = findViewById(R.id.answer1_1);
        answ2 = findViewById(R.id.answer2_1);
        answ3 = findViewById(R.id.answer3_1);

        odp =findViewById(R.id.odpText);

        pub2 = findViewById(R.id.but_pub2_1);

        pub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Publikacja1.this, Publikacja2.class));
            }
        });



        ans = Test1.answer.toString();

        odp.setText(ans);



        switch (ans){
            case "1":
                answ1.setBackgroundColor(Color.RED);
                answ2.setBackgroundColor(Color.GREEN);
                break;
            case "2":
                answ2.setBackgroundColor(Color.GREEN);
                break;
            case "3":
                answ3.setBackgroundColor(Color.RED);
                answ2.setBackgroundColor(Color.GREEN);
                break;
            case "0":
                answ1.setBackgroundColor(Color.RED);
                answ2.setBackgroundColor(Color.GREEN);
                answ3.setBackgroundColor(Color.RED);
                break;

        }

    }
}
