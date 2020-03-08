package com.example.lesson;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

public class Lesson2 extends AppCompatActivity implements View.OnTouchListener, ViewTreeObserver.OnScrollChangedListener {

    VideoView tango_viedo;
    ScrollView scrollView;
    MediaController mediaController;
    ImageView thumbnailView;
    Button playButton;

    Button lesson1;
    Button lesson3;
    Button home;

    static  public boolean less1_read = false;
    static  public boolean less2_read = false;
    static  public boolean less3_read = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        less1_read = Lesson1.less1_read;
        less2_read = true;
        less3_read = Lesson3.less3_read;


       scrollView = findViewById(R.id.scrollView2);
       thumbnailView  = findViewById(R.id.tango_img);
       playButton = findViewById(R.id.play_button);

        scrollView.setOnTouchListener(this);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(this);


        tango_viedo  = findViewById(R.id.video_tango);
        String videoPath ="android.resource://" + getPackageName() + "/" + R.raw.tango;
        Uri uri = Uri.parse(videoPath);
        tango_viedo.setVideoURI(uri);

        mediaController = new MediaController(this);
        tango_viedo.setMediaController(mediaController);
        mediaController.setAnchorView(tango_viedo);


        tango_viedo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                thumbnailView.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.VISIBLE);
                tango_viedo.setVisibility(View.GONE);
                mediaController.setVisibility(View.GONE);
            }
        });


        lesson3 = findViewById(R.id.but_les3_2);

        lesson3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lesson2.this, Lesson3.class));
            }
        });

        lesson1 = findViewById(R.id.but_les1_2);

        lesson1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lesson2.this, Lesson1.class));
            }
        });

        home = findViewById(R.id.home_button);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson2.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();

        tango_viedo.stopPlayback();

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onScrollChanged() {
        tango_viedo.pause();

        mediaController.hide();

    }

    public void playMethod(View view){
        tango_viedo.start();
        tango_viedo.setVisibility(View.VISIBLE);
        thumbnailView.setVisibility(View.GONE);
        playButton.setVisibility(View.GONE);

    }
}
