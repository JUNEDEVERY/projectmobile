package com.example.mobilesdk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView firstNumber;
    TextView secondNumber;
    TextView result;


    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button plus;
    Button minus;
    Button multiply;
    Button devide;
    Button clear;
    Button equals;

    float resulting;
    String press;
    boolean fnum;
   //Spinner spinner;
    TextView[] countries = {result, result, result, result};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        press = "";
        fnum = true;


        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        result = findViewById(R.id.result);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        devide = findViewById(R.id.devide);
        equals = findViewById(R.id.equals);
        clear = findViewById(R.id.clear);


        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        devide.setOnClickListener(this);
        clear.setOnClickListener(this);
        equals.setOnClickListener(this);
        multiply.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                Button button = (Button) view;
                String numText;
                if (fnum) {
                    numText = firstNumber.getText().toString();
                    numText += button.getText().toString();
                    firstNumber.setText(numText);
                } else {
                    numText = secondNumber.getText().toString();
                    numText += button.getText().toString();
                    secondNumber.setText(numText);
                }
                break;
            case R.id.plus:
            case R.id.minus:
            case R.id.multiply:
            case R.id.devide:
                Button buttonthefirst = (Button) view;
                press = buttonthefirst.getText().toString();
                if (press == buttonthefirst.getText().toString()) {
                    fnum = !fnum;
                } else {
                    fnum = !fnum;
                    press = buttonthefirst.getText().toString();
                }
                break;
            case R.id.equals:
                float number1 = Float.valueOf(firstNumber.getText().toString());
                float number2 = Float.valueOf(secondNumber.getText().toString());
                switch (press) {
                    case ("+"):
                        resulting = number1 + number2;
                        result.setText(String.valueOf(resulting));
                        break;
                    case ("-"):
                        resulting = number1 - number2;
                        result.setText(String.valueOf(resulting));
                        break;
                    case ("x"):
                        resulting = number1 * number2;
                        result.setText(String.valueOf(resulting));
                        break;
                    case ("/"):
                        resulting = number1 / number2;
                        result.setText(String.valueOf(resulting));
                        break;
                }
                break;
            case R.id.clear:
                firstNumber.setText("");
                secondNumber.setText("");
                fnum = true;
                result.setText("");
                break;
            case R.id.secondWindows:
                Intent intent = new Intent(MainActivity.this, Math_page.class);
                startActivity(intent);
                break;
        }
    }
}