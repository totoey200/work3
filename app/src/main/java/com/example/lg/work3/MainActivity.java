package com.example.lg.work3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("실습2");

    }
    public void onMyClick(View v){
        if(v.getId()== R.id.grade_cal){
            act(1);
        }
        else if(v.getId()== R.id.reservation){
            act(2);
        }
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
