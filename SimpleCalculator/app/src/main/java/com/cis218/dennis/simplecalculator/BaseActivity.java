package com.cis218.dennis.simplecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_base );
        // Get Toolbar
        toolbar = findViewById( R.id.toolbar );
        toolbar.setTitle("Calculator");
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ){
        getMenuInflater().inflate( R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ){
        Intent intent;

        switch (item.getItemId()){
            case R.id.menuConversion:
                intent = new Intent( getApplicationContext(), ConversionActivity.class);
                intent.putExtra("RESULT", Calculator.edtResult.getText().toString());
                startActivity(intent);
                break;

            case R.id.menuCalculate:
                intent = new Intent( getApplicationContext(), Calculator.class);
                startActivity(intent);
                break;

            case R.id.menuHistory:
                intent = new Intent( getApplicationContext(), HistoryActivity.class);
                startActivity(intent);
                break;

            default:
                return true;
        }

        return true;
    }

    public void ToastIt( String message ){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
