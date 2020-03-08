package com.example.lesson;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class Test2 extends AppCompatActivity {


    Button playBtn;
    SeekBar positionBar;
    MediaPlayer mp;
    int totalTime;


    public static Integer answerId;
    public  static  Integer answer;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;

    RadioGroup group2;

    static  public boolean test2_done = false;

    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);



        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Test1.test1_done = true;

        radio1 = findViewById(R.id.radio1_2);
        radio2 = findViewById(R.id.radio2_2);
        radio3 = findViewById(R.id.radio3_2);

        group2 = findViewById(R.id.Test2_group);

        playBtn = findViewById(R.id.play_button);

        //MediaPlayer
        mp = MediaPlayer.create(this,R.raw.serduszka);
       // mp.setLooping(true);
        mp.seekTo(0);
        mp.setVolume(0.5f,0.5f);
       totalTime =  mp.getDuration();

        //PositionBar
        positionBar = findViewById(R.id.musicBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                         if(fromUser){
                             mp.seekTo(progress);
                             positionBar.setProgress(progress);
                         }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );


        //Thred(update possitionBar)
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp!=null){
                    try {

                        Message msg = new Message();
                        msg.what = mp.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {}
                }
            }
        }).start();

        final Button test3 = findViewById(R.id.but_test3_2);

        test3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AnswerChecked();
                startActivity(new Intent(Test2.this, Test3.class));
            }
        });

        home = findViewById(R.id.home_button);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test2.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage( Message msg) {
            int currentPossition  = msg.what;
            //update possitionBar
            positionBar.setProgress(currentPossition);
        }
    };

    public void playMethod(View view){

        if(!mp.isPlaying()){
            mp.start();
            playBtn.setBackgroundResource(R.drawable.pause_icon);
        } else
        {
            mp.pause();
            playBtn.setBackgroundResource(R.drawable.play_icon);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.pause();
        mp.seekTo(0);
        playBtn.setBackgroundResource(R.drawable.play_icon);
    }

    public void AnswerChecked()
    {
        answerId  = group2.getCheckedRadioButtonId();

        switch (answerId){
            case 2131296425:
                answer = 3;
                break;
            case 2131296422:
                answer = 2;
                break;
            case 2131296419:
                answer = 1;
                break;
            default:
                answer = 0;
                break;

        }

    }
}
