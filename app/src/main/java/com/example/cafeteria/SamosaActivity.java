package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SamosaActivity extends AppCompatActivity {

    EditText samosaNos;
    Button samosaAdd,samosaSub,samosaOrder;

    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samosa);

        samosaNos = (EditText) findViewById(R.id.samosaNos);
        samosaAdd = (Button) findViewById(R.id.samosaAdd);
        samosaSub = (Button) findViewById(R.id.samosaSub);
        samosaOrder = (Button) findViewById(R.id.samosaOrder);

        samosaAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos+=1;
                samosaNos.setText(String.valueOf(nos));
            }
        });

        samosaSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nos-=1;
                samosaNos.setText(String.valueOf(nos));
            }
        });

        samosaOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent samosaOrder = new Intent(SamosaActivity.this,MainActivity.class);
                startActivity(samosaOrder);
            }
        });

    }
}