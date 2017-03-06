package com.example.bony.goti;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity {

    ImageView image;
    Thread thread;
    Handler handler=new Handler() ;
    MediaPlayer mp;
    final int imagesize[]=new int []{R.drawable.b1,R.drawable.b2,R.drawable.bb2,R.drawable.b5,R.drawable.b4,R.drawable.b10,R.drawable.b11,R.drawable.bb1,R.drawable.b6,R.drawable.b7,R.drawable.b8,R.drawable.b9,R.drawable.b12,R.drawable.b13,R.drawable.b14,R.drawable.b15,R.drawable.b16,R.drawable.b17,R.drawable.b18,R.drawable.b19,R.drawable.b21,R.drawable.b22,R.drawable.b23,R.drawable.b24,
            R.drawable.b25,R.drawable.b26,R.drawable.b27,R.drawable.b28,R.drawable.b31,R.drawable.b33,R.drawable.b34,R.drawable.b35,R.drawable.b36,R.drawable.b37,R.drawable.b38,R.drawable.b39,R.drawable.b40,R.drawable.b42,R.drawable.b43,R.drawable.b44,R.drawable.b45,R.drawable.b46,R.drawable.b47,R.drawable.b49,R.drawable.b50,R.drawable.b51};
    int counter=0,i=0,b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        image = (ImageView) findViewById(R.id.imageView);
        ImageButton button1 = (ImageButton) findViewById(R.id.button1);
        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        ImageButton button3 = (ImageButton) findViewById(R.id.button3);
        mp= MediaPlayer.create(this, R.raw.sound);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b==0) {
                    b=1;
                    mp.start();
                    thread = new Thread(new MainActivity3.Task());
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
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i=i+1;

            }

        }

    }

}
