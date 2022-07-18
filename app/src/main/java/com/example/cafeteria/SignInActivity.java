package com.example.cafeteria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private Button register;
    private EditText email,Password;
    private Button SignIn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        register= findViewById(R.id.Register);
        register.setOnClickListener(this);
        SignIn = findViewById(R.id.signin);
        SignIn.setOnClickListener(this);

        email = findViewById(R.id.emailSi);
        Password = findViewById(R.id.passwdSi);
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Register:
                startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
                break;
            case R.id.signin:
                userLogin();
                break;

        }
        if(v.equals(SignIn)){
            userLogin();
        }


    }
    private void userLogin() {
        String Email = email.getText().toString().trim();
        String passwd = Password.getText().toString().trim();

        if(Email.isEmpty()){
            email.setError("Email is required !");
            email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            email.setError("Enter A Valid Email!!");
            email.requestFocus();
            return;
        }
        if(passwd.isEmpty()){
            Password.setError("Password is Required!");
            Password.requestFocus();
            return;
        }
        if(passwd.length()<6){
            Password.setError("Min password length is 6 characters");
            Password.requestFocus();
            return;
        }


        mAuth.signInWithEmailAndPassword(Email,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(SignInActivity.this,MainActivity.class));

                }
                else{
                    Toast.makeText(SignInActivity.this,"Failed to Login! Check Credentials",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}