package com.example.complaintmanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main_page extends AppCompatActivity {
EditText Branch,Complaint,Name,Rollno;
Button Register;
FirebaseDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_page);
    }
    public void complaintprocess(View cp){
        Branch=(EditText) findViewById(R.id.branchid);
        Complaint=(EditText)findViewById(R.id.complaintid);
        Name=(EditText)findViewById(R.id.nameid);
        Rollno=(EditText)findViewById(R.id.rollnoid);

        String branchcm=Branch.getText().toString().trim();
        String complaintcm=Complaint.getText().toString().trim();
        String Namecm=Name.getText().toString().trim();
        String Rollnocm=Rollno.getText().toString().trim();

        datastorage obj= new datastorage(Namecm,branchcm,complaintcm);
         database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Student");
        myRef.child(Rollnocm).setValue(obj);
        Rollno.setText("");
        Name.setText("");
        Branch.setText("");
        Complaint.setText("");
        Toast.makeText(this, "Complaint Registerd!! ", Toast.LENGTH_SHORT).show();
    }
}