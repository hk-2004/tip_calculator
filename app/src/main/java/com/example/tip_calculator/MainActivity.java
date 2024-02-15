package com.example.tip_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextBillAmount;
    private TextView textViewTipTotal;
    private Button buttonFifteen, buttonEighteen, buttonTwenty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBillAmount = findViewById(R.id.editTextBillAmount);
        textViewTipTotal = findViewById(R.id.textViewTipTotal);
        buttonFifteen = findViewById(R.id.buttonFifteen);
        buttonEighteen = findViewById(R.id.buttonEighteen);
        buttonTwenty = findViewById(R.id.buttonTwenty);

        buttonFifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTip(0.15);
            }
        });

        buttonEighteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTip(0.18);
            }
        });

        buttonTwenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTip(0.20);
            }
        });
    }

    private void calculateTip(double percentage) {
        if (!editTextBillAmount.getText().toString().equals("")) {
            double billAmount = Double.parseDouble(editTextBillAmount.getText().toString());
            double tip = billAmount * percentage;
            double totalBill = billAmount + tip;
            DecimalFormat formatter = new DecimalFormat("#,##0.00");
            textViewTipTotal.setText("Tip: $" + formatter.format(tip) + ", Total Bill: $" + formatter.format(totalBill));
        } else {
            textViewTipTotal.setText("Enter a bill amount.");
        }
    }
}

