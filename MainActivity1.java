package com.example.bony.goti;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.os.Handler;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity1 extends AppCompatActivity {


    ImageView image;
    Thread thread;
    Handler handler=new Handler() ;
    MediaPlayer mp;
    private Matrix matrix = new Matrix();


    final int imagesize[]=new int []{R.drawable.a43,R.drawable.a41,R.drawable.ab,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.ac,R.drawable.ad,R.drawable.ae,R.drawable.af,R.drawable.ag,R.drawable.ah,R.drawable.ai,R.drawable.ao,R.drawable.ap,R.drawable.aq,R.drawable.ar,R.drawable.as,R.drawable.at,R.drawable.a21,R.drawable.ab1,R.drawable.ab2,R.drawable.au,R.drawable.av,R.drawable.aw,
            R.drawable.ax,R.drawable.ay,R.drawable.az,R.drawable.a29,R.drawable.a30,R.drawable.aa,R.drawable.aa1,R.drawable.aa2,R.drawable.aa3,R.drawable.aa4,R.drawable.aa5,R.drawable.a31,R.drawable.a32,R.drawable.a33,R.drawable.a34,R.drawable.a35,R.drawable.a36,R.drawable.a37,R.drawable.a38,R.drawable.a39,R.drawable.a40,R.drawable.a45,R.drawable.a46};
    int counter=0,i=0,b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        image = (ImageView) findViewById(R.id.imageView);
        ImageButton button1 = (ImageButton) findViewById(R.id.button1);
        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        ImageButton button3 = (ImageButton) findViewById(R.id.button3);


        mp= MediaPlayer.create(this, R.raw.sound1);
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
                    Thread.sleep(5440);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i=i+1;

            }

        }

    }

}


