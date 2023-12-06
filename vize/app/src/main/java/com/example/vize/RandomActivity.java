package com.example.vize;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    private EditText adet, min, max;
    private LinearLayout linearLayout;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        linearLayout = findViewById(R.id.asd);
        scrollView = findViewById(R.id.scrollView);
    }

    public void Hesapla(View view) {
        try {
            adet = findViewById(R.id.editTextAdet);
            min = findViewById(R.id.editTextMin);
            max = findViewById(R.id.editTextMax);

            int adetValue = Integer.parseInt(adet.getText().toString());
            int minValue = Integer.parseInt(min.getText().toString());
            int maxValue = Integer.parseInt(max.getText().toString());

            linearLayout.removeAllViews();
            for (int i = 0; i < adetValue; i++) {
                int randomValue = getRandomValue(minValue, maxValue);

                ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
                progressBar.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                progressBar.setMax(maxValue - minValue);
                progressBar.setProgress(randomValue - minValue);

                TextView textView = new TextView(this);
                textView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                textView.setGravity(Gravity.CENTER);
                textView.setText(String.format("Değer:%d, Yüzde:%d%%", randomValue,
                        calculatePercentage(minValue, maxValue, randomValue)));

                linearLayout.addView(progressBar);
                linearLayout.addView(textView);
            }

            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getRandomValue(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private int calculatePercentage(int min, int max, int value) {
        return (int) (((float) (value - min) / (max - min)) * 100);
    }
}
