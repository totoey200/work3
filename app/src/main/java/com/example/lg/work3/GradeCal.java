package com.example.lg.work3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class GradeCal extends AppCompatActivity {
    EditText ko,math,eng;
    Button cal,reset;
    TextView score,avg;
    ImageView grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_cal);
        init();

    }
    void init(){
        ko = (EditText)findViewById(R.id.korean);
        math = (EditText)findViewById(R.id.math);
        eng = (EditText)findViewById(R.id.english);
        cal = (Button)findViewById(R.id.cal);
        reset = (Button)findViewById(R.id.reset);
        score = (TextView) findViewById(R.id.score);
        avg = (TextView) findViewById(R.id.average);
        grade = (ImageView) findViewById(R.id.grade);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sco_ko = ko.getText().toString();
                String sco_math = math.getText().toString();
                String sco_eng = eng.getText().toString();
                ko.setText(Integer.toString(cal_check(sco_ko)));
                math.setText(Integer.toString(cal_check(sco_math)));
                eng.setText(Integer.toString(cal_check(sco_eng)));
                int result = cal_check(sco_ko) + cal_check(sco_math) + cal_check(sco_eng);
                int average = result/3;
                score.setText(Integer.toString(result)+"점");
                avg.setText(Integer.toString(average)+"점");
                generate_grade(average);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ko.setText("");
                math.setText("");
                eng.setText("");
                score.setText("0점");
                avg.setText("0점");
                grade.setVisibility(View.GONE);
            }
        });

    }
    int cal_check(String num){
        if(num.equals("")){
            return 0;
        }
        else{
            return Integer.parseInt(num);
        }
    }

    void generate_grade(int avg){
        if(avg >= 90){
            grade.setImageResource(R.drawable.letter_a_red);
        }
        else if(avg >= 80){
            grade.setImageResource(R.drawable.letter_b_red);
        }
        else if(avg >= 70){
            grade.setImageResource(R.drawable.letter_c_red);
        }
        else if(avg >= 60){
            grade.setImageResource(R.drawable.letter_d_red);
        }
        else{
            grade.setImageResource(R.drawable.letter_f_red);
        }
    }
}
