package com.shiftux.frenchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button blackBtn, greenBtn, purpleBtn, redBtn, yellowBtn;
    ProgressBar learnBar;
    int progress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        blackBtn=findViewById(R.id.blackBtn);
        greenBtn=findViewById(R.id.greenBtn);
        purpleBtn=findViewById(R.id.purpleBtn);
        redBtn=findViewById(R.id.redBtn);
        yellowBtn=findViewById(R.id.yellowBtn);

        //Progress Bar
        learnBar=findViewById(R.id.progress);

        //Button Listener -Traditional Boiler-plate code
//        redBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MediaPlayer play= MediaPlayer.create(
//                        getApplicationContext(),
//                        R.raw.red
//                );
//                play.start();
//            }
//        });

        //Button Listener - Using Interfaces
        // [here "this" is referring to the interface resulting in connecting the buttons to it]
        redBtn.setOnClickListener(this);
        blackBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);

        learnBar.setOnClickListener(this);
    }

    //View.onCLickListener Interface contains this to over ride
    @Override
    public void onClick(View v) {
        int btnId= v.getId();

        if(btnId== R.id.redBtn){
            playSound(R.raw.red);
            progress+=10;
            learnBar.setProgress(progress);
        } else if (btnId==R.id.blackBtn) {
            progress+=10;
            learnBar.setProgress(progress);
            playSound(R.raw.black);
        } else if (btnId==R.id.greenBtn) {
            playSound(R.raw.green);
            progress+=10;
            learnBar.setProgress(progress);
        } else if (btnId==R.id.purpleBtn) {
            playSound(R.raw.purple);
            progress+=10;
            learnBar.setProgress(progress);
        } else if (btnId==R.id.yellowBtn) {
            playSound(R.raw.yellow);
            progress+=10;
            learnBar.setProgress(progress);
        }
    }

    public void playSound(int id){
            MediaPlayer play= MediaPlayer.create(
                    this,
                    id
            );
            play.start();
    }
}