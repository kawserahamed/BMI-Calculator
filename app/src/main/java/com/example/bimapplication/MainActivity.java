package com.example.bimapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bimapplication.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    String spFt;
    String spKg;
    boolean heightCK;
    boolean weightCK;
    int fit = 0;
    float in = 0;
    float heightCm = 0;
    float weightLbs = 0;
    float weightKg = 0;
    float sum = 0;
    float totalMeter = 0;
    float totalWeight = 0;
    float newSum = 0;
    String strWeight = "";


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spFt = binding.spinnerFit.getSelectedItem().toString();

        spKg = binding.spinnerKg.getSelectedItem().toString();

        DecimalFormat precision = new DecimalFormat("0.00");

        binding.reset.setOnClickListener(view -> {

            //set All Text Null
            binding.heightCm.setText("");
            binding.heightFt.setText("");
            binding.heightIn.setText("");
            binding.weightKg.setText("");
            binding.weightLbs.setText("");
            binding.bmi.setText(R.string._00_00);
            binding.comment.setText("");
            sum = 0;
            fit = 0;
            in = 0;
            heightCm = 0;
            weightLbs = 0;
            weightKg = 0;
            sum = 0;
            totalMeter = 0;
            totalWeight = 0;
            newSum = 0;
            strWeight = "";
            binding.showKg.setVisibility(View.GONE);

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
            binding.bmi.setText(R.string._00_00);
            binding.comment.setText("");
            sum = 0;
            newSum = 0;
            strWeight = "";
            binding.showKg.setVisibility(View.GONE);


            // for height CM and Weight KG     And Height Ft and Weight KG
            if (!heightCK && !weightCK) {

                //height cm initialization
                in = Float.parseFloat(binding.heightIn.getText().toString());
                fit = Integer.parseInt(binding.heightFt.getText().toString());
                weightKg = Float.parseFloat(binding.weightKg.getText().toString());

                if (fit == 0 || weightKg == 0) {
                    binding.heightFt.setError("This Field Can't be Empty or 0");
                    binding.weightKg.setError("This Field Can't be Empty or 0");
                    binding.weightKg.requestFocus();
                } else {
                    totalMeter = (float) ((fit * 0.3048) + (in * 0.0254));
                    sum = totalWeight / (totalMeter * totalMeter);
                    binding.bmi.setText(precision.format(sum));
                }


            } else if (heightCK && !weightCK) {
                heightCm = Float.parseFloat(binding.heightCm.getText().toString());
                totalMeter = heightCm / 100;
                weightKg = Float.parseFloat(binding.weightKg.getText().toString());
                totalWeight = weightKg;

                if (heightCm == 0 || weightKg == 0) {
                    binding.weightKg.setError("This Field Can't be Empty or 0");
                    binding.heightCm.setError("This Field Can't be Empty or 0");
                } else {
                    sum = totalWeight / (totalMeter * totalMeter);
                    binding.bmi.setText(precision.format(sum));
                }


            } else if (!heightCK && weightCK) {

                in = Float.parseFloat(binding.heightIn.getText().toString());
                fit = Integer.parseInt(binding.heightFt.getText().toString());
                weightLbs = Float.parseFloat(binding.weightLbs.getText().toString());
                totalWeight = (float) (weightLbs * 0.453592);
                if (fit == 0 || weightLbs == 0) {
                    binding.weightLbs.setError("This Field Can't be Empty or 0");
                    binding.heightFt.setError("This Field Can't be Empty or 0");
                } else {
                    sum = totalWeight / (totalMeter * totalMeter);
                    binding.bmi.setText(precision.format(sum));
                }


            } else if (heightCK && weightCK) {


                heightCm = Float.parseFloat(binding.heightCm.getText().toString());
                totalMeter = heightCm / 100;
                weightLbs = Float.parseFloat(binding.weightLbs.getText().toString());
                totalWeight = (float) (weightLbs * 0.453592);

                if (heightCm == 0 || weightLbs == 0) {
                    binding.heightCm.setError("This Field Can't be Empty or 0");
                    binding.weightLbs.setError("This Field Can't be Empty or 0");

                } else {
                    sum = totalWeight / (totalMeter * totalMeter);
                    binding.bmi.setText(precision.format(sum));
                }

            }

            if (sum > 0) {
                setMessageBackground();
                findRecommended();
            }

        });


    }

    private void findRecommended() {
        if (sum < 18.5) {

            for (float i = 1; i < 100; i++) {
                float newWeight = totalWeight + i;
                newSum = newWeight / (totalMeter * totalMeter);
                if (newSum >= 18.5) {
                    strWeight = String.valueOf(i);
                    binding.weightNeed.setText(R.string.need_healthy);
                    binding.showKg.setText(R.string.kg);
                    binding.reCommand.setText(strWeight);
                    break;
                }
            }

        } else if (sum > 24.9) {
            for (int i = 1; i < 150; i++) {
                float newWeight = totalWeight - i;
                newSum = newWeight / (totalMeter * totalMeter);
                if (newSum <= 24.9) {
                    strWeight = String.valueOf(i);
                    binding.weightNeed.setText(R.string.lose_healthy);
                    binding.showKg.setText(R.string.kg);
                    binding.reCommand.setText(strWeight);
                    break;
                }
            }
        } else {
            binding.weightNeed.setText(null);
            binding.showKg.setText(null);
            strWeight = String.valueOf(0);
            binding.reCommand.setText(null);
        }
    }

    private void setMessageBackground() {
        if (sum < 16.0) {
            binding.comment.setText(R.string.very_severely_underweight);
            binding.verySeverelyUnderweight.setBackgroundColor(getResources().getColor(R.color.Very_Severely_underweight));
        } else if (sum > 16.0 && sum < 16.9) {
            binding.comment.setText(R.string.severely_underweight);
            binding.severelyUnderweight.setBackgroundColor(getResources().getColor(R.color.Severely_underweight));
        } else if (sum > 17.0 && sum < 18.4) {
            binding.comment.setText(R.string.underweight);
            binding.underweight.setBackgroundColor(getResources().getColor(R.color.Underweight));

        } else if (sum > 18.5 && sum < 24.9) {
            binding.comment.setText(R.string.healthy);
            binding.healthy.setBackgroundColor(getResources().getColor(R.color.Healthy));

        } else if (sum > 25.0 && sum < 29.9) {
            binding.comment.setText(R.string.overweight);
            binding.overweight.setBackgroundColor(getResources().getColor(R.color.Overweight));

        } else if (sum > 30.0 && sum < 34.9) {
            binding.comment.setText(R.string.obese_class_i);
            binding.obeseClassI.setBackgroundColor(getResources().getColor(R.color.Obese_Class_I));

        } else if (sum > 35.0 && sum < 39.9) {
            binding.comment.setText(R.string.obese_class_ii);
            binding.obeseClassIi.setBackgroundColor(getResources().getColor(R.color.Obese_Class_ii));

        } else if (sum >= 40.0) {
            binding.comment.setText(R.string.obese_class_ii);
            binding.obeseClassIii.setBackgroundColor(getResources().getColor(R.color.Obese_Class_iii));
        }
    }
}