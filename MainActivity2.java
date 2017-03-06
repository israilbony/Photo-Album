package com.example.bony.goti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity2 extends AppCompatActivity {

    private EditText editText1,editText2;
    private Button button;
    int a=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((editText1.getText().toString().equals("bonygoti"))&&editText2.getText().toString().equals("gotiiloveu"))
                {
                    Toast.makeText(MainActivity2.this,"User and Password is correct",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent("com.example.bony.goti.MainActivity3");
                    startActivity(intent);
                }
                else
                {


                        Toast.makeText(MainActivity2.this,"User and Password is not correct",Toast.LENGTH_SHORT).show();



    }
            }
        });
    }


    }



