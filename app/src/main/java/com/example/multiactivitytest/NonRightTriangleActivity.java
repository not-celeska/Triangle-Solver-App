package com.example.multiactivitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NonRightTriangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_right_triangle);
    }

    public void closeActivity()
    {
        finish();
    }
}