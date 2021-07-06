package com.example.togglemediaplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mp = null;
    public MediaPlayer sneezeSound;
    public MediaPlayer blowSound;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //Depending on sound that is set, the alternative will be set
        if( mp == sneezeSound){
            mp = blowSound;
        }else if(mp == blowSound){
            mp = sneezeSound;
        }
        mp.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sneezeSound = MediaPlayer.create(this, R.raw.sneeze2);
        blowSound = MediaPlayer.create(this, R.raw.blow_nose);

        Button sneeze = (Button) this.findViewById(R.id.sneezeButton);
        sneeze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Plays sound
                mp = sneezeSound;
                mp.start();
            }
        });

        Button blow = (Button) this.findViewById(R.id.blowButton);
        blow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Plays sound
                mp = blowSound;
                mp.start();
            }

        });

    }
}