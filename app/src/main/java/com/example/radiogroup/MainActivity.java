package com.example.radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup check_gender;

    CheckBox check_java;

    Spinner course_spinner;

    TimePicker time_Picker;

    Button button;

    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check_gender = findViewById(R.id.radio_group);
        check_java = findViewById(R.id.check_box);
        course_spinner =findViewById(R.id.course_spinner);
        time_Picker = findViewById(R.id.time_picker);
        button = findViewById(R.id.button);

        //RadioButton
        check_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup Group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "you click " + radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        //check_box
        check_java.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheckedId) {

                if(isCheckedId) {
                    Toast.makeText(MainActivity.this, "you click java", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"you not select", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //spinner
        String[] course = {"java", "React native", "Kotlin", "Dart", "Flutter"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,course);
        course_spinner.setAdapter(adapter);

        course_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long Id) {
                Toast.makeText(MainActivity.this, "you select" + "  " + course [position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        time_Picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, " " + hourOfDay + " : " + " " + " " + minute, Toast.LENGTH_LONG).show();

            }
        });
        // Intent code

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DatePickerActivity.class);
                startActivity(intent);
            }
        });
    }
}