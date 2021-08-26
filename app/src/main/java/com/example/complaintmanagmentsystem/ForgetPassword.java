package com.example.complaintmanagmentsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    Button forget;
    EditText forgetmail;
    FirebaseAuth Forgetcheck;

    public void backtopassword(View k){
        Intent backtopass = new Intent(ForgetPassword.this,MainActivity.class);
        startActivity(backtopass);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forget_password);
     forget=(Button)findViewById(R.id.reset);
     forgetmail=(EditText)findViewById(R.id.editTextTextEmailAddress);
     Forgetcheck=FirebaseAuth.getInstance();
     forget.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             needhelp();
         }
     });

    }
    public void needhelp() {
        String forgetmailstring = forgetmail.getText().toString();
        if (forgetmailstring.isEmpty()) {
            Toast.makeText(this, "Please enter the  register email", Toast.LENGTH_SHORT).show();
        }
        Forgetcheck.sendPasswordResetEmail(forgetmailstring).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull  Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ForgetPassword.this, "We have sent you instruction to reset you password!", Toast.LENGTH_SHORT).show();
                    Intent reseted = new Intent(ForgetPassword.this,MainActivity.class);
                    startActivity(reseted);
                } else {
                    Toast.makeText(ForgetPassword.this, "Filed to send reset mail!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}