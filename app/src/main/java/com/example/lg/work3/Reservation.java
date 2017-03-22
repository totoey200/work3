package com.example.lg.work3;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

public class Reservation extends AppCompatActivity {
    Switch start;
    FrameLayout frame;
    DatePicker date;
    TimePicker time;
    GridLayout num, result_pan;
    TextView progress, date_result, time_result, adult_result, childhood_result;
    TextView kid_result;
    EditText adult,childhood,kids;
    LinearLayout btn_group;
    Button prev,next;
    Chronometer chrono;
    int status=1,tic=0,toc=0;

    Handler mHandler = new Handler();

    public void mClick(View v){
        if(v.getId()==R.id.prev){
            status--;
        }
        else if(v.getId()==R.id.next){
            status++;
        }
        changepanel(status);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        setTitle("레스토랑 예약시스템");

        init();

    }

    void init(){
        start = (Switch)findViewById(R.id.start);
        frame = (FrameLayout) findViewById(R.id.frame);
        date = (DatePicker) findViewById(R.id.date);
        time = (TimePicker) findViewById(R.id.time);
        num = (GridLayout) findViewById(R.id.num);
        result_pan = (GridLayout) findViewById(R.id.result_pan);
        progress = (TextView) findViewById(R.id.progress);
        date_result = (TextView) findViewById(R.id.date_result);
        time_result = (TextView) findViewById(R.id.time_result);
        adult_result = (TextView) findViewById(R.id.adult_result);
        childhood_result = (TextView) findViewById(R.id.childhood_result);
        kid_result = (TextView) findViewById(R.id.kids_result);
        btn_group = (LinearLayout) findViewById(R.id.btn_group);
        adult = (EditText)findViewById(R.id.adult);
        childhood = (EditText)findViewById(R.id.childhood);
        kids = (EditText)findViewById(R.id.kids);
        prev = (Button)findViewById(R.id.prev);
        next = (Button)findViewById(R.id.next);
        chrono = (Chronometer)findViewById(R.id.chrono);

        start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    changepanel(1);
                    progress.setVisibility(View.VISIBLE);
                    chrono.setVisibility(View.VISIBLE);
                    chrono.setBase(SystemClock.elapsedRealtime());
                    chrono.start();
                }
                else{
                    changepanel(0);
                    chrono.stop();
                    chrono.setBase(SystemClock.elapsedRealtime());
                    chrono.setVisibility(View.GONE);
                }
            }
        });
    }

    void setTime(TextView view,int hour,int min){
        view.setText(String.format("%d시 %d분",hour,min));
    }
    void setDate(TextView view,int year,int month,int date){
        view.setText(String.format("%d년 %d월 %d일",year,month,date));
    }

    void changepanel(int state){
        if(state == 0){
            frame.setVisibility(View.GONE);
            date.setVisibility(View.GONE);
            btn_group.setVisibility(View.GONE);
            progress.setVisibility(View.GONE);
            time.setVisibility(View.GONE);
            num.setVisibility(View.GONE);
            result_pan.setVisibility(View.GONE);
            tic=0;toc=0;
        }
        else if(state == 1){
            btn_group.setVisibility(View.VISIBLE);
            next.setEnabled(true);
            prev.setEnabled(false);
            frame.setVisibility(View.VISIBLE);
            date.setVisibility(View.VISIBLE);
            time.setVisibility(View.GONE);
        }
        else if(state == 2){
            prev.setEnabled(true);
            frame.setVisibility(View.VISIBLE);
            date.setVisibility(View.GONE);
            num.setVisibility(View.GONE);
            time.setVisibility(View.VISIBLE);
        }
        else if(state == 3){
            next.setEnabled(true);
            frame.setVisibility(View.VISIBLE);
            num.setVisibility(View.VISIBLE);
            time.setVisibility(View.GONE);
            result_pan.setVisibility(View.GONE);

        }
        else if(state == 4){
            next.setEnabled(false);
            frame.setVisibility(View.VISIBLE);
            num.setVisibility(View.GONE);
            result_pan.setVisibility(View.VISIBLE);
            countPeople();
            setDate(date_result,date.getYear(),date.getMonth(),date.getDayOfMonth());
            setTime(time_result,time.getHour(),time.getMinute());
        }
    }

    void countPeople(){
        GradeCal gradeCal = new GradeCal();
        adult_result.setText(Integer.toString(gradeCal.cal_check(adult))+"명");
        childhood_result.setText(Integer.toString(gradeCal.cal_check(childhood))+"명");
        kid_result.setText(Integer.toString(gradeCal.cal_check(kids))+"명");
    }
}
