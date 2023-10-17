package com.example.radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;


public class DatePickerActivity extends AppCompatActivity {

    DatePicker date_picker;

    Button btn_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        date_picker = findViewById(R.id.date_picker);
        btn_button = findViewById(R.id.btn_button);

        btn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day = String.valueOf(date_picker.getDayOfMonth());
                String month = String.valueOf(date_picker.getDayOfMonth() +1);
                String year = String.valueOf(date_picker.getYear());

                Toast.makeText(DatePickerActivity.this, "date", Toast.LENGTH_SHORT).show();
            }
        });
            }

}