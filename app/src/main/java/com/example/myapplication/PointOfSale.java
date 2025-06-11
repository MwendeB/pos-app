package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PointOfSale extends AppCompatActivity {

    Button breadBtn,milkBtn,penBtn,watchBtn,clearBtn,back;
    TextView breadTotal,milkTotal,penTotal,watchTotal,grandTotal,netPayTextView,discountTextView,breadEdit,milkEdit,penEdit,watchEdit;
    int breadPrice = 0;
    int milkPrice = 0;
    int penPrice = 0;
    int watchPrice, netPay= 0;
    double discount = 0;
    EditText milkPriceEdit,watchPriceEdit,breadPriceEdit,penPriceEdit;
    int bQuantity,mQuantity,tQuantity,sQuantity,gTotal = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_point_of_sale);
        breadBtn = findViewById(R.id.breadBtn);
        milkBtn=findViewById(R.id.milkBtn);
        watchBtn=findViewById(R.id.watchBtn);
        netPayTextView=findViewById(R.id.netPay);
        discountTextView=findViewById(R.id.discount);
        penBtn=findViewById(R.id.penBtn);
        breadTotal=findViewById(R.id.breadTotalQuantity);
        milkTotal=findViewById(R.id.milkTotalQuantity);
        penTotal=findViewById(R.id.penTotalQuantity);
        watchTotal=findViewById(R.id.watchTotalQuantity);
        grandTotal=findViewById(R.id.GrandTotalAmount);
        milkEdit=findViewById(R.id.milkQuantity);
        penEdit=findViewById(R.id.penQuantity);
        breadEdit=findViewById(R.id.breadQuantity);
        watchEdit=findViewById(R.id.watchQuantity);
        milkPriceEdit = findViewById(R.id.milkPrice);
        watchPriceEdit = findViewById(R.id.watchPrice);
        breadPriceEdit = findViewById(R.id.breadPrice);
        penPriceEdit = findViewById(R.id.penPrice);
        back=findViewById(R.id.back);
        clearBtn=findViewById(R.id.clear);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        clearBtn.setOnClickListener(v -> {
            bQuantity = 0;
            mQuantity = 0;
            sQuantity = 0;
            tQuantity = 0;
            gTotal = 0;
            breadTotal.setText("0");
            milkTotal.setText("0");
            penTotal.setText("0");
            watchTotal.setText("0");
            breadEdit.setText("0");
            milkEdit.setText("0");
            penEdit.setText("0");
            watchEdit.setText("0");
            grandTotal.setText("0");
        });
        breadBtn.setOnClickListener(v -> {
            bQuantity++;
            breadPrice = Integer.parseInt(breadPriceEdit.getText().toString());
            int previousValue = Integer.parseInt(breadTotal.getText().toString());
            breadEdit.setText(String.valueOf(bQuantity));
            int bTotal = bQuantity * breadPrice;
            breadTotal.setText(String.valueOf(bTotal));
            gTotal = gTotal - previousValue;
            gTotal = gTotal + bTotal;
            grandTotal.setText(String.valueOf(gTotal));
            //calculate discount
            discount = 0.15 * gTotal;
            double discountAmount = gTotal - discount;
            discountTextView.setText(String.valueOf(discount));
            netPayTextView.setText(String.valueOf(discountAmount));
        });
        milkBtn.setOnClickListener(v -> {
            mQuantity++;
            milkPrice = Integer.parseInt(milkPriceEdit.getText().toString());
            int previousValue = Integer.parseInt(milkTotal.getText().toString());
            milkEdit.setText(String.valueOf(mQuantity));
            int mTotal = mQuantity * milkPrice;
            milkTotal.setText(String.valueOf(mTotal));
            gTotal = gTotal - previousValue;
            gTotal = gTotal + mTotal;
            grandTotal.setText(String.valueOf(gTotal));
            //calculate discount
            discount = 0.15 * gTotal;
            double discountAmount = gTotal - discount;
            discountTextView.setText(String.valueOf(discount));
            netPayTextView.setText(String.valueOf(discountAmount));
        });
        penBtn.setOnClickListener(v -> {
            sQuantity++;
            penPrice = Integer.parseInt(penPriceEdit.getText().toString());
            int previousValue = Integer.parseInt(penTotal.getText().toString());
            penEdit.setText(String.valueOf(sQuantity));
            int sTotal = sQuantity * penPrice;
            penTotal.setText(String.valueOf(sTotal));
            gTotal = gTotal - previousValue;
            gTotal = gTotal + sTotal;
            grandTotal.setText(String.valueOf(gTotal));
            //calculate discount
            discount = 0.15 * gTotal;
            double discountAmount = gTotal - discount;
            discountTextView.setText(String.valueOf(discount));
            netPayTextView.setText(String.valueOf(discountAmount));
        });
        watchBtn.setOnClickListener(v -> {
            tQuantity++;
            watchPrice = Integer.parseInt(watchPriceEdit.getText().toString());
            int previousValue = Integer.parseInt(watchTotal.getText().toString());
            watchEdit.setText(String.valueOf(tQuantity));
            int tTotal = tQuantity * watchPrice;
            watchTotal.setText(String.valueOf(tTotal));
            gTotal = gTotal - previousValue;
            gTotal = gTotal + tTotal;
            grandTotal.setText(String.valueOf(gTotal));
            //calculate discount
            discount = 0.15 * gTotal;
            double discountAmount = gTotal - discount;
            discountTextView.setText(String.valueOf(discount));
            netPayTextView.setText(String.valueOf(discountAmount));
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}