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

public class ThirdQuestionActivity extends AppCompatActivity {
    private TextView title;
    private TextView question;
    private EditText input;
    private Button submitButton;
    private boolean solvedThird = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);

        title = findViewById(R.id.title);
        question = findViewById(R.id.question4);
        input = findViewById(R.id.input3);
        submitButton = findViewById(R.id.submitButton4);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = input.getText().toString().trim();
                String solution = "Sonntag";

                SharedPreferences sharedPreferences = getSharedPreferences("database", MODE_PRIVATE);


                if (userInput.equals(solution)) {
                    Toast.makeText(ThirdQuestionActivity.this, "Input: " + userInput + ", is true", Toast.LENGTH_SHORT).show();
                    solvedThird = true;
                    sharedPreferences.edit().putBoolean("question3", true).apply();
                } else {
                    Toast.makeText(ThirdQuestionActivity.this, "Wrong, the solution is: :" + solution, Toast.LENGTH_SHORT).show();
                    solvedThird = false;
                    sharedPreferences.edit().putBoolean("question3", false).apply();
                }
                Intent intent = new Intent(ThirdQuestionActivity.this, FourthQuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}