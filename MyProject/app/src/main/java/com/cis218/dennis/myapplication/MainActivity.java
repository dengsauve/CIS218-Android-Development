package com.cis218.dennis.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText edtResult;
    Button btnPlus, btnMinus, btnMult, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById( R.id.btn1 );
        edtResult = (EditText)findViewById( R.id.edtResult );
        btnPlus = (Button)findViewById( R.id.btnPlus );
        btnMinus = (Button)findViewById( R.id.btnMinus );
        btnMult = (Button)findViewById( R.id.btnMult );
        btnDiv = (Button)findViewById( R.id.btnDiv );
    }

    public void btnOperationOnClick(View v){
        int operation = ((Button)v).getId();
        Log.i("CALC", "ButtonID: " + operation);
        Log.i("CALC", "Is Plus: " + ( operation == btnPlus.getId() ));
        Toast.makeText(this, "ButtonID: " + operation, Toast.LENGTH_SHORT).show();
    }

    public void btnNumberOnClick(View v ){
        String newButton = ( (Button) v ).getText().toString();
        String currentResult = edtResult.getText().toString();
        edtResult.setText(currentResult + newButton);
    }
}
