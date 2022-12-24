package com.example.calculator.converter.switchesanddialog.datatransactivity.orlovalexandr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    CheckBox chb1, chb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.editText);

        chb1 = findViewById(R.id.chb1);
        chb2 = findViewById(R.id.chb2);
    }

    @Override
    protected void onActivityResult (int requestCode,
                                     int resultCode,
                                     Intent data)
    {
        if (requestCode == 123)
        {
            if (data != null)
            {
                String str = data.getStringExtra("etText");
                chb1.setChecked(data.getBooleanExtra("bool1", true));
                chb2.setChecked(data.getBooleanExtra("bool2", true));
                et.setText(str);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void OpenDlgWindow(View v)
    {
        AlertDialog.Builder bld = new AlertDialog.Builder(this);

        final EditText etDlg = new EditText(this);

        bld.setView(etDlg);
        bld.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dlg, int x)
            {
                dlg.cancel();
            }
        });
           bld.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dlg, int x)
            {
                String str = etDlg.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                et.setText(str);
            }
        });
        bld.show();
    }

    public void OpenDlg(View v)
    {
        String str = et.getText().toString();
        Boolean ch1 = chb1.isChecked();
        Boolean ch2 = chb2.isChecked();

        Intent i = new Intent(this, DataTransActivity2.class);
        i.putExtra("etText", str);
        i.putExtra("bool1", ch1);
        i.putExtra("bool2", ch2);


        startActivityForResult(i, 123);
    }

    public void CloseApp(View v)
    {
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        bld.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) { }
        });
        bld.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                finish();
            }
        });
        AlertDialog dlg = bld.create();
        dlg.setIcon(R.drawable.icon);
        dlg.setTitle("Close app");
        dlg.setMessage("Are you sure?");
        dlg.show();
    }
}