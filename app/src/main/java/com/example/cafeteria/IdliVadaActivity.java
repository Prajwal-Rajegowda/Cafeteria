package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IdliVadaActivity extends AppCompatActivity {

    EditText idliNos;
    Button idliAdd,idliSub,idliOrder;

    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idli_vada);

        idliNos = (EditText) findViewById(R.id.idliNos);
        idliAdd = (Button) findViewById(R.id.idliAdd);
        idliSub = (Button) findViewById(R.id.idliSub);
        idliOrder = (Button) findViewById(R.id.idliOrder);

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
                nos-=1;
                idliNos.setText(String.valueOf(nos));
            }
        });

        idliOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent idliOrder = new Intent(IdliVadaActivity.this,MainActivity.class);
                startActivity(idliOrder);
            }
        });

    }
}