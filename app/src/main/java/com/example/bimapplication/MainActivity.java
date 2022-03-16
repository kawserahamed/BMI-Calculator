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
    float rawWeight;
    float sum;
    String BMI;
    float sumFit, totalMeter;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spFt = binding.spinnerFit.getSelectedItem().toString();

        spKg = binding.kg.getSelectedItem().toString();


        if (spKg.equals("lbs")) {
            binding.nweightId.setVisibility(View.GONE);
            binding.lbsId.setVisibility(View.VISIBLE);
            weightCK = true;
        } else {
            binding.nweightId.setVisibility(View.VISIBLE);
            binding.lbsId.setVisibility(View.GONE);
            weightCK = true;
        }

        binding.spinnerFit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 1) {
                    binding.textInputLayout.setVisibility(View.GONE);
                    binding.textInputLayout3.setVisibility(View.GONE);
                    binding.textInputLayout2.setVisibility(View.VISIBLE);
                    heightCK = true;

                } else {

                    binding.textInputLayout.setVisibility(View.VISIBLE);
                    binding.textInputLayout3.setVisibility(View.VISIBLE);
                    binding.textInputLayout2.setVisibility(View.GONE);
                    heightCK = false;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });


        binding.button.setOnClickListener(view -> {
            fit = Integer.parseInt(binding.fitId.getText().toString());
            in = Integer.parseInt(binding.in.getText().toString());
            rawWeight = Integer.parseInt(binding.weightId.getText().toString());

            totalMeter = (float) ((fit * 0.3048) + (in * 0.0254));
            sum = rawWeight / (totalMeter * totalMeter);
            BMI = String.valueOf(sum);
            binding.bmiId.setText(BMI);
        });

    }
}