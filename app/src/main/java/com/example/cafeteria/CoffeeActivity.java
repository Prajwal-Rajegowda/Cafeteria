package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CoffeeActivity extends AppCompatActivity {

    EditText coffeeNos;
    Button coffeeAdd,coffeeSub,coffeeOrder;

    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        coffeeNos = (EditText) findViewById(R.id.coffeeNos);
        coffeeAdd = (Button) findViewById(R.id.coffeeAdd);
        coffeeSub = (Button) findViewById(R.id.coffeeSub);
        coffeeOrder = (Button) findViewById(R.id.coffeeOrder);

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
            {
                nos-=1;
                coffeeNos.setText(String.valueOf(nos));
            }
        });

        coffeeOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent coffeeOrder = new Intent(CoffeeActivity.this,MainActivity.class);
                startActivity(coffeeOrder);
            }
        });

    }
}