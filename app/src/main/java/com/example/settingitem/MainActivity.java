package com.example.settingitem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.qbw.settingitem.NumberView;
import com.qbw.settingitem.VerticalSettingItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VerticalSettingItem vis = findViewById(R.id.vsi);
        NumberView numberView = vis.getNumberView();

        numberView.setNumber(10);
    }
}
