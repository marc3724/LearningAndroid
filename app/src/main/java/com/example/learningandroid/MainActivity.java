package com.example.learningandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button add,send;
    EditText size;
    LinearLayout list;
    ArrayList<String> text = new ArrayList<>();
    Context context;

//start
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttons
        add = findViewById(R.id.add_Pic);
        send = findViewById(R.id.send);

        //text and layout
        size = findViewById(R.id.size);
        list = findViewById(R.id.list);
        context = this;

        //add button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addView();
            }
        });

        //send Button
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("hey");
                for (int i = 0; i < list.getChildCount(); i++) {
                    if (list.getChildAt(i) instanceof LinearLayoutCompat) {
                        LinearLayoutCompat ll = (LinearLayoutCompat) list.getChildAt(i);
                        System.out.println("hey 1");

                        for (int j = 0; j  < ll.getChildCount(); j++) {
                            if (ll.getChildAt(j)instanceof EditText){
                                EditText et = (EditText) ll.getChildAt(j);
                                System.out.println("hey2");

                                if (et.getId() == R.id.size){
                                    System.out.println(et.getText().toString());
                                    Toast.makeText(context,"hey3 "+et.getText().toString(),Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("no hey");
                    }
                }
            }
        });

    }



    private void addView(){
        final View aa = getLayoutInflater().inflate(R.layout.add_cam,null,false);
        //change imageview to row and it should work with implement, also make a new row to implement
        ImageView cross =(ImageView) aa.findViewById(R.id.cross2);

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               removeView(aa);
            }
        });
        list.addView(aa);

    }




    private void removeView(View view){
        list.removeView(view);
    }


}