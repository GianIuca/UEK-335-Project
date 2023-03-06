package ch.zli.whatsmyiq.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import ch.zli.whatsmyiq.Modal.Vibrator;

public class NotificationService extends Service {

    private static final String CHANNEL_ID = "defaultChannel";
    private static final String CHANNEL_NAME = "Default Channel";
    private NotificationManager notificationManager;

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

        sendNotification();

        stopSelf();

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        notificationManager.createNotificationChannel(channel);
    }

    //TODO add notes
    private void sendNotification() {
        int iq;
        SharedPreferences sharedPreferences = getSharedPreferences("database", MODE_PRIVATE);
        iq = sharedPreferences.getInt("iq", 69);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setContentTitle("Dein IQ ist: " + iq)
                .setContentText("Das hast du gut gemacht ")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Vibrate phone
        Vibrator vibrator = new Vibrator(this);
        long[] pattern = {0, 187, 690, 420};
        vibrator.vibrate(pattern, -1);

        notificationManager.notify(0, builder.build());
    }

}

