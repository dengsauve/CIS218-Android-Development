package com.cis218.dennis.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText edtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById( R.id.btn1 );
        edtResult = (EditText)findViewById( R.id.edtResult );
    }

    public void btnOnClick( View v ){
        String currentResult = edtResult.getText().toString();
        edtResult.setText(currentResult + "1");
    }
}
