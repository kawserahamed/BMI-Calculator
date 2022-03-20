package com.example.bimapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
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

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spFt = binding.spinnerFit.getSelectedItem().toString();

        spKg = binding.spinnerKg.getSelectedItem().toString();

        binding.reset.setOnClickListener(view -> {

            //set All Text Null
            binding.heightCm.setText("");
            binding.heightFt.setText("");
            binding.heightIn.setText("");
            binding.weightKg.setText("");
            binding.weightLbs.setText("");
            binding.bmi.setText("0.00");
            binding.comment.setText("");

            //Chart Background set null
            binding.verySeverelyUnderweight.setBackgroundColor(getResources().getColor(R.color.white));
            binding.severelyUnderweight.setBackgroundColor(getResources().getColor(R.color.white));
            binding.underweight.setBackgroundColor(getResources().getColor(R.color.white));
            binding.healthy.setBackgroundColor(getResources().getColor(R.color.white));
            binding.overweight.setBackgroundColor(getResources().getColor(R.color.white));
            binding.obeseClassI.setBackgroundColor(getResources().getColor(R.color.white));
            binding.obeseClassIi.setBackgroundColor(getResources().getColor(R.color.white));
            binding.obeseClassIii.setBackgroundColor(getResources().getColor(R.color.white));

        });


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


        //Button Clicked
        binding.bmiButton.setOnClickListener(view -> {

            //Chart Background set null
            binding.verySeverelyUnderweight.setBackgroundColor(getResources().getColor(R.color.white));
            binding.severelyUnderweight.setBackgroundColor(getResources().getColor(R.color.white));
            binding.underweight.setBackgroundColor(getResources().getColor(R.color.white));
            binding.healthy.setBackgroundColor(getResources().getColor(R.color.white));
            binding.overweight.setBackgroundColor(getResources().getColor(R.color.white));
            binding.obeseClassI.setBackgroundColor(getResources().getColor(R.color.white));
            binding.obeseClassIi.setBackgroundColor(getResources().getColor(R.color.white));
            binding.obeseClassIii.setBackgroundColor(getResources().getColor(R.color.white));
            binding.bmi.setText("0.00");
            binding.comment.setText("");


            // for height CM and Weight KG     And Height Ft and Weight KG
            if (!heightCK && !weightCK) {


                //height cm initialization
                if (TextUtils.isEmpty(binding.heightFt.getText().toString()) && TextUtils.isEmpty(binding.heightIn.getText().toString())) {
                    binding.heightFt.setError("can't be Empty");
                    binding.heightFt.requestFocus();

                    binding.heightIn.setError("can't be Empty");
                    binding.heightIn.requestFocus();
                } else {
                    fit = Integer.parseInt(binding.heightFt.getText().toString());
                    in = Integer.parseInt(binding.heightIn.getText().toString());
                    totalMeter = (float) ((fit * 0.3048) + (in * 0.0254));
                }


                if (!TextUtils.isEmpty(binding.weightKg.getText().toString())) {
                    weightKg = Float.parseFloat(binding.weightKg.getText().toString());
                    totalWeight = weightKg;
                } else {
                    binding.weightKg.setError("can't be Empty");
                    binding.weightKg.requestFocus();
                }


                sum = totalWeight / (totalMeter * totalMeter);
                BMI = String.valueOf(sum);
                binding.bmi.setText(BMI);


            } else if (heightCK && !weightCK) {

                if (!TextUtils.isEmpty(binding.heightCm.getText().toString())) {
                    heightCm = Float.parseFloat(binding.heightCm.getText().toString());
                    totalMeter = (float) (heightCm / 100);

                } else {
                    binding.heightCm.setError("can't be Empty");
                    binding.heightCm.requestFocus();
                }

                if (!TextUtils.isEmpty(binding.weightKg.getText().toString())) {
                    weightKg = Float.parseFloat(binding.weightKg.getText().toString());
                    totalWeight = weightKg;
                } else {
                    binding.weightKg.setError("can't be Empty");
                    binding.weightKg.requestFocus();
                }


                sum = totalWeight / (totalMeter * totalMeter);
                BMI = String.valueOf(sum);
                binding.bmi.setText(BMI);

            } else if (!heightCK && weightCK) {

                if (TextUtils.isEmpty(binding.heightFt.getText().toString()) && TextUtils.isEmpty(binding.heightIn.getText().toString())) {
                    binding.heightFt.setError("can't be Empty");
                    binding.heightFt.requestFocus();

                    binding.heightIn.setError("can't be Empty");
                    binding.heightIn.requestFocus();
                } else {
                    fit = Integer.parseInt(binding.heightFt.getText().toString());
                    in = Integer.parseInt(binding.heightIn.getText().toString());
                    totalMeter = (float) ((fit * 0.3048) + (in * 0.0254));
                }

                if (!TextUtils.isEmpty(binding.weightLbs.getText().toString())) {
                    weightLbs = Float.parseFloat(binding.weightLbs.getText().toString());
                    totalWeight = (float) (weightLbs / 2.20462);
                } else {
                    binding.weightLbs.setError("can't be Empty");
                    binding.weightLbs.requestFocus();
                }

                sum = totalWeight / (totalMeter * totalMeter);
                BMI = String.valueOf(sum);
                binding.bmi.setText(BMI);


            } else if (heightCK && !weightCK) {

                if (!TextUtils.isEmpty(binding.heightCm.getText().toString())) {
                    heightCm = Float.parseFloat(binding.heightCm.getText().toString());
                    totalMeter = (float) (heightCm / 100);
                } else {
                    binding.heightCm.setError("can't be Empty");
                    binding.heightCm.requestFocus();
                }

                if (!TextUtils.isEmpty(binding.weightLbs.getText().toString())) {
                    weightLbs = Float.parseFloat(binding.weightLbs.getText().toString());
                    totalWeight = (float) (weightLbs / 2.20462);
                } else {
                    binding.weightLbs.setError("can't be Empty");
                    binding.weightLbs.requestFocus();
                }
                sum = totalWeight / (totalMeter * totalMeter);
                BMI = String.valueOf(sum);
                binding.bmi.setText(BMI);

            } else if (heightCK && weightCK) {

                if (!TextUtils.isEmpty(binding.heightCm.getText().toString())) {
                    heightCm = Float.parseFloat(binding.heightCm.getText().toString());
                    totalMeter = (float) (heightCm / 100);
                } else {
                    binding.heightCm.setError("can't be Empty");
                    binding.heightCm.requestFocus();
                }

                if (!TextUtils.isEmpty(binding.weightLbs.getText().toString())) {
                    weightLbs = Float.parseFloat(binding.weightLbs.getText().toString());
                    totalWeight = (float) (weightLbs / 2.20462);
                } else {
                    binding.weightLbs.setError("can't be Empty");
                    binding.weightLbs.requestFocus();
                }
                sum = totalWeight / (totalMeter * totalMeter);
                BMI = String.valueOf(sum);
                binding.bmi.setText(BMI);
            }


            if (Float.parseFloat(BMI) < 16.0) {
                binding.comment.setText("Very Severely underweight");
                binding.verySeverelyUnderweight.setBackgroundColor(getResources().getColor(R.color.layout_background));
            } else if (Float.parseFloat(BMI) > 16.0 && Float.parseFloat(BMI) < 16.9) {
                binding.comment.setText("Severely underweight");
                binding.severelyUnderweight.setBackgroundColor(getResources().getColor(R.color.layout_background));
            } else if (Float.parseFloat(BMI) > 17.0 && Float.parseFloat(BMI) < 18.4) {
                binding.comment.setText("Underweight");
                binding.underweight.setBackgroundColor(getResources().getColor(R.color.layout_background));

            } else if (Float.parseFloat(BMI) > 18.5 && Float.parseFloat(BMI) < 24.9) {
                binding.comment.setText("Healthy");
                binding.healthy.setBackgroundColor(getResources().getColor(R.color.layout_background));

            } else if (Float.parseFloat(BMI) > 25.0 && Float.parseFloat(BMI) < 29.9) {
                binding.comment.setText("Overweight");
                binding.overweight.setBackgroundColor(getResources().getColor(R.color.layout_background));

            } else if (Float.parseFloat(BMI) > 30.0 && Float.parseFloat(BMI) < 34.9) {
                binding.comment.setText("Obese Class I");
                binding.obeseClassI.setBackgroundColor(getResources().getColor(R.color.layout_background));

            } else if (Float.parseFloat(BMI) > 35.0 && Float.parseFloat(BMI) < 39.9) {
                binding.comment.setText("Obese Class II");
                binding.obeseClassIi.setBackgroundColor(getResources().getColor(R.color.layout_background));

            } else if (Float.parseFloat(BMI) >= 40.0) {
                binding.comment.setText("Obese Class III");
                binding.obeseClassIii.setBackgroundColor(getResources().getColor(R.color.layout_background));
            }

        });


    }
}