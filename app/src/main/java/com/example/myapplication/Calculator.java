package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculator extends AppCompatActivity {
 Button addButton,back;
 EditText editTextX,editTextY;
 TextView sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        addButton = findViewById(R.id.addBtn);
        editTextX = findViewById(R.id.x);
        editTextY = findViewById(R.id.y);
        sum = findViewById(R.id.Sum);
        back=findViewById(R.id.back);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
editTextY.setInputType(InputType.TYPE_CLASS_NUMBER);
editTextX.setInputType(InputType.TYPE_CLASS_NUMBER);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextX.getText().toString().isEmpty() || editTextY.getText().toString().isEmpty()){
                    return;
                }
                int x = Integer.parseInt(editTextX.getText().toString());
                int y = Integer.parseInt(editTextY.getText().toString());
                int sumInt = x + y;
                sum.setText(String.valueOf(sumInt));
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}