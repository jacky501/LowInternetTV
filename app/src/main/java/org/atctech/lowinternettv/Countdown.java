package org.atctech.lowinternettv;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.atctech.lowinternettv.activities.SplashActivity;

import java.util.Date;

public class Countdown extends AppCompatActivity {

    private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond;
    private TextView tvEvent;
    private Handler handler;
    private Runnable runnable;
    private CountDownTimer countDownTimer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countdown);

        txtTimerDay = findViewById(R.id.txtTimerDay);
        txtTimerHour =  findViewById(R.id.txtTimerHour);
        txtTimerMinute =  findViewById(R.id.txtTimerMinute);
        txtTimerSecond =  findViewById(R.id.txtTimerSecond);
        tvEvent =  findViewById(R.id.tvhappyevent);

       // countDownStart();

        startTimer();


    /*    172800000 milliseconds = 5days

    1000(1sec) is time interval to call onTick method

    millisUntilFinished is amount of until finished

    */


    }

    private void startTimer() {
        long timer = getRemainingDays();
       countDownTimer = new CountDownTimer(timer, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                int days = (int) (millisUntilFinished/(24*60*60*1000));
                int hours = (int) (millisUntilFinished/(60*60*1000))%24;
                int minutes = (int) (millisUntilFinished/(60*1000)%60);
                int seconds = (int) (millisUntilFinished/(1000)%60);

                txtTimerDay.setText(String.valueOf(days));
                txtTimerHour.setText(String.valueOf(hours));
                txtTimerMinute.setText(String.valueOf(minutes));
                txtTimerSecond.setText(String.valueOf(seconds));
            }

            @Override
            public void onFinish() {

                startActivity(new Intent(Countdown.this,SplashActivity.class));
                finish();
            }
        };

       countDownTimer.start();

    }

    private long getRemainingDays() {
        Date currentDate = new Date();
        Date futureDate;

        if (currentDate.getMonth() <=11)
        {
            futureDate = new Date(currentDate.getYear(),4,14);
        }else
        {
            futureDate = new Date(currentDate.getYear()+4,6,14);
        }

        return futureDate.getTime() - currentDate.getTime();
    }

//    public void countDownStart() {
//        handler = new Handler();
//        runnable = new Runnable() {
//            @Override
//            public void run() {
//                handler.postDelayed(this, 1000);
//                try {
//                    SimpleDateFormat dateFormat = new SimpleDateFormat(
//                            "yyyy-MM-dd");
//                    // Please here set your event date//YYYY-MM-DD
//                    Date futureDate = dateFormat.parse("2018-5-30");
//                    Date currentDate = new Date();
//                    if (!currentDate.after(futureDate)) {
//                        long diff = futureDate.getTime()
//                                - currentDate.getTime();
//                        long days = diff / (24 * 60 * 60 * 1000);
//                        diff -= days * (24 * 60 * 60 * 1000);
//                        long hours = diff / (60 * 60 * 1000);
//                        diff -= hours * (60 * 60 * 1000);
//                        long minutes = diff / (60 * 1000);
//                        diff -= minutes * (60 * 1000);
//                        long seconds = diff / 1000;
//                        txtTimerDay.setText("" + String.format("%02d", days));
//                        txtTimerHour.setText("" + String.format("%02d", hours));
//                        txtTimerMinute.setText(""
//                                + String.format("%02d", minutes));
//                        txtTimerSecond.setText(""
//                                + String.format("%02d", seconds));
//                    } else {
//                        tvEvent.setVisibility(View.VISIBLE);
//                        tvEvent.setText("world has been started!");
//                        textViewGone();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        handler.postDelayed(runnable, 1 * 1000);
//    }
//
//    public void textViewGone() {
//        findViewById(R.id.LinearLayout10).setVisibility(View.GONE);
//        findViewById(R.id.LinearLayout11).setVisibility(View.GONE);
//        findViewById(R.id.LinearLayout12).setVisibility(View.GONE);
//        findViewById(R.id.LinearLayout13).setVisibility(View.GONE);
//        findViewById(R.id.textView1).setVisibility(View.GONE);
//        findViewById(R.id.textView2).setVisibility(View.GONE);
//    }
}
