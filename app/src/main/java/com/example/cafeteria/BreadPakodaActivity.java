package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BreadPakodaActivity extends AppCompatActivity {


    EditText breadNos;
    Button breadAdd,breadSub,breadOrder;

    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread_pakoda);

        breadNos = (EditText) findViewById(R.id.breadNos);
        breadAdd = (Button) findViewById(R.id.breadAdd);
        breadSub = (Button) findViewById(R.id.breadSub);
        breadOrder = (Button) findViewById(R.id.breadOrder);

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
                Intent breadOrder = new Intent(BreadPakodaActivity.this,MainActivity.class);
                startActivity(breadOrder);
            }
        });

    }
}