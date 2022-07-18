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

public class BreadPakodaActivity extends AppCompatActivity {


    EditText breadNos;
    Button breadAdd,breadSub,breadOrder;

    FirebaseFirestore database = FirebaseFirestore.getInstance();

    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread_pakoda);

        breadNos = (EditText) findViewById(R.id.breadNos);
        breadAdd = (Button) findViewById(R.id.breadAdd);
        breadSub = (Button) findViewById(R.id.breadSub);
        breadOrder = (Button) findViewById(R.id.breadOrder);

        Bundle username = getIntent().getExtras();

        String Uname = username.getString("key1","default");

        breadAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                breadNos.setText(String.valueOf(nos));
            }
        });

        breadSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos-=1;
                breadNos.setText(String.valueOf(nos));
            }
        });

        breadOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                breadStore(nos,Uname);
                Intent breadOrder = new Intent(BreadPakodaActivity.this,MainActivity.class);
                breadOrder.putExtras(username);
                startActivity(breadOrder);
            }
        });

    }
    public void breadStore(int nos, String Uname)
    {
        Map<String, Object> user = new HashMap<>();
        user.put("Bread Pakoda Nos", nos);

        database.collection("Orders")
                .document(Uname).set(user, SetOptions.merge());
    }
}