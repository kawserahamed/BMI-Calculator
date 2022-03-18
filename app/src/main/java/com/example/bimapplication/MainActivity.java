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
    boolean weightCK;

    int fit;
    int in;
    float heightCm;
    float weightLbs;
    float weightKg;
    float sum;
    String BMI;
    float totalMeter;
    float totalWeight;

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

        binding.spinnerKg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if (i == 1) {

                    binding.weightKgLayout.setVisibility(View.GONE);
                    binding.weightLbsLayout.setVisibility(View.VISIBLE);
                    weightCK = true;

                } else {

                    binding.weightKgLayout.setVisibility(View.VISIBLE);
                    binding.weightLbsLayout.setVisibility(View.GONE);
                    weightCK = false;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        binding.bmiButton.setOnClickListener(view -> {

            // for height CM and Weight KG     And Height Ft and Weight KG

            if (heightCK == true) {

                //height cm initialization

                heightCm = Float.parseFloat(binding.heightCm.getText().toString());
                totalMeter = (float) (heightCm * 0.01);


            } else {
                fit = Integer.parseInt(binding.heightFt.getText().toString());
                in = Integer.parseInt(binding.heightIn.getText().toString());

                totalMeter = (float) ((fit * 0.3048) + (in * 0.0254));
            }


            if (weightCK == true) {

                weightLbs = Float.parseFloat(binding.weightLbs.getText().toString());
                totalWeight = (float) (weightLbs / 2.20462);

            } else {

                weightKg = Integer.parseInt(binding.weightKg.getText().toString());
                totalWeight = weightKg;

            }


            sum = totalWeight / (totalMeter * totalMeter);
            BMI = String.valueOf(sum);


            binding.bmi.setText(BMI);

            if (Float.parseFloat(BMI) < 16.0) {
                binding.comment.setText("Very Severely underweight");

            } else if (Float.parseFloat(BMI) > 16.0 && Float.parseFloat(BMI) < 16.9) {
                binding.comment.setText("Severely underweight");

            } else if (Float.parseFloat(BMI) > 17.0 && Float.parseFloat(BMI) < 18.4) {
                binding.comment.setText("Underweight");

            } else if (Float.parseFloat(BMI) > 18.5 && Float.parseFloat(BMI) < 24.9) {
                binding.comment.setText("Healthy");

            } else if (Float.parseFloat(BMI) > 25.0 && Float.parseFloat(BMI) < 29.9) {
                binding.comment.setText("Overweight");

            } else if (Float.parseFloat(BMI) > 30.0 && Float.parseFloat(BMI) < 34.9) {
                binding.comment.setText("Obese Class I");

            } else if (Float.parseFloat(BMI) > 35.0 && Float.parseFloat(BMI) < 39.9) {
                binding.comment.setText("Obese Class II");

            } else if (Float.parseFloat(BMI) >= 40.0) {
                binding.comment.setText("Obese Class III");
            }

        });

    }
}