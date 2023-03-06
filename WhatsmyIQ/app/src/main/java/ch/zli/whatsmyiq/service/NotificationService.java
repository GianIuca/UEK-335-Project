package ch.zli.whatsmyiq.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import ch.zli.whatsmyiq.Modal.Vibrator;

public class NotificationService extends Service {

    private static final String CHANNEL_ID = "defaultChannel";
    private static final String CHANNEL_NAME = "Default Channel";
    private NotificationManager notificationManager;
    private final String note = "Das hast du gut gemacht";
    private final String note2 = "Das hast du SUPER gemacht!";
    private final String note3 = "Das nächste Mal wirds besser";
    private final String note4 = "Ich würde dir empfehlen, das zu wiederholen";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        sendNotification();
        return super.onStartCommand(intent, flags, startId);
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

    private void sendNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setContentTitle("Dein IQ ist: ")
                .setContentText("Das hast du gut gemacht ")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Vibrate phone
        Vibrator vibrator = new Vibrator(this);
        long[] pattern = {0, 187, 690, 420};
        vibrator.vibrate(pattern, -1);


        notificationManager.notify(0, builder.build());
    }
}
