package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private TextView cafe;
    private EditText Fname,Usn,Email,Password;


    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        cafe=(TextView) findViewById(R.id.banner);
        cafe.setOnClickListener(this);

        Fname = (EditText) findViewById(R.id.FNAME);
        Usn = (EditText) findViewById(R.id.USN);
        Email = (EditText) findViewById(R.id.EMAIL);
        Password = (EditText) findViewById(R.id.PASSWD);
        signup = findViewById(R.id.SIGNUP);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.banner:
                startActivity(new Intent(this,SignInActivity.class));
                break;
            case R.id.SIGNUP:
                RegisterUser();


        }
    }

    private void RegisterUser() {
        String email = Email.getText().toString().trim();
        String name = Fname.getText().toString().trim();
        String usn = Usn.getText().toString().trim();
        String passwd = Password.getText().toString().trim();

        if (email.isEmpty()) {
            Email.setError("Email is Required");
            Email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Email is Invalid");
            Email.requestFocus();
            return;
        }

        if (name.isEmpty()) {
            Fname.setError("Name is Required");
            Fname.requestFocus();
            return;
        }
        if (usn.isEmpty()) {
            Usn.setError("Usn is Required");
            Usn.requestFocus();
            return;
        }
        if (passwd.isEmpty()) {
            Password.setError("Password is Required");
            Password.requestFocus();
            return;
        }
        if (passwd.length() < 6) {
            Password.setError("Password is too short");
            Password.requestFocus();
            return;
        }


        mAuth.createUserWithEmailAndPassword(email, passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUpActivity.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
                    Intent signIn = new Intent(SignUpActivity.this,SignInActivity.class);
                    startActivity(signIn);

                } else {
                    Toast.makeText(SignUpActivity.this, "Failed to Register! Try Again", Toast.LENGTH_LONG).show();

                }
            }

        });
    }
    }