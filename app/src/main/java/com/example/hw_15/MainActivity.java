package com.example.hw_15;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity<pivate> extends AppCompatActivity {

    private TextView textView;
    private double firstVar;
    private double secondVar;
    private boolean isOperationClick;
    private String operation;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void setNumber(String number) {
        if (textView.getText().toString().equals("0")) {
            textView.setText(number);
        } else if (isOperationClick) {
            textView.setText(number);
        } else {
            textView.append(number);
        }
        isOperationClick = false;
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_zero:
                setNumber("0");
                break;
            case R.id.btn_clear:
                textView.setText("0");
                isOperationClick = false;
                firstVar = 0;
                secondVar = 0;
                break;

        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {

        switch (view.getId()) {
            case R.id.btn_plus:

                firstVar = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.btn_minus:
                firstVar = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;
            case R.id.btn_multiply:
                firstVar = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                operation = "X";
                break;
            case R.id.btn_divide:
                firstVar = Double.parseDouble(textView.getText().toString());
                isOperationClick = true;
                operation = "/";
                break;

            case R.id.btn_percent:
                firstVar = Double.parseDouble(textView.getText().toString());
                double result_percent = Double.valueOf(0);
                isOperationClick = true;
                result_percent = firstVar / 100;
                textView.setText(new DecimalFormat("##.#######").format(result_percent));
                break;

            case R.id.btn_value:
                firstVar = Double.parseDouble(textView.getText().toString());
                double result_value = Double.valueOf(0);
                isOperationClick = true;
                result_value = firstVar *= -1;
                textView.setText(new DecimalFormat("##.#######").format(result_value));
                break;

            case R.id.btn_equal:
                double result = 0;
                secondVar = Integer.parseInt(textView.getText().toString());
                switch (operation) {
                    case "+":
                        result = firstVar + secondVar;
                        break;

                    case "-":
                        result = firstVar - secondVar;
                        break;

                    case "X":
                        result = firstVar * secondVar;
                        break;

                    case "/":
                        result = firstVar / secondVar;
                        break;
                }
                textView.setText(new DecimalFormat("##.#######").format(result));
                isOperationClick = true;
                break;
        }
    }
}