package com.example.complaintmanagmentsystem;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText emaillogin, passwordlogin;
    Button login;
    FirebaseAuth firebaseAuthlogin;
 public void Needhelp(View N){
     Intent forget=new Intent(MainActivity.this,ForgetPassword.class);
     startActivity(forget);


 }
    public void Signuppage(View S){
        Intent go =new Intent(this,Registrationform.class);
         startActivity(go);
    }
    public void BackFuntion(View M) {
        Intent back = new Intent(this, Signuppage.class);
        startActivity(back);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        emaillogin = (EditText) findViewById(R.id.Singinemail);
        passwordlogin = (EditText) findViewById(R.id.SigninPassword);
        login = (Button) findViewById(R.id.login);

        firebaseAuthlogin = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity();
            }
        });


    }

    public void LoginActivity() {
        String mail, pwd;
        mail = emaillogin.getText().toString();
        pwd = passwordlogin.getText().toString();
        if (mail.isEmpty()) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
        } else if (pwd.isEmpty()) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
        }


        firebaseAuthlogin.signInWithEmailAndPassword(mail, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Login Successfull!!", Toast.LENGTH_SHORT).show();
                    Intent start = new Intent(MainActivity.this, Main_page.class);
                    startActivity(start);
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed!!", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }


}
