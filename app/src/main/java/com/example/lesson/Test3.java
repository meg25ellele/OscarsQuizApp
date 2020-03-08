package com.example.lesson;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Test3 extends AppCompatActivity {

    Button publikacjaButton;

    public static Integer answerId;
    public  static  Integer answer;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;

    RadioGroup group3;

    static  public boolean test3_done = false;

    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Test2.test2_done = true;

        publikacjaButton  = findViewById(R.id.pub_button);

        radio1 = findViewById(R.id.radio1_3);
        radio2 = findViewById(R.id.radio2_3);
        radio3 = findViewById(R.id.radio3_3);

        group3 = findViewById(R.id.Test3_group);

        publikacjaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnswerChecked();
                startActivity(new Intent(Test3.this,Publikacja1.class));
            }
        });

        home = findViewById(R.id.home_button);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test3.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }

    public void AnswerChecked()
    {
        answerId  = group3.getCheckedRadioButtonId();

        switch (answerId){
            case 2131296426:
                answer = 3;
                break;
            case 2131296423:
                answer = 2;
                break;
            case 2131296420:
                answer = 1;
                break;
            default:
                answer = 0;
                break;

        }

    }
}
