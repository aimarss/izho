package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsWindow extends AppCompatActivity {
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_window);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            type = extras.getString("type");
        }

        BottomNavigationView bottomnavbar = findViewById(R.id.btmnavbar_st);
        bottomnavbar.setSelectedItemId(R.id.settings);
        bottomnavbar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    Intent intent = new Intent(SettingsWindow.this, MainWindow.class);
                    intent.putExtra("type", type);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.mylist:
                    Intent intent1 = new Intent(SettingsWindow.this, MyListWindow.class);
                    intent1.putExtra("type", type);
                    startActivity(intent1);
                    finish();
                    return true;
            }
            return false;
        }
    };
}
