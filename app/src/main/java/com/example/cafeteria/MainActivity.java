package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ImageButton dosa,idli,coffee,cake,samosa,bread,pani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        //myRef.setValue("Fuck you and your mom !!");
        myRef.setValue("Hello, World!");
        dosa = (ImageButton) findViewById(R.id.dosaButton);
        idli = (ImageButton) findViewById(R.id.idliButton);
        coffee = (ImageButton) findViewById(R.id.coffeeButton);
        cake = (ImageButton) findViewById(R.id.cakeButton);
        samosa = (ImageButton) findViewById(R.id.samosaButton);
        bread = (ImageButton) findViewById(R.id.breadButton);
        pani = (ImageButton) findViewById(R.id.paniButton);

        dosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dosaAct = new Intent(MainActivity.this,DosaActivity.class);
                startActivity(dosaAct);
            }
        });

        idli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idliAct = new Intent(MainActivity.this,IdliVadaActivity.class);
                startActivity(idliAct);
            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent coffeeAct = new Intent(MainActivity.this,CoffeeActivity.class);
                startActivity(coffeeAct);
            }
        });

        cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cakeAct = new Intent(MainActivity.this,CakeActivity.class);
                startActivity(cakeAct);
            }
        });

        samosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent samosaAct = new Intent(MainActivity.this,SamosaActivity.class);
                startActivity(samosaAct);
            }
        });

        bread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent breadAct = new Intent(MainActivity.this,BreadPakodaActivity.class);
                startActivity(breadAct);
            }
        });

        pani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paniAct = new Intent(MainActivity.this,PaniPuriActivity.class);
                startActivity(paniAct);
            }
        });

    }
}