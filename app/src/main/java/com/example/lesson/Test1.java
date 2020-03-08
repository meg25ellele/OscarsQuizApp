package com.example.lesson;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.VideoView;

public class Test1 extends AppCompatActivity {

    Button playButton;
    MediaController mediaController;
    ImageView thumbnailView;
    VideoView silence_video;

    final static Integer correct_answer = 2;
    public static Integer answerId;
    public  static  Integer answer;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;

    RadioGroup group1;

    static  public boolean test1_done = false;

    Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



        radio1 = findViewById(R.id.radio1_1);
        radio2 = findViewById(R.id.radio2_1);
        radio3 = findViewById(R.id.radio3_1);

        group1 = findViewById(R.id.Test1_group);


        playButton = findViewById(R.id.play_button_silence);
        thumbnailView = findViewById(R.id.silence_img);

        silence_video  = findViewById(R.id.silence_video);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.silence;
        Uri uri = Uri.parse(videoPath);
        silence_video.setVideoURI(uri);

        silence_video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                thumbnailView.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.VISIBLE);
            }
        });

        mediaController = new MediaController(this);
        silence_video.setMediaController(mediaController);
        mediaController.setAnchorView(mediaController);


        final Button test2 = findViewById(R.id.but_test2_1);

        test2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AnswerChecked();
                startActivity(new Intent(Test1.this, Test2.class));
            }
        });

        home = findViewById(R.id.home_button);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test1.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }

    public void playMethod(View view){
        silence_video.start();
        thumbnailView.setVisibility(View.GONE);
        playButton.setVisibility(View.GONE);

    }

    @Override
    protected void onStop() {
        super.onStop();

        silence_video.stopPlayback();

    }


    public void AnswerChecked()
    {
        answerId  = group1.getCheckedRadioButtonId();

        switch (answerId){
            case 2131296424:
                answer = 3;
                break;
            case 2131296421:
                answer = 2;
                break;
            case 2131296418:
                answer = 1;
                break;
            default:
                answer = 0;
                break;

        }

    }
}
