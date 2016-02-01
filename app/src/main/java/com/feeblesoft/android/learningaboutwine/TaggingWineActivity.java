package com.feeblesoft.android.learningaboutwine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class TaggingWineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tagging_wine);

    }

    public void checkLabelInput(View view) {

        EditText vintageField = (EditText) findViewById(R.id.vintage_value);
        EditText startDrinkingField = (EditText) findViewById(R.id.drinking_start_value);
        EditText finishDrinkingField = (EditText) findViewById(R.id.drinking_finish_value);
        EditText priceField = (EditText) findViewById(R.id.price_value);

        if (vintageField.length() == 0) {
            vintageField.setError("You cannot leave this field blank!");
        } else if (startDrinkingField.length() == 0) {
            startDrinkingField.setError("You cannot leave this field blank!");
        } else if (finishDrinkingField.length() == 0) {
            finishDrinkingField.setError("You cannot leave this field blank!");
        } else if (priceField.length() == 0) {
            priceField.setError("You cannot leave this field blank!");
        } else {
            validateLabelInput(vintageField, startDrinkingField, finishDrinkingField, priceField);
        }
    }

    private void validateLabelInput(EditText vintageField, EditText startDrinkingField, EditText finishDrinkingField, EditText priceField) {

        TextView labelVintage = (TextView) findViewById(R.id.vintage_label);
        TextView labelCode = (TextView) findViewById(R.id.label_code);
        View label = findViewById(R.id.circular_label);

        String vintageText = vintageField.getText().toString();
        String startDrinkingText = startDrinkingField.getText().toString();
        String finishDrinkingText = finishDrinkingField.getText().toString();
        String priceText = priceField.getText().toString();
        String firstDigit;
        String secondDigit;
        String thirdDigit;

        boolean vintageCheck = true;
        boolean priceCheck = true;
        boolean startDrinkingYearCheck = true;
        boolean finishDrinkingYearCheck = true;

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        int vintageYear = Integer.parseInt(vintageText);
        int priceNum = Integer.parseInt(priceText);
        int startDrinkingYear = Integer.parseInt(startDrinkingText);
        int finishDrinkingYear = Integer.parseInt(finishDrinkingText);

        if (vintageYear > year || vintageYear < 1901) vintageCheck = false;
        if (startDrinkingYear < vintageYear || startDrinkingYear > year + 30)
            startDrinkingYearCheck = false;
        if (finishDrinkingYear < startDrinkingYear || finishDrinkingYear > year + 30)
            finishDrinkingYearCheck = false;
        if (priceNum <= 0) priceCheck = false;

        if (vintageCheck && startDrinkingYearCheck && finishDrinkingYearCheck && priceCheck) {

            String wineVintage = vintageText.substring(2, 4);

            if (priceNum % 10 < 5) {
                firstDigit = String.valueOf(priceNum / 10);
            } else {
                firstDigit = String.valueOf(priceNum / 10 + 1);
            }
            secondDigit = startDrinkingText.substring(3, 4);
            thirdDigit = finishDrinkingText.substring(3, 4);
            if (Integer.parseInt(finishDrinkingText) - Integer.parseInt(startDrinkingText) >= 10) {
                thirdDigit = "+";
            }
            labelVintage.setText(wineVintage);
            labelCode.setText(firstDigit + secondDigit + thirdDigit);
            if (startDrinkingYear > year + 3) {
                label.setBackgroundResource(R.drawable.circle_pink);
            } else if (finishDrinkingYear > year + 5) {
                label.setBackgroundResource(R.drawable.circle_orange);
            } else {
                label.setBackgroundResource(R.drawable.circle_green);
            }

        } else {

            boolean focusSet = false;
            if (!vintageCheck) {
                vintageField.setError("Wine vintage must be a 4-digit year not beyond the current year");
                vintageField.setText("");
                vintageField.setFocusableInTouchMode(true);
                vintageField.requestFocus();
                focusSet = true;
            }

            if (!startDrinkingYearCheck) {
                startDrinkingField.setError("Start of drinking window must be a 4-digit year not before the vintage year");
                startDrinkingField.setText("");
                if (!focusSet) {
                    startDrinkingField.setFocusableInTouchMode(true);
                    startDrinkingField.requestFocus();
                    focusSet = true;
                }

            }

            if (!finishDrinkingYearCheck) {
                finishDrinkingField.setError("End of drinking window must be a 4-digit year not before the start of the drinking window");
                finishDrinkingField.setText("");
                if (!focusSet) {
                    finishDrinkingField.setFocusableInTouchMode(true);
                    finishDrinkingField.requestFocus();
                    focusSet = true;
                }
            }

            if (!priceCheck) {
                priceField.setError("Wine value must be greater than zero");
                priceField.setText("");
                if (!focusSet) {
                    priceField.setFocusableInTouchMode(true);
                    priceField.requestFocus();
                }

            }
        }
    }
}
