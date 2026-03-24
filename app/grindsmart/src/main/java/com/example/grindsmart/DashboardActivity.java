package com.example.grindsmart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DashboardActivity extends AppCompatActivity {

    TextView greetingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.dashboardToolbar);
        setSupportActionBar(toolbar);

        greetingText = findViewById(R.id.greetingText);

        // Get saved name from survey
        SharedPreferences prefs = getSharedPreferences("GrindSmartData", MODE_PRIVATE);
        String name = prefs.getString("userName", "Student");

        // Get today's date
        String todayDate = new SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
                .format(new Date());

        greetingText.setText("Hello " + name + ", Today is " + todayDate);
    }

    // 3-dot menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard_menu, menu);
        return true;
    }

    // Handles menu clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_profile) {
            startActivity(new Intent(this, ProfileActivity.class));
        }

        if (item.getItemId() == R.id.menu_streak) {
            startActivity(new Intent(this, StreakActivity.class));
        }

        if (item.getItemId() == R.id.menu_calendar) {
            startActivity(new Intent(this, CalendarActivity.class));
        }

        if (item.getItemId() == R.id.menu_timer) {
            startActivity(new Intent(this, TimeActivity.class));
        }

        return true;
    }
}