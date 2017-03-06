package com.example.bony.goti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.os.Handler;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity4 extends AppCompatActivity {


    ImageView image;
    Thread thread;
    Handler handler=new Handler() ;
    MediaPlayer mp;
    int counter=0,i=0,b=0;
    final int imagesize[]=new int []{R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.c11,R.drawable.c12,R.drawable.c13,R.drawable.c14,R.drawable.c15,R.drawable.c16,R.drawable.c,R.drawable.c18,R.drawable.c20,R.drawable.c21,R.drawable.c23,R.drawable.c24,R.drawable.c25,R.drawable.c26,R.drawable.c28,
            R.drawable.c29,R.drawable.c30,R.drawable.c31,R.drawable.c32,R.drawable.c33,R.drawable.c34,R.drawable.c35,R.drawable.c36,R.drawable.c37,R.drawable.c38,R.drawable.c39,R.drawable.c40,R.drawable.c41};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        image = (ImageView) findViewById(R.id.imageView);
        ImageButton button1 = (ImageButton) findViewById(R.id.button1);
        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        ImageButton button3 = (ImageButton) findViewById(R.id.button3);
        mp= MediaPlayer.create(this, R.raw.sound2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b==0) {
                    b=1;
                    mp.start();
                    thread = new Thread(new Task());
                    thread.start();

                }
                else {
                    b = 0;
                    mp.pause();

                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener()
                                   {

                                       @Override
                                       public void onClick(View v) {
                                           counter++;


                                           if(counter ==imagesize.length){
                                               counter=0;
                                           }
                                           image.setImageResource(imagesize[counter]);

                                       }
                                   }
        );
        button1.setOnClickListener(new View.OnClickListener()
                                   {

                                       @Override
                                       public void onClick(View v) {
                                           counter--;
                                           if(counter<0)
                                           {
                                               counter=imagesize.length-1;
                                           }
                                           image.setImageResource(imagesize[counter]);


                                       }
                                   }
        );

    }
    class Task implements Runnable {
        @Override
        public void run() {

            while (i <imagesize.length+1&&b==1) {



                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        if(i==imagesize.length) {
                            image.setImageResource(imagesize[0]);
                            b=0;
                            mp.pause();
                            mp.seekTo(0);
                            i=0;

                        }

                        else
                            image.setImageResource(imagesize[i]);

                    }
                });
                //bar.setProgress(i);
                try {
                    Thread.sleep(5500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i=i+1;

            }

        }

    }

}
