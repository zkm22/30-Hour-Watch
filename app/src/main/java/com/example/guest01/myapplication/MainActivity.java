package com.example.guest01.myapplication;

//import android.icu.util.Calendar;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Time;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.TimerTask;
import android.os.Handler;

public class MainActivity extends Activity {

    Calendar cal;
    String year;
    String month;
    String day;
    String hour;
    String minute;
    String second;
    String week;

    TextView DateText;
    TextView HourText;
    TextView MinuteText;
    TextView SecondText;
    TextView TimeText;
    TextView WeekText;

    Handler handler = new Handler( );
    Runnable runnable;

    final String[] WEEK_DICT = {"Sun.","Mon.","Tues.","Wed.","Thur","Fri.","Sat."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DateText = (TextView)findViewById(R.id.DateText);
//        HourText = (TextView)findViewById(R.id.HourText);
//        MinuteText = (TextView)findViewById(R.id.MinuteText);
//        SecondText = (TextView)findViewById(R.id.SecondText);

        TimeText = (TextView)findViewById(R.id.TimeText);
        WeekText = (TextView)findViewById(R.id.WeekText);



//        TimerTask task = new TimerTask() {
//            public void run() {
//
//            }
//        };

        runnable = new Runnable( ) {
            public void run() {
                cal = Calendar.getInstance();
                cal.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

                if (cal.get(Calendar.HOUR_OF_DAY)<6) {
                    cal.add(Calendar.DAY_OF_MONTH,-1);
                    hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY)+24);
                } else {
                    hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
                }
                year = String.valueOf(cal.get(Calendar.YEAR));
                month = String.valueOf(cal.get(Calendar.MONTH) + 1);
                day = String.valueOf(cal.get(Calendar.DATE));
                week = String.valueOf(cal.get(Calendar.DAY_OF_WEEK));
                minute = String.valueOf(cal.get(Calendar.MINUTE));
                second = String.valueOf(cal.get(Calendar.SECOND));
                DateText.setText(year + "/"+month+"/"+ day);
//                HourText.setText(hour);
//                MinuteText.setText(minute);
//                SecondText.setText(second);
                TimeText.setText(hour+":"+minute+":"+second);
                WeekText.setText(WEEK_DICT[cal.get(Calendar.DAY_OF_WEEK)-1]);
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable,0);
//        java.util.Timer timer = new java.util.Timer(true);
//        timer.schedule(task, 0, 1000);
    }
}
