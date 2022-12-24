package com.example.calculator.converter.switchesanddialog.datatransactivity.orlovalexandr;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class DataTransActivity2 extends AppCompatActivity {

    EditText et;

    Switch switch1, switch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_trans2);

        et = findViewById(R.id.editText);

        switch1 = findViewById(R.id.sw1);
        switch2 = findViewById(R.id.sw2);

        Intent i = getIntent();

        String str = i.getStringExtra("etText");

        switch1.setChecked(i.getBooleanExtra("bool1", false));
        switch2.setChecked(i.getBooleanExtra("bool2", false));


        et.setText(str);
    }

    public void OK(View v)
    {
        Intent i = new Intent();

        String str = et.getText().toString();
        Boolean sw1 = switch1.isChecked();
        Boolean sw2 = switch2.isChecked();

        i.putExtra("etText", str);
        i.putExtra("bool1", sw1);
        i.putExtra("bool2", sw2);

        setResult(RESULT_OK, i);
        finish();
    }

    public void Cancel(View v)
    {
        setResult(RESULT_CANCELED);
        finish();
    }
}