package com.cis218.dennis.simplecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ConversionActivity extends BaseActivity {

    String resultStr = "";
    EditText edtConversionResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        edtConversionResult = findViewById( R.id.edtConversionResult);

        // Get the Intent data
        Intent intent = getIntent();
        resultStr = intent.getStringExtra("RESULT");
        Log.i("CALC", "ResultStr: " + resultStr);
        edtConversionResult.setText( resultStr );

        ToastIt(getString(R.string.toastRunningOnCreate));

    }

    public void btnCalc(View v){
        // Switch to other activity calc
        // INTENT - intention to do something.

        // Intent says where you're coming from and where you want to go
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);


    }
}
