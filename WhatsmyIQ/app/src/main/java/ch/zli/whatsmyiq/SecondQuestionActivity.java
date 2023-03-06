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

public class SecondQuestionActivity extends AppCompatActivity {
    private TextView title;
    private TextView question;
    private EditText input;
    private Button submitButton;
    private boolean solvedSecond = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        title = findViewById(R.id.title);
        question = findViewById(R.id.question3);
        input = findViewById(R.id.input2);
        submitButton = findViewById(R.id.submitButton3);

        SharedPreferences sharedPreferences = getSharedPreferences("database", MODE_PRIVATE);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = input.getText().toString().trim();
                String solution = "47";

                if (userInput.equals(solution)) {
                    Toast.makeText(SecondQuestionActivity.this, "Input: " + userInput + ", is true", Toast.LENGTH_SHORT).show();
                    solvedSecond = true;
                    sharedPreferences.edit().putBoolean("question2", true).apply();
                } else {
                    Toast.makeText(SecondQuestionActivity.this, "Wrong, the solution is: :" + solution, Toast.LENGTH_SHORT).show();
                    solvedSecond = false;
                    sharedPreferences.edit().putBoolean("question2", false).apply();
                }
                Intent intent = new Intent(SecondQuestionActivity.this, ThirdQuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}