package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    ImageButton dosa,idli,coffee,cake,samosa,bread,pani, orderSummary;
    EditText unameDisp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseFirestore database = FirebaseFirestore.getInstance();

        Bundle username = getIntent().getExtras();

        String Uname = username.getString("key1","default");

        dosa = (ImageButton) findViewById(R.id.dosaButton);
        idli = (ImageButton) findViewById(R.id.idliButton);
        coffee = (ImageButton) findViewById(R.id.coffeeButton);
        cake = (ImageButton) findViewById(R.id.cakeButton);
        samosa = (ImageButton) findViewById(R.id.samosaButton);
        bread = (ImageButton) findViewById(R.id.breadButton);
        pani = (ImageButton) findViewById(R.id.paniButton);
        orderSummary = findViewById(R.id.orderSummary);

        unameDisp = findViewById(R.id.unameDisp);

        unameDisp.setText(Uname);

        dosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dosaAct = new Intent(MainActivity.this,DosaActivity.class);
                dosaAct.putExtras(username);
                startActivity(dosaAct);
            }
        });

        idli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idliAct = new Intent(MainActivity.this,IdliVadaActivity.class);
                idliAct.putExtras(username);
                startActivity(idliAct);
            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent coffeeAct = new Intent(MainActivity.this,CoffeeActivity.class);
                coffeeAct.putExtras(username);
                startActivity(coffeeAct);
            }
        });

        cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cakeAct = new Intent(MainActivity.this,CakeActivity.class);
                cakeAct.putExtras(username);
                startActivity(cakeAct);
            }
        });

        samosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent samosaAct = new Intent(MainActivity.this,SamosaActivity.class);
                samosaAct.putExtras(username);
                startActivity(samosaAct);
            }
        });

        bread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent breadAct = new Intent(MainActivity.this,BreadPakodaActivity.class);
                breadAct.putExtras(username);
                startActivity(breadAct);
            }
        });

        pani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paniAct = new Intent(MainActivity.this,PaniPuriActivity.class);
                paniAct.putExtras(username);
                startActivity(paniAct);
            }
        });

        orderSummary.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent orderPgAct = new Intent(MainActivity.this,OrderSummaryActivity.class);
                orderPgAct.putExtras(username);
                startActivity(orderPgAct);
            }
        });
    }
}