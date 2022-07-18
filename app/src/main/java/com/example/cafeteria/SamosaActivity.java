package com.example.cafeteria;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class SamosaActivity extends AppCompatActivity {

    EditText samosaNos;
    Button samosaAdd,samosaSub,samosaOrder;

    FirebaseFirestore database = FirebaseFirestore.getInstance();

    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samosa);

        samosaNos = (EditText) findViewById(R.id.samosaNos);
        samosaAdd = (Button) findViewById(R.id.samosaAdd);
        samosaSub = (Button) findViewById(R.id.samosaSub);
        samosaOrder = (Button) findViewById(R.id.samosaOrder);

        Bundle username = getIntent().getExtras();

        String Uname = username.getString("key1","default");

        samosaAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                samosaNos.setText(String.valueOf(nos));
            }
        });

        samosaSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos-=1;
                samosaNos.setText(String.valueOf(nos));
            }
        });

        samosaOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                samosaStore(nos,Uname);
                Intent samosaOrder = new Intent(SamosaActivity.this,MainActivity.class);
                samosaOrder.putExtras(username);
                startActivity(samosaOrder);
            }
        });

    }
    public void samosaStore(int nos, String Uname)
    {
        Map<String, Object> user = new HashMap<>();
        user.put("Samosa Nos", nos);

        database.collection("Orders")
                .document(Uname).set(user, SetOptions.merge());
    }
}
