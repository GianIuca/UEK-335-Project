package ch.zli.whatsmyiq;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ch.zli.whatsmyiq.service.NotificationService;

public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        boolean question1 = false;
        boolean question2 = false;
        boolean question3 = false;
        boolean question4 = false;

        SharedPreferences sharedPreferences = getSharedPreferences("database", MODE_PRIVATE);
        question1 = sharedPreferences.getBoolean("question1", false);
        question2 = sharedPreferences.getBoolean("question2", false);
        question3 = sharedPreferences.getBoolean("question3", false);
        question4 = sharedPreferences.getBoolean("question4", false);

        String age = sharedPreferences.getString("age", "<18");

        System.out.println(question1 + " 1");
        System.out.println(question2 + " 2");
        System.out.println(question3 + " 3");
        System.out.println(question4 + " 4");
        System.out.println(age + " age");

        Intent intent = new Intent(this, NotificationService.class);
        startService(intent);

    }


}