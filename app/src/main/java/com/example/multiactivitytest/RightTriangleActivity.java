package com.example.multiactivitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class RightTriangleActivity extends AppCompatActivity {

    // == DATA SHOWN =====
    TextView info;

    // == ANGLES =====================
    EditText fieldAngleA, fieldAngleB;
    EditText[] angleFields = new EditText[2];
    int ANGLE_A = 0; int ANGLE_B = 1;
    double angles[] = {0, 0, 90}; // Angles [a, b, c]


    // == SIDE LENGTHS =========================
    EditText fieldSideA, fieldSideB, fieldSideC;
    int SIDE_A = 0; int SIDE_B = 1; int SIDE_C = 2;
    EditText[] sideFields = new EditText[3];
    double[] sides = new double[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_triangle);

        // Info feedback text area.
        info = findViewById(R.id.inputtedData);

        // Initialize Angle Fields.
        fieldAngleA = findViewById(R.id.angleA);
        fieldAngleB = findViewById(R.id.angleB);
        angleFields[ANGLE_A] = fieldAngleA;
        angleFields[ANGLE_B] = fieldAngleB;

        // Initialize Side Fields.
        fieldSideA = findViewById(R.id.sideA);
        fieldSideB = findViewById(R.id.sideB);
        fieldSideC = findViewById(R.id.sideC);
        sideFields[SIDE_A] = fieldSideA;
        sideFields[SIDE_B] = fieldSideB;
        sideFields[SIDE_C] = fieldSideC;

    }

    public void submitData(View view) {

        // == REGISTER [LOG] INPUT ======
        registerInput();

        // == CHECK IF NOTHING WAS ENTERED =====
        if (Arrays.equals(sides, new double[] {0.0, 0.0, 0.0}) && Arrays.equals(angles, new double[] {0.0, 0.0, 90.0})) {
            info.setText("YOU DID NOT ENTER ANYTHING!");
        }
        else
        {
            if (isValidInput()) {

            }
            else {
                // conduct checks
                info.setText("SIDES: " + Arrays.toString(sides) + "\nANGLES: " + Arrays.toString(angles));
            }
        }
    }


    public void registerInput() {
        // == REGISTER ANGLES =====

        for (int angleField = 0; angleField < angleFields.length; angleField++) {

            String angle = angleFields[angleField].getText().toString().trim();

            if (!angle.isEmpty()) {

                angles[angleField] = Double.parseDouble(angle);
            }
            else // if there was nothing entered.
            {
                angles[angleField] = 0.0;
            }
        }

        // == REGISTER SIDES =====

        for (int sideField = 0; sideField < sideFields.length; sideField++) {

            String side = sideFields[sideField].getText().toString().trim();

            if (!side.isEmpty()) {
                sides[sideField] = Double.parseDouble(side);
            }
            else // if there was nothing entered.
            {
                sides[sideField] = 0.0;
            }
        }
    }


    public boolean isValidInput() {

        // == ANGLES =============================================
        if (angles[ANGLE_A] >= 90.0 || angles[ANGLE_B] >= 90.0)
        {
            info.setText("ANGLES OTHER THAN C CANNOT BE 90 DEGREES!");
            return false;
        }
        else if (angles[ANGLE_A] + angles[ANGLE_B] > 90)
        {
            info.setText("THE SUM OF ANGLES A AND B CANNOT BE GREATER THAN TO 90!");
            return false;
        }

        // == SIDES =====
        if (sides[SIDE_C] != 0.0) // Side C has been entered.
        {
            for (int side = 0; side < (sides.length - 1); side++)
            {
                if (sides[side] >= sides[SIDE_C])
                {
                    info.setText("SIDE C MUST BE THE LONGEST!");
                    return false;
                }
            }
        }

        return true;
    }

    public void closeActivity(View view)
    {
        finish();
    }
}