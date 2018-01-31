package com.cis218.dennis.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.util.Log;

public class Calculator extends AppCompatActivity {

    Button btnPlus, btnMin, btnMult, btnDiv, btnBack;
    EditText edtResult;
    int pendingOperation = 0;
    double firstNumber, secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        edtResult = (EditText)findViewById( R.id.edtResult );
        btnPlus = (Button)findViewById( R.id.btnPlus );
        btnMin = (Button)findViewById( R.id.btnMin );
        btnMult = (Button)findViewById( R.id.btnMult );
        btnDiv = (Button)findViewById( R.id.btnDiv );
        btnBack = (Button)findViewById( R.id.btnBack );

    }

    public void btnOperationOnClick(View v){
        // Check if pendingOperation is still 0?
        // if so, store ~v.getId as pending operation
        // If not, perform pending operation as (firstNumber)(pendingOperation)(secondNumber)
        // Then store resultant as first number, and currentOperation as pending operation
        // update editText
    }

    public void btnNumberOnClick(View v){
        String newNumber = ( (Button)v ).getText().toString();
        String currentNumber = edtResult.getText().toString();
        edtResult.setText(currentNumber + newNumber);
    }

    public void btnBackOnClick(View v){
        String currentNumber = edtResult.getText().toString();
        if(currentNumber.length() > 0){
            int end = currentNumber.length() - 1;
            edtResult.setText(currentNumber.substring(0, end));
        }
    }

    public void btnClearOnClick(View v){
        edtResult.setText("");
    }
}
