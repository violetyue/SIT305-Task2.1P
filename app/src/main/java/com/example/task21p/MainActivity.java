package com.example.task21p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputValue;
    TextView firstResult;
    TextView secondResult;
    TextView thirdResult;
    TextView firstUnit;
    TextView secondUnit;
    TextView thirdUnit;
    Spinner unitSpinner;
    ImageButton btnLength;
    ImageButton btnWeight;
    ImageButton btnTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputValue = findViewById(R.id.inputValue);
        firstResult = findViewById(R.id.firstResult);
        secondResult = findViewById(R.id.secondResult);
        thirdResult = findViewById(R.id.thirdResult);
        firstUnit = findViewById(R.id.firstUnit);
        secondUnit = findViewById(R.id.secondUnit);
        thirdUnit = findViewById(R.id.thirdUnit);
        btnLength = findViewById(R.id.btnLength);
        btnWeight = findViewById(R.id.btnWeight);
        btnTemperature = findViewById(R.id.btnTemperature);
        btnLength.setOnClickListener(new MyOnClickListener());
        btnWeight.setOnClickListener(new MyOnClickListener());
        btnTemperature.setOnClickListener(new MyOnClickListener());
        unitSpinner = findViewById(R.id.unitSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitArray, android.R.layout.simple_spinner_item);
        unitSpinner.setAdapter(adapter);
        unitSpinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
    }

    public class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            unitSpinner = findViewById(R.id.unitSpinner);
            int choose = unitSpinner.getSelectedItemPosition();
            if (v.getId() == R.id.btnLength) {
                if (choose == 0) {
                    java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
                    double result1 = Double.parseDouble(inputValue.getText().toString()) * 100;
                    String str1 = df.format(result1);
                    firstResult.setText(str1);
                    firstUnit.setText("Centimetre");
                    double result2 = Double.parseDouble(inputValue.getText().toString()) * 3.28;
                    String str2 = df.format(result2);
                    secondResult.setText(str2);
                    secondUnit.setText("Foot");
                    double result3 = Double.parseDouble(inputValue.getText().toString()) * 39.37;
                    String str3 = df.format(result3);
                    thirdResult.setText(str3);
                    thirdUnit.setText("Inch");
                } else {
                    Toast.makeText(MainActivity.this, "Please select the correct conversion icon.",Toast.LENGTH_LONG).show();
                }
            }
            if (v.getId() == R.id.btnWeight) {
                if (choose == 1) {
                    java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
                    double result1 = Double.parseDouble(inputValue.getText().toString()) * 1000;
                    String str1 = df.format(result1);
                    firstResult.setText(str1);
                    firstUnit.setText("Gram");
                    double result2 = Double.parseDouble(inputValue.getText().toString()) * 35.27;
                    String str2 = df.format(result2);
                    secondResult.setText(str2);
                    secondUnit.setText("Ounce(Oz)");
                    double result3 = Double.parseDouble(inputValue.getText().toString()) * 2.2;
                    String str3 = df.format(result3);
                    thirdResult.setText(str3);
                    thirdUnit.setText("Pound(Ib)");
                } else {
                    Toast.makeText(MainActivity.this, "Please select the correct conversion icon.",Toast.LENGTH_LONG).show();
                }
            }
            if (v.getId() == R.id.btnTemperature) {
                if (choose == 2) {
                    java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
                    double result1 = Double.parseDouble(inputValue.getText().toString()) * 33.8;
                    String str1 = df.format(result1);
                    firstResult.setText(str1);
                    firstUnit.setText("Fahrenheit");
                    double result2 = Double.parseDouble(inputValue.getText().toString()) * 274.15;
                    String str2 = df.format(result2);
                    secondResult.setText(str2);
                    secondUnit.setText("Kelvin");
                    thirdResult.setText("");
                    thirdUnit.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Please select the correct conversion icon.",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public class MyOnItemSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


}