package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyListWindow extends AppCompatActivity {
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_window);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            type = extras.getString("type");
        }

        BottomNavigationView bottomnavbar = findViewById(R.id.btmnavbar_ml);
        bottomnavbar.setSelectedItemId(R.id.mylist);
        bottomnavbar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        System.out.println(((MyApplication) getApplication()).getIds());
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    Intent intent = new Intent(MyListWindow.this, MainWindow.class);
                    intent.putExtra("type", type);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.settings:
                    Intent intent1 = new Intent(MyListWindow.this, SettingsWindow.class);
                    intent1.putExtra("type", type);
                    startActivity(intent1);
                    finish();
                    return true;
            }
            return false;
        }
    };
}
