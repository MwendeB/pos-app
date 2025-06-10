package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShoppingList extends AppCompatActivity {
    Button breadBtn,milkBtn,sugarBtn,tissueBtn,clearBtn,back;
    TextView breadTotal,milkTotal,sugarTotal,tissueTotal,grandTotal,breadEdit,milkEdit,sugarEdit,tissueEdit;
    int breadPrice = 60;
    int milkPrice = 80;
    int tissuePrice = 40;
    int sugarPrice = 120;
    int bQuantity,mQuantity,tQuantity,sQuantity,gTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shopping_list);
        breadBtn = findViewById(R.id.breadBtn);
        milkBtn=findViewById(R.id.milkBtn);
        sugarBtn=findViewById(R.id.sugarBtn);
        tissueBtn=findViewById(R.id.tissueBtn);
        breadTotal=findViewById(R.id.breadTotalQuantity);
        milkTotal=findViewById(R.id.milkTotalQuantity);
        sugarTotal=findViewById(R.id.sugarTotalQuantity);
        tissueTotal=findViewById(R.id.TotaltissueQuantity);
        grandTotal=findViewById(R.id.GrandTotalAmount);
        milkEdit=findViewById(R.id.milkQuantity);
        sugarEdit=findViewById(R.id.sugarQuantity);
        breadEdit=findViewById(R.id.breadQuantity);
        tissueEdit=findViewById(R.id.tissueQuantity);
        back=findViewById(R.id.back);
        clearBtn=findViewById(R.id.clear);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
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
            sugarTotal.setText("0");
            tissueTotal.setText("0");
            breadEdit.setText("0");
            milkEdit.setText("0");
            sugarEdit.setText("0");
            tissueEdit.setText("0");
            grandTotal.setText("0");
        });
        breadBtn.setOnClickListener(v -> {
            bQuantity++;
            int previousValue = Integer.parseInt(breadTotal.getText().toString());
            breadEdit.setText(String.valueOf(bQuantity));
            int bTotal = bQuantity * breadPrice;
            breadTotal.setText(String.valueOf(bTotal));
            gTotal = gTotal - previousValue;
            gTotal = gTotal + bTotal;
            grandTotal.setText(String.valueOf(gTotal));
        });
        milkBtn.setOnClickListener(v -> {
            mQuantity++;
            int previousValue = Integer.parseInt(milkTotal.getText().toString());
            milkEdit.setText(String.valueOf(mQuantity));
            int mTotal = mQuantity * milkPrice;
            milkTotal.setText(String.valueOf(mTotal));
            gTotal = gTotal - previousValue;
            gTotal = gTotal + mTotal;
            grandTotal.setText(String.valueOf(gTotal));
        });
        sugarBtn.setOnClickListener(v -> {
            sQuantity++;
            int previousValue = Integer.parseInt(sugarTotal.getText().toString());
            sugarEdit.setText(String.valueOf(sQuantity));
            int sTotal = sQuantity * sugarPrice;
            sugarTotal.setText(String.valueOf(sTotal));
            gTotal = gTotal - previousValue;
            gTotal = gTotal + sTotal;
            grandTotal.setText(String.valueOf(gTotal));
        });
        tissueBtn.setOnClickListener(v -> {
            tQuantity++;
            int previousValue = Integer.parseInt(tissueTotal.getText().toString());
            tissueEdit.setText(String.valueOf(tQuantity));
            int tTotal = tQuantity * tissuePrice;
            tissueTotal.setText(String.valueOf(tTotal));
            gTotal = gTotal - previousValue;
            gTotal = gTotal + tTotal;
            grandTotal.setText(String.valueOf(gTotal));
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