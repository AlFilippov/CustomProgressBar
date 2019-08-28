package com.alfilippov.customprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.alfilippov.customprogressbar.style.Circle;

public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgressBar;
    private Circle mCircleDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCircleDraw = new Circle();
        mCircleDraw.setBounds(0, 0, 200, 200);
        mCircleDraw.setColor(Color.BLACK);


    }
}
