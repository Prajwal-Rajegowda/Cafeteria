package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DosaActivity extends AppCompatActivity {

    EditText dosaNos;
    Button dosaAdd,dosaSub,dosaOrder;

    int nos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosa);

        dosaNos = (EditText) findViewById(R.id.dosaNos);
        dosaAdd = (Button) findViewById(R.id.dosaAdd);
        dosaSub = (Button) findViewById(R.id.dosaSub);
        dosaOrder = (Button) findViewById(R.id.dosaOrder);

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
                Intent dosaOrder = new Intent(DosaActivity.this,MainActivity.class);
                startActivity(dosaOrder);
            }
        });
    }
}