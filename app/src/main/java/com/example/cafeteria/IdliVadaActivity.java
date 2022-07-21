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

public class IdliVadaActivity extends AppCompatActivity {

    EditText idliNos;
    Button idliAdd,idliSub,idliOrder;

    FirebaseFirestore database = FirebaseFirestore.getInstance();

    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idli_vada);

        idliNos = (EditText) findViewById(R.id.idliNos);
        idliAdd = (Button) findViewById(R.id.idliAdd);
        idliSub = (Button) findViewById(R.id.idliSub);
        idliOrder = (Button) findViewById(R.id.idliOrder);

        Bundle username = getIntent().getExtras();

        String Uname = username.getString("key1","default");

        idliAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                idliNos.setText(String.valueOf(nos));
            }
        });

        idliSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(nos>0){
                    nos -= 1;
                }
                else {
                    nos=0;
                }
                idliNos.setText(String.valueOf(nos));
            }
        });

        idliOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(nos>0)
                {
                    idliStore(nos,Uname);
                    Intent idliOrder = new Intent(IdliVadaActivity.this,MainActivity.class);
                    idliOrder.putExtras(username);
                    startActivity(idliOrder);
                }
                else Toast.makeText(getBaseContext(),"Add item before Ordering!", Toast.LENGTH_LONG).show();
            }
        });

    }
    public void idliStore(int nos, String Uname)
    {
        Map<String, Object> user = new HashMap<>();
        user.put("Idli Nos", nos);

        database.collection("Orders")
                .document(Uname).set(user, SetOptions.merge());
    }
}