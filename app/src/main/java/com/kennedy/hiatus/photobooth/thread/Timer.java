package com.kennedy.hiatus.photobooth.thread;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class Timer implements Runnable {

    private static final int START_TIME_IN_MILLIS = 60000;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;
    private CountDownTimer countDownTimer;

    private TextView view;
    private Context context;



    public Timer(Context context) {
        this.context = context;
    }

    public Timer(Context context, TextView tv) {
        this.context = context;
        this.view = tv;
    }

    @Override
    public void run() {
        startTimer();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;

                int seconds = (int) (timeLeftInMillis / 1000) % 60;

                String formatted = String.format(Locale.getDefault(), "%02d", seconds);

                view.setText(formatted);
            }

            @Override
            public void onFinish() {

            }
        };
    }
}
