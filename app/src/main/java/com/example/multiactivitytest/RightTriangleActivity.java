package com.example.multiactivitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RightTriangleActivity extends AppCompatActivity {

    double sideA, sideB, sideC, angleA, angleB;
    TextView info;
    EditText fieldAngleB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_triangle);

        // initialize views.
        info = findViewById(R.id.inputtedData);
        fieldAngleB = findViewById(R.id.angleB);
    }
// ook
    public void submitData(View view) {
        String inputText = fieldAngleB.getText().toString().trim();

        if (!inputText.isEmpty()) {
            info.setText("Angle B input! --> " + Double.valueOf(inputText));
        } else {
            // Handle the case where nothing is entered
            info.setText("Please enter a value for Angle B.");
        }
    }

    public void closeActivity(View view)
    {
        finish();
    }
}