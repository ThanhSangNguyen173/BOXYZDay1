package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private Button bt2, bt3;
    private EditText tk, mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);
        tk = findViewById(R.id.tk);
        mk = findViewById(R.id.mk);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity();
            }
        });

        tk.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                enableSubmitIfReady();}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        mk.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                matkhauReady();}
        });
    }

    public void openactivity(){
        Intent intent2 = new Intent(this, Activity3.class);
        startActivity(intent2);
    }

    public void enableSubmitIfReady() {

        boolean isReady = tk.getText().toString().length()>0;
        bt3.setEnabled(isReady);
    }

    public void matkhauReady() {
        boolean taikhoan = tk.getText().toString().length()>0;
        boolean isReady = mk.getText().toString().length()>0;
        if(taikhoan == false){
            bt2.setEnabled(false);
        }
        else bt2.setEnabled(isReady);
    }
}


