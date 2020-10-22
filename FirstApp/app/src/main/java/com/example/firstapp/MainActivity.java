package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText) findViewById(R.id.edtName);
        send=(Button) findViewById(R.id.btnSend);
        send.setOnClickListener(this);
    }

    private Editable text;
    @Override
    public void onClick(View view){
        text=name.getText();
        if (isValidName(text.toString())){goToWelcome(text.toString());}
        else {Toast.makeText(this,getString(R.string.error_message),Toast.LENGTH_SHORT).show();}
    }

    private void goToWelcome(String name){
        Bundle bundle =new Bundle();
        bundle.putString("NAME",name);
        Intent intent=new Intent(this,WelcomeActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private boolean isValidName(String name){
        if (name.length()>=3 && name.length()<=20){return true;}
        else {return false;}
    }
}