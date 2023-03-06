package ch.zli.whatsmyiq.Modal;

import android.content.Context;
import android.util.Log;

import java.util.Arrays;

public class Vibrator {
    private final android.os.Vibrator vibrator;

    public Vibrator(Context context) {
        vibrator = (android.os.Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    // I copied the log from the internet
    public void vibrate(long[] pattern, int repeat) {
        if (vibrator.hasVibrator()) {
            Log.d("Vibration", "Vibrating brrr brrr brrr: " + Arrays.toString(pattern) + ", repeat: " + repeat);
            vibrator.vibrate(pattern, repeat);
        } else {
            Log.d("Vibration", "No vibrator found.");
        }
    }
}
