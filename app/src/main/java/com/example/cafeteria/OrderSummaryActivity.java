package com.example.cafeteria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class OrderSummaryActivity extends AppCompatActivity {

    Button placeOrder;
    EditText coffeeNosOrder,idliNosOrder, dosaNosOrder, paniNosOrder, samosaNosOrder, breadNosOrder, cakeNosOrder;
    EditText coffeeOrderCost, idliOrderCost, dosaOrderCost, paniOrderCost, samosaOrderCost, breadOrderCost, cakeOrderCost;
    EditText orderTotal;

    FirebaseFirestore database = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        placeOrder = findViewById(R.id.placeOrder);

        coffeeNosOrder = findViewById(R.id.coffeeNosOrder);
        idliNosOrder = findViewById(R.id.idliNosOrder);
        dosaNosOrder = findViewById(R.id.dosaNosOrder);
        paniNosOrder = findViewById(R.id.paniNosOrder);
        samosaNosOrder = findViewById(R.id.samosaNosOrder);
        breadNosOrder = findViewById(R.id.breadNosOrder);
        cakeNosOrder = findViewById(R.id.cakeNosOrder);

        coffeeOrderCost = findViewById(R.id.coffeeOrderCost);
        idliOrderCost = findViewById(R.id.idliOrderCost);
        dosaOrderCost = findViewById(R.id.dosaOrderCost);
        paniOrderCost = findViewById(R.id.paniOrderCost);
        samosaOrderCost = findViewById(R.id.samosaOrderCost);
        breadOrderCost = findViewById(R.id.breadOrderCost);
        cakeOrderCost = findViewById(R.id.cakeOrderCost);

        orderTotal = findViewById(R.id.orderTotal);


    }
}