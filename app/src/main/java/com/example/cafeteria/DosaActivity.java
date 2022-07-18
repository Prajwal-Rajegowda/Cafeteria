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

public class DosaActivity extends AppCompatActivity {

    EditText dosaNos;
    Button dosaAdd,dosaSub,dosaOrder;

    FirebaseFirestore database = FirebaseFirestore.getInstance();

    int nos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosa);

        dosaNos = (EditText) findViewById(R.id.dosaNos);
        dosaAdd = (Button) findViewById(R.id.dosaAdd);
        dosaSub = (Button) findViewById(R.id.dosaSub);
        dosaOrder = (Button) findViewById(R.id.dosaOrder);

        Bundle username = getIntent().getExtras();

        String Uname = username.getString("key1","default");

        dosaAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                dosaNos.setText(String.valueOf(nos));
            }
        });

        dosaSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos-=1;
                dosaNos.setText(String.valueOf(nos));
            }
        });

        dosaOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dosaStore(nos,Uname);
                Intent dosaOrder = new Intent(DosaActivity.this,MainActivity.class);
                dosaOrder.putExtras(username);
                startActivity(dosaOrder);
            }
        });
    }
    public void dosaStore(int nos, String Uname)
    {
        Map<String, Object> user = new HashMap<>();
        user.put("Dosa Nos", nos);

        database.collection("Orders")
                .document(Uname).set(user, SetOptions.merge());
    }
}