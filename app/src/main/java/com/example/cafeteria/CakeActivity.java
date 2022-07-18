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

public class CakeActivity extends AppCompatActivity {

    EditText cakeNos;
    Button cakeAdd,cakeSub,cakeOrder;

    FirebaseFirestore database = FirebaseFirestore.getInstance();

    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);

        cakeNos = (EditText) findViewById(R.id.cakeNos);
        cakeAdd = (Button) findViewById(R.id.cakeAdd);
        cakeSub = (Button) findViewById(R.id.cakeSub);
        cakeOrder = (Button) findViewById(R.id.cakeOrder);

        Bundle username = getIntent().getExtras();

        String Uname = username.getString("key1","defalut");

        cakeAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                cakeNos.setText(String.valueOf(nos));
            }
        });

        cakeSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos-=1;
                cakeNos.setText(String.valueOf(nos));
            }
        });

        cakeOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                cakeStore(nos,Uname);
                Intent cakeOrder = new Intent(CakeActivity.this,MainActivity.class);
                cakeOrder.putExtras(username);
                startActivity(cakeOrder);
            }
        });

    }
    public void cakeStore(int nos, String Uname)
    {
        Map<String, Object> user = new HashMap<>();
        user.put("Cake Nos", nos);

        database.collection("Orders")
                .document(Uname).set(user, SetOptions.merge());
    }
}