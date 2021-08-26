package com.example.complaintmanagmentsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
public class Registrationform extends AppCompatActivity {

    public void backtoFunction(View v) {
        Intent run = new Intent(Registrationform.this, Signuppage.class);
        startActivity(run);
    }
    public void needhelpfunction(View n){
        Intent secondfunction = new Intent(Registrationform.this,ForgetPassword.class);
        startActivity(secondfunction);
    }
    public void logininregister(View lr){
        Intent Lk =new Intent(Registrationform.this,MainActivity.class);
        startActivity(Lk);
        }

    EditText email,pwd,name;
    Button Signup;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registrationform);

        email = (EditText) findViewById(R.id.Singinemail);
        pwd = (EditText) findViewById(R.id.SigninPassword);
        name=(EditText) findViewById(R.id.Nameloin);
        Signup=(Button)findViewById(R.id.login);
        firebaseAuth = FirebaseAuth.getInstance();
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Registration();
            }
        });
    }

    public void Registration() {

        String usermail = email.getText().toString();
        String userpwd = pwd.getText().toString();
        String username=name.getText().toString();

        if (usermail.isEmpty())
        {
            Toast.makeText(this, "Please check email", Toast.LENGTH_SHORT).show();
        }
        else if (userpwd.isEmpty())
        {
            Toast.makeText(this, "Please check Password", Toast.LENGTH_SHORT).show();
        }
        else if(username.isEmpty())
        {
            Toast.makeText(this, "Please check Name", Toast.LENGTH_SHORT).show();
        }
        firebaseAuth.createUserWithEmailAndPassword(usermail,userpwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Registrationform.this, "Registration is Succesfull", Toast.LENGTH_SHORT).show();
                    Intent lag = new Intent(Registrationform.this, MainActivity.class);
                    startActivity(lag);
                } else {
                    Toast.makeText(Registrationform.this, "Registration is UnSuccesfull, Please try again ", Toast.LENGTH_SHORT).show();
                }

            }


        });


    }
}