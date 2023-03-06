package ch.zli.whatsmyiq;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FourthQuestionActivity extends AppCompatActivity {
    private TextView title;
    private TextView question;
    private EditText input;
    private Button submitButton;
    private boolean solvedFourth = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_question);

        title = findViewById(R.id.title);
        question = findViewById(R.id.question5);
        input = findViewById(R.id.input4);
        submitButton = findViewById(R.id.submitButton5);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = input.getText().toString().trim();
                String solution = "Me";
                String solution2 = "Gianluca";
                String solution3 = "Yves";
                String solution4 = "Herr Bühler";
                String solution5 = "Robin";

                SharedPreferences sharedPreferences = getSharedPreferences("database", MODE_PRIVATE);

                if (userInput.equals(solution)) {
                    Toast.makeText(FourthQuestionActivity.this, "Input: " + userInput + ", is true", Toast.LENGTH_SHORT).show();
                    solvedFourth = true;
                    sharedPreferences.edit().putBoolean("question4", true).apply();
                } else if (userInput.equals(solution2)) {
                    Toast.makeText(FourthQuestionActivity.this, "Input: " + userInput + ", is true", Toast.LENGTH_SHORT).show();
                    solvedFourth = true;
                    sharedPreferences.edit().putBoolean("question4", true).apply();
                } else if (userInput.equals(solution3)) {
                    Toast.makeText(FourthQuestionActivity.this, "Input: " + userInput + ", is true", Toast.LENGTH_SHORT).show();
                    solvedFourth = true;
                    sharedPreferences.edit().putBoolean("question4", true).apply();
                } else if (userInput.equals(solution4)) {
                    Toast.makeText(FourthQuestionActivity.this, "Input: " + userInput + ", is true", Toast.LENGTH_SHORT).show();
                    solvedFourth = true;
                    sharedPreferences.edit().putBoolean("question4", true).apply();
                } else if (userInput.equals(solution5)) {
                    Toast.makeText(FourthQuestionActivity.this, "Input: " + userInput + ", is true", Toast.LENGTH_SHORT).show();
                    solvedFourth = true;
                    sharedPreferences.edit().putBoolean("question4", true).apply();
                } else {
                    Toast.makeText(FourthQuestionActivity.this, "Wrong, the solution is: :" + solution, Toast.LENGTH_SHORT).show();
                    solvedFourth = false;
                    sharedPreferences.edit().putBoolean("question4", false).apply();
                }
                Intent intent = new Intent(FourthQuestionActivity.this, EmptyActivity.class);
                startActivity(intent);
            }
        });
    }
}
