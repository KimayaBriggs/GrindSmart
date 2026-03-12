package com.example.grindsmart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SurveyActivity extends AppCompatActivity {

    Button submitSurvey;

    CheckBox q5_phone, q5_friends, q5_games, q5_noise, q5_thoughts, q5_bored;

    RadioGroup productiveGroup;
    RadioGroup struggleGroup;
    RadioGroup focusGroup;

    EditText hardSubjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        submitSurvey = findViewById(R.id.submitSurvey);

        q5_phone = findViewById(R.id.q5_phone);
        q5_friends = findViewById(R.id.q5_friends);
        q5_games = findViewById(R.id.q5_games);
        q5_noise = findViewById(R.id.q5_noise);
        q5_thoughts = findViewById(R.id.q5_thoughts);
        q5_bored = findViewById(R.id.q5_bored);

        productiveGroup = findViewById(R.id.productiveGroup);
        struggleGroup = findViewById(R.id.struggleGroup);
        focusGroup = findViewById(R.id.focusGroup);

        hardSubjects = findViewById(R.id.hardSubjects);

        submitSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences prefs = getSharedPreferences("GrindSmartData", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.putBoolean("phoneDistraction", q5_phone.isChecked());
                editor.putBoolean("friendsDistraction", q5_friends.isChecked());
                editor.putBoolean("gamesDistraction", q5_games.isChecked());
                editor.putBoolean("noiseDistraction", q5_noise.isChecked());
                editor.putBoolean("thoughtDistraction", q5_thoughts.isChecked());
                editor.putBoolean("boredDistraction", q5_bored.isChecked());

                int productiveID = productiveGroup.getCheckedRadioButtonId();
                int struggleID = struggleGroup.getCheckedRadioButtonId();
                int focusID = focusGroup.getCheckedRadioButtonId();

                editor.putInt("productiveTime", productiveID);
                editor.putInt("studyStruggle", struggleID);
                editor.putInt("focusLength", focusID);

                editor.putString("hardSubjects", hardSubjects.getText().toString());

                editor.apply();

                Toast.makeText(SurveyActivity.this, "Survey Saved!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SurveyActivity.this, DashboardActivity.class);
                startActivity(intent);

            }
        });

    }
}