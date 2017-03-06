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

public class MainActivity5 extends AppCompatActivity {


    ImageView image;
    Thread thread;
    Handler handler=new Handler() ;
    MediaPlayer mp;
    int counter=0,i=0,b=0;
    final int imagesize[]=new int []{R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,R.drawable.d11,R.drawable.d12,R.drawable.d13,R.drawable.d14,R.drawable.d15,R.drawable.d16,R.drawable.d17,R.drawable.d18,R.drawable.d20,R.drawable.d21,R.drawable.d22,R.drawable.d23,R.drawable.d24,R.drawable.d25,R.drawable.d26,R.drawable.d27,
          R.drawable.d28, R.drawable.d30,R.drawable.d31,R.drawable.d32,R.drawable.d33,R.drawable.d34,R.drawable.d35,R.drawable.d36,R.drawable.d37,R.drawable.d40};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        image = (ImageView) findViewById(R.id.imageView);
        ImageButton button1 = (ImageButton) findViewById(R.id.button1);
        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        ImageButton button3 = (ImageButton) findViewById(R.id.button3);
        mp= MediaPlayer.create(this, R.raw.sound4);
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
                    Thread.sleep(8500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i=i+1;

            }

        }

    }

}
