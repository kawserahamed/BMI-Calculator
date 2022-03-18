package com.example.bimapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bimapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    String spFt;
    String spKg;
    boolean heightCK;
  //  boolean weightCK;

    int fit;
    int in;
    float rawWeight;
    float sum;
    String BMI;
    float totalMeter;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spFt = binding.spinnerFit.getSelectedItem().toString();

        spKg = binding.spinnerKg.getSelectedItem().toString();


        binding.spinnerFit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 1) {
                    binding.heightFtLayout.setVisibility(View.GONE);
                    binding.heightInLayout.setVisibility(View.GONE);
                    binding.heightCmLayout.setVisibility(View.VISIBLE);

                    heightCK = true;

                } else {

                    binding.heightFtLayout.setVisibility(View.VISIBLE);
                    binding.heightInLayout.setVisibility(View.VISIBLE);
                    binding.heightCmLayout.setVisibility(View.GONE);
                    heightCK = false;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });


        binding.bmiButton.setOnClickListener(view -> {
            fit = Integer.parseInt(binding.heightFt.getText().toString());
            in = Integer.parseInt(binding.heightIn.getText().toString());
            rawWeight = Integer.parseInt(binding.weightKg.getText().toString());

            totalMeter = (float) ((fit * 0.3048) + (in * 0.0254));
            sum = rawWeight / (totalMeter * totalMeter);
            BMI = String.valueOf(sum);
            binding.bmi.setText(BMI);
        });

    }
}