package com.example.lg.work3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button grade,reservation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    void init(){
        grade = (Button)findViewById(R.id.grade_cal);
        reservation = (Button)findViewById(R.id.reservation);

    }
    void act(int a){
        if(a==1) {
            Intent grade_intent = new Intent(MainActivity.this, GradeCal.class);
            startActivity(grade_intent);
        }
        if(a==2) {
            Intent reservation = new Intent(MainActivity.this, Reservation.class);
            startActivity(reservation);
        }
    }
}
