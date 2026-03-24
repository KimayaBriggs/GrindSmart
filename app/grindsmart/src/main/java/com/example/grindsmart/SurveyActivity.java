package com.example.grindsmart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SurveyActivity extends AppCompatActivity {

    Spinner focusSpinner;
    Button submitSurvey;
    EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        focusSpinner = findViewById(R.id.focusSpinner);
        submitSurvey = findViewById(R.id.submitSurvey);
        nameInput = findViewById(R.id.nameInput);



        String[] focusOptions = {
                "10-15 minutes",
                "20-30 minutes",
                "45-60 minutes",
                "Over an hour"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                focusOptions
        );

        focusSpinner.setAdapter(adapter);



        submitSurvey.setOnClickListener(v -> {

            SharedPreferences prefs = getSharedPreferences("GrindSmartData", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            editor.putString("focusTime", focusSpinner.getSelectedItem().toString());

            String name = nameInput.getText().toString();
            editor.putString("userName", name);

            editor.apply();

            Intent intent = new Intent(SurveyActivity.this, DashboardActivity.class);
            startActivity(intent);
        });
    }
}