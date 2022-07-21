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
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class PaniPuriActivity extends AppCompatActivity {

    EditText paniNos;
    Button paniAdd,paniSub,paniOrder;

    FirebaseFirestore database = FirebaseFirestore.getInstance();

    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pani_puri);

        paniNos = (EditText) findViewById(R.id.paniNos);
        paniAdd = (Button) findViewById(R.id.paniAdd);
        paniSub = (Button) findViewById(R.id.paniSub);
        paniOrder = (Button) findViewById(R.id.paniOrder);

        Bundle username = getIntent().getExtras();

        String Uname = username.getString("key1","default");

        paniAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                paniNos.setText(String.valueOf(nos));
            }
        });

        paniSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            { if(nos>0){
                nos -= 1;
            }
            else {
                nos=0;
            }
                paniNos.setText(String.valueOf(nos));
            }
        });

        paniOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(nos>0)
                {
                    paniStore(nos,Uname);
                    Intent paniOrder = new Intent(PaniPuriActivity.this,MainActivity.class);
                    paniOrder.putExtras(username);
                    startActivity(paniOrder);
                }
                else Toast.makeText(getBaseContext(),"Add item before Ordering!", Toast.LENGTH_LONG).show();
            }
        });


    }
    public void paniStore(int nos, String Uname)
    {
        Map<String, Object> user = new HashMap<>();
        user.put("Pani Puri Nos", nos);

        database.collection("Orders")
                .document(Uname).set(user, SetOptions.merge());
    }
}