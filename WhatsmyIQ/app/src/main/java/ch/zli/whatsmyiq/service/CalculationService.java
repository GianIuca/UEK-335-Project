package ch.zli.whatsmyiq.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class CalculationService extends Service {
    private int correct = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        SharedPreferences sharedPreferences = getSharedPreferences("database", MODE_PRIVATE);

        boolean question1 = sharedPreferences.getBoolean("question1", false);
        boolean question2 = sharedPreferences.getBoolean("question2", false);
        boolean question3 = sharedPreferences.getBoolean("question3", false);
        boolean question4 = sharedPreferences.getBoolean("question4", false);

        boolean[] questions = {question1, question2, question3, question4};

        for (boolean b : questions) {
            if (b) {
                correct++;
            }
        }

        int iq = 80;

        if (correct == 1) {
            iq = 95;
        } else if (correct == 2) {
            iq = 101;
        } else if (correct == 3) {
            iq = 110;
        } else if (correct == 4) {
            iq = 120;
        }

        sharedPreferences.edit().putInt("iq", iq).apply();

        stopSelf();
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //Intent intent = new Intent(getApplicationContext(), CalculationService.class);

    //startService(intent);
}
