package com.example.cal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultView;
    private String currentInput = "";
    private double num1 = Double.NaN;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = findViewById(R.id.result);

        int[] buttonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9, R.id.buttonAdd, R.id.buttonSubtract,
                R.id.buttonMultiply, R.id.buttonDivide, R.id.buttonEquals,
        };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleButtonClick(((Button) v).getText().toString());
                }
            });
        }
    }

    private void handleButtonClick(String value) {
        if (value.matches("[0-9.]")) {
            currentInput += value;
            resultView.setText(currentInput);
        } else if (value.matches("[+\\-x÷]")) {
            if (!currentInput.isEmpty()) {
                num1 = Double.parseDouble(currentInput);
                operator = value;
                currentInput = "";
            }
        } else if (value.equals("=")) {
            if (!currentInput.isEmpty() && !Double.isNaN(num1) && !operator.isEmpty()) {
                double num2 = Double.parseDouble(currentInput);
                double result = performOperation(num1, num2, operator);
                resultView.setText(String.valueOf(result));
                currentInput = String.valueOf(result);
                num1 = Double.NaN;
                operator = "";
            }
        } else if (value.equals("C")) {
            currentInput = "";
            num1 = Double.NaN;
            operator = "";
            resultView.setText("");
        }
    }

    private double performOperation(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "x":
                return num1 * num2;
            case "÷":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return Double.NaN; // Handle division by zero
                }
        }
        return Double.NaN; // If operator is invalid
    }
}
