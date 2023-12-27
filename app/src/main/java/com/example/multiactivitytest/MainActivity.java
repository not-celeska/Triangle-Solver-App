package com.example.multiactivitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void homeLayoutButton(View view)
    {
        setContentView(R.layout.activity_main);
    }

    public void rightLayoutButton(View view)
    {
        setContentView(R.layout.right_triangle);
    }

    public void nonrightLayoutButton(View view)
    {
        setContentView(R.layout.non_right_triangle);
    }

}