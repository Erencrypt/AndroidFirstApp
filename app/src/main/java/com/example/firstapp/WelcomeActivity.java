package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvName;
    private String  strName;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tvName=(TextView) findViewById(R.id.tvName);
        Bundle bundle =getIntent().getExtras();
        strName=bundle.getString("NAME");
        tvName.setText(strName);
        back=(Button) findViewById(R.id.btnBack);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}