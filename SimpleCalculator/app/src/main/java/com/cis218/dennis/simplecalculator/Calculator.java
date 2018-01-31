package com.cis218.dennis.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.util.Log;

public class Calculator extends AppCompatActivity {

    Button btnPlus, btnMin, btnMult, btnDiv;
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

    }

    public void btnOperationOnClick(View v){
        int operation = ( (Button)v ).getId();
        Log.i("CALC", "Button ID: " + operation);

        boolean notEquals = operation != R.id.btnEquals;
        Log.i("CALC", "Is notEquals: " + notEquals);

        if(pendingOperation == 0){
            // store operation
            pendingOperation = operation;
            // store current number as first number
            firstNumber = Double.parseDouble(edtResult.getText().toString());
            // clear text box
            edtResult.setText("");
        }
        else{
            // capture and store the secondNumber
            secondNumber = Double.parseDouble(edtResult.getText().toString());
            switch(pendingOperation){
                case R.id.btnPlus:
                    Log.i("CALC", "Addition operation reached");

                    // perform addition logic + store result
                    firstNumber += secondNumber;
                    // update display with result
                    edtResult.setText(Double.toString(firstNumber));
                    break;

                case R.id.btnMin:
                    Log.i("CALC", "Subtraction operation reached");
                    // perform addition logic + store result
                    firstNumber = firstNumber - secondNumber;
                    // update display with result
                    edtResult.setText(Double.toString(firstNumber));
                    break;

                case R.id.btnMult:
                    Log.i("CALC", "Multiplication operation reached");

                    // perform addition logic + store result
                    firstNumber = firstNumber * secondNumber;
                    // update display with result
                    edtResult.setText(Double.toString(firstNumber));
                    break;

                case R.id.btnDiv:
                    Log.i("CALC", "Division Operation Reached");
                    // perform addition logic + store result
                    firstNumber = firstNumber / secondNumber;
                    // update display with result
                    edtResult.setText(Double.toString(firstNumber));
                    break;
            }
        }

        // store operation
        if (notEquals) {
            pendingOperation = operation;
            edtResult.setText("");
            Toast.makeText(this, "Result: " + Double.toString(firstNumber), Toast.LENGTH_SHORT).show();
        }
        else
        {
            pendingOperation = 0;
        }
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
        firstNumber = 0;
        secondNumber = 0;
        pendingOperation = 0;
    }
}
