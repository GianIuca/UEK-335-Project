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

public class FirstQuestionActivity extends AppCompatActivity {
    private TextView title;
    private TextView question;
    private EditText input;
    private Button submitButton;
    private boolean solvedFirst = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        title = findViewById(R.id.title);
        question = findViewById(R.id.question2);
        input = findViewById(R.id.input1);
        submitButton = findViewById(R.id.submitButton2);

        SharedPreferences sharedPreferences = getSharedPreferences("database", MODE_PRIVATE);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = input.getText().toString().trim();
                String solution = "1";

                if (userInput.equals(solution)) {
                    Toast.makeText(FirstQuestionActivity.this, "Input: " + userInput + ", is true", Toast.LENGTH_SHORT).show();
                    solvedFirst = true;
                    // only store it when it's true
                    sharedPreferences.edit().putBoolean("question1", true).apply();
                } else {
                    Toast.makeText(FirstQuestionActivity.this, "Wrong, the solution is: :" + solution, Toast.LENGTH_SHORT).show();
                    solvedFirst = false;
                    sharedPreferences.edit().putBoolean("question1", false).apply();
                }

                Intent intent = new Intent(FirstQuestionActivity.this, SecondQuestionActivity.class);
                intent.putExtra("solvedFirst", solvedFirst);
                startActivity(intent);
            }
        });
    }
}
