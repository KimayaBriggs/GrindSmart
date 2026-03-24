package com.example.grindsmart;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimeActivity extends AppCompatActivity {

    TextView timeText;
    Button startButton;

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        timeText = findViewById(R.id.timeText);
        startButton = findViewById(R.id.startTimer);

        startButton.setOnClickListener(v -> startTimer());
    }

    private void startTimer() {

        timer = new CountDownTimer(1500000, 1000) { // 25 minutes

            public void onTick(long millisUntilFinished) {
                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;

                timerText.setText(minutes + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                timerText.setText("Done!");
            }

        }.start();
    }
}