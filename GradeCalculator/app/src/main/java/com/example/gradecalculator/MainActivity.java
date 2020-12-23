package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText quiz1 = findViewById(R.id.Quiz);
        EditText homework1 = findViewById(R.id.Homework);
        EditText midterm1 = findViewById(R.id.Midterm);
        EditText final1 = findViewById(R.id.Final);

        Button calculate = findViewById(R.id.Calculate);
        Button reset = findViewById(R.id.Reset);

        TextView result = findViewById(R.id.Result);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double quiz = Double.parseDouble(quiz1.getText().toString());
                double homework = Double.parseDouble(homework1.getText().toString());
                double midterm = Double.parseDouble(midterm1.getText().toString());
                double Final = Double.parseDouble(final1.getText().toString());
                double res = quiz+homework+midterm+Final;
                if (res>=0 && res<=100){
                    if(res<60){
                        result.setText("F");
                        result.setTextColor(Color.parseColor("#F72110"));
                    } else if(res<70){
                        result.setText("D");
                        result.setTextColor(Color.parseColor("#F79F10"));
                    } else if(res<80){
                        result.setText("C");
                        result.setTextColor(Color.parseColor("#F7F70F"));
                    } else if(res<90){
                        result.setText("B");
                        result.setTextColor(Color.parseColor("#3635E9"));
                    } else{
                        result.setText("A");
                        result.setTextColor(Color.parseColor("#0AF109"));
                    }
                }else{
                    result.setText("Error");
                    result.setTextColor(Color.parseColor("#000000"));
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Result");
                final1.setText("");
                midterm1.setText("");
                quiz1.setText("");
                homework1.setText("");
            }
        });
    }
}