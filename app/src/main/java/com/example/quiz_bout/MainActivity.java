package com.example.quiz_bout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText name;
    Button BtnStrt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnStrt=findViewById(R.id.start_Qz);
        name=findViewById(R.id.name_Qz);

        BtnStrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = name.getText().toString();
                Intent Btst = new Intent(MainActivity.this,Quizpage1.class);
                Btst.putExtra("Name", str);
                startActivity(Btst);
            }
        });

        Button BtnAbout = findViewById(R.id.about_Qz);
        Button BtnDevlp= findViewById(R.id.devp_Qz);
        Button BtnExitQz= findViewById(R.id.exit_Qz);
        BtnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent one = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(one);
            }
        });

        BtnDevlp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent two = new Intent(MainActivity.this,DevelopersActivity.class);
                startActivity(two);
            }
        });

        BtnExitQz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }


}