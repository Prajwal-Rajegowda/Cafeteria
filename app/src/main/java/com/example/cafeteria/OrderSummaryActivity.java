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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

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

        coffeeNosOrder.setText("0");
        idliNosOrder.setText("0");
        dosaNosOrder.setText("0");
        paniNosOrder.setText("0");
        samosaNosOrder.setText("0");
        breadNosOrder.setText("0");
        cakeNosOrder.setText("0");

        coffeeOrderCost = findViewById(R.id.coffeeOrderCost);
        idliOrderCost = findViewById(R.id.idliOrderCost);
        dosaOrderCost = findViewById(R.id.dosaOrderCost);
        paniOrderCost = findViewById(R.id.paniOrderCost);
        samosaOrderCost = findViewById(R.id.samosaOrderCost);
        breadOrderCost = findViewById(R.id.breadOrderCost);
        cakeOrderCost = findViewById(R.id.cakeOrderCost);

        coffeeOrderCost.setText("0");
        idliOrderCost.setText("0");
        dosaOrderCost.setText("0");
        paniOrderCost.setText("0");
        samosaOrderCost.setText("0");
        breadOrderCost.setText("0");
        cakeOrderCost.setText("0");


        Bundle username = getIntent().getExtras();
        String Uname = username.getString("key1","default");

        orderTotal = findViewById(R.id.orderTotal);

        DocumentReference docRef = database.collection("Orders").document(Uname);

        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null) {
                        int totalCost = 0;
                        try {
                            breadNosOrder.setText(document.get("Bread Pakoda Nos").toString());
                            breadOrderCost.setText(""+ Integer.parseInt(breadNosOrder.getText()+"")*20);
                            totalCost+=Integer.parseInt(breadOrderCost.getText()+"");
                        }
                        catch (Exception e)
                        {
                        }

                        try {
                            cakeNosOrder.setText(document.get("Cake Nos").toString());
                            cakeOrderCost.setText(""+ Integer.parseInt(cakeNosOrder.getText()+"")*20);
                            totalCost+=Integer.parseInt(cakeOrderCost.getText()+"");
                        }
                        catch (Exception e)
                        {
                        }

                        try {
                            coffeeNosOrder.setText(document.get("Coffee Nos").toString());
                            coffeeOrderCost.setText(""+ Integer.parseInt(coffeeNosOrder.getText()+"")*10);
                            totalCost+=Integer.parseInt(coffeeOrderCost.getText()+"");
                        }
                        catch (Exception e)
                        {
                        }

                        try {
                            dosaNosOrder.setText(document.get("Dosa Nos").toString());
                            dosaOrderCost.setText(""+ Integer.parseInt(dosaNosOrder.getText()+"")*40);
                            totalCost+=Integer.parseInt(dosaOrderCost.getText()+"");
                        }
                        catch (Exception e)
                        {
                        }

                        try {
                            idliNosOrder.setText(document.get("Idli Nos").toString());
                            idliOrderCost.setText(""+ Integer.parseInt(idliNosOrder.getText()+"")*20);
                            totalCost+=Integer.parseInt(idliOrderCost.getText()+"");
                        }
                        catch (Exception e)
                        {
                        }

                        try {
                            paniNosOrder.setText(document.get("Pani Puri Nos").toString());
                            paniOrderCost.setText(""+ Integer.parseInt(paniNosOrder.getText()+"")*30);
                            totalCost+=Integer.parseInt(paniOrderCost.getText()+"");
                        }
                        catch (Exception e)
                        {
                        }

                        try {
                            samosaNosOrder.setText(document.get("Samosa Nos").toString());
                            samosaOrderCost.setText(""+ Integer.parseInt(samosaNosOrder.getText()+"")*20);
                            totalCost+=Integer.parseInt(samosaOrderCost.getText()+"");
                        }
                        catch (Exception e)
                        {
                        }

                        orderTotal.setText(totalCost+"");

                    } else {
                        Log.d("LOGGER", "No such document");
                    }
                } else {
                    Log.d("LOGGER", "get failed with ", task.getException());
                }
            }
        });

        placeOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (Integer.parseInt((orderTotal.getText()+"")) != 0) {
                    Toast.makeText(getBaseContext(), "Order is placed .. !!", Toast.LENGTH_LONG).show();
                    Intent mainpageIntent = new Intent(OrderSummaryActivity.this,MainActivity.class);
                    database.collection("Orders").document(Uname).delete();
                    Toast.makeText(getBaseContext(), "Order is Delivered .. !!", Toast.LENGTH_LONG).show();
                    mainpageIntent.putExtras(username);
                    startActivity(mainpageIntent);
                }
                else
                    Toast.makeText(getBaseContext(),"Please order something first ...!!",Toast.LENGTH_LONG).show();
            }
        });

    }
}