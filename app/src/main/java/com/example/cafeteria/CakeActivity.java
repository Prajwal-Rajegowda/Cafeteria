package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CakeActivity extends AppCompatActivity {

    EditText cakeNos;
    Button cakeAdd,cakeSub,cakeOrder;

    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);

        cakeNos = (EditText) findViewById(R.id.cakeNos);
        cakeAdd = (Button) findViewById(R.id.cakeAdd);
        cakeSub = (Button) findViewById(R.id.cakeSub);
        cakeOrder = (Button) findViewById(R.id.cakeOrder);

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
                Intent cakeOrder = new Intent(CakeActivity.this,MainActivity.class);
                startActivity(cakeOrder);
            }
        });

    }
}