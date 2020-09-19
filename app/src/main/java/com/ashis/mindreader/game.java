package com.ashis.mindreader;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.util.ArrayList;
import java.util.List;

public class game extends AppCompatActivity {
    TextView my_score,your_score;
    ImageView heads,tails;
    int myscore,yourscore;
    Button restart,finishbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        my_score=findViewById(R.id.my_score);
        your_score=findViewById(R.id.your_score);
        heads=findViewById(R.id.heads);
        tails=findViewById(R.id.tails);
        restart=findViewById(R.id.restart);
        myscore=0;
        yourscore=0;
        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));

        Python py = Python.getInstance();
        final PyObject pyobj = py.getModule("script");
        heads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PyObject obj1 = pyobj.callAttr("gameplay","1");
                if (obj1.toString().equals("1")){
                    myscore++;
                    my_score.setText(String.valueOf(myscore));
                    your_score.setText(String.valueOf(yourscore));
                }else {
                    yourscore++;
                    my_score.setText(String.valueOf(myscore));
                    your_score.setText(String.valueOf(yourscore));
                }
                if (my_score.getText().toString().equals("20")){
                    final Dialog dialog=new Dialog(game.this);
                    dialog.setContentView(R.layout.dialog);
                    dialog.show();
                    finishbutton=dialog.findViewById(R.id.finish_button);
                    finishbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            PyObject obj4= pyobj.callAttr("reset");
                            myscore=0;
                            yourscore=0;
                            my_score.setText("0");
                            your_score.setText("0");

                        }
                    });
                } else if(your_score.getText().toString().equals("20")){
                    final Dialog dialog1=new Dialog(game.this);
                    dialog1.setContentView(R.layout.dialog1);
                    dialog1.show();
                    finishbutton=dialog1.findViewById(R.id.finish_button);
                    finishbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog1.dismiss();
                            PyObject obj5= pyobj.callAttr("reset");
                            myscore=0;
                            yourscore=0;
                            my_score.setText("0");
                            your_score.setText("0");

                        }
                    });

                }


            }
        });
        tails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PyObject obj2 = pyobj.callAttr("gameplay","0");
                if (obj2.toString().equals("0")){
                    myscore++;
                    my_score.setText(String.valueOf(myscore));
                    your_score.setText(String.valueOf(yourscore));
                }else{
                    yourscore++;
                    my_score.setText(String.valueOf(myscore));
                    your_score.setText(String.valueOf(yourscore));
                }

                if (my_score.getText().toString().equals("20")){
                    final Dialog dialog=new Dialog(game.this);
                    dialog.setContentView(R.layout.dialog);
                    dialog.show();
                    finishbutton=dialog.findViewById(R.id.finish_button);
                    finishbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            PyObject obj4= pyobj.callAttr("reset");
                            myscore=0;
                            yourscore=0;
                            my_score.setText("0");
                            your_score.setText("0");

                        }
                    });
                } else if(your_score.getText().toString().equals("20")){
                    final Dialog dialog1=new Dialog(game.this);
                    dialog1.setContentView(R.layout.dialog1);
                    dialog1.show();
                    finishbutton=dialog1.findViewById(R.id.finish_button);
                    finishbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog1.dismiss();
                            PyObject obj5= pyobj.callAttr("reset");
                            myscore=0;
                            yourscore=0;
                            my_score.setText("0");
                            your_score.setText("0");

                        }
                    });

                }

            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PyObject obj3= pyobj.callAttr("reset");
                myscore=0;
                yourscore=0;
                my_score.setText("0");
                your_score.setText("0");
            }
        });



    }

}