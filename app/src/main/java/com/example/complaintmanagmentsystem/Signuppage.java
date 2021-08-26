package com.example.complaintmanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Signuppage extends AppCompatActivity {

    public void SinginFunction(View view) {
        Intent singin = new Intent(this, MainActivity.class);
        startActivity(singin);

    }

    public void SignupFunctionbutton(View n){
        Intent Signupnow =new Intent(this,Registrationform.class);
        startActivity(Signupnow);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signuppage);
    }
}