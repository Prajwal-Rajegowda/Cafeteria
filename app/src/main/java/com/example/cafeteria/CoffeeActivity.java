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

public class CoffeeActivity extends AppCompatActivity {

    EditText coffeeNos;
    Button coffeeAdd,coffeeSub,coffeeOrder;
    FirebaseFirestore database = FirebaseFirestore.getInstance();

    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        coffeeNos = (EditText) findViewById(R.id.coffeeNos);
        coffeeAdd = (Button) findViewById(R.id.coffeeAdd);
        coffeeSub = (Button) findViewById(R.id.coffeeSub);
        coffeeOrder = (Button) findViewById(R.id.coffeeOrder);

        Bundle username = getIntent().getExtras();

        String Uname = username.getString("key1","default");

        coffeeAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                coffeeNos.setText(String.valueOf(nos));
            }
        });

        coffeeSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {   if(nos>0){
                nos -= 1;
            }
            else {
                nos=0;
            }
                coffeeNos.setText(String.valueOf(nos));
            }
        });

        coffeeOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(nos>0)
                {
                    coffeeStore(nos,Uname);
                    Intent coffeeOrder = new Intent(CoffeeActivity.this,MainActivity.class);
                    coffeeOrder.putExtras(username);
                    startActivity(coffeeOrder);
                }
                else Toast.makeText(getBaseContext(),"Add item before Ordering!", Toast.LENGTH_LONG).show();
            }
        });

    }
    public void coffeeStore(int nos, String uname)
    {
        Map<String, Object> user = new HashMap<>();
        user.put("Coffee Nos", nos);

        database.collection("Orders")
                .document(uname).set(user, SetOptions.merge());

    }
}