package ch.zli.whatsmyiq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        // set default firstSelection
        setDefault();

        Button button = findViewById(R.id.submitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioID = radioGroup.getCheckedRadioButtonId();

                RadioButton radioButton = findViewById(radioID);
                String option = radioButton.getText().toString();

                Intent intent = new Intent(MainActivity.this, FirstQuestionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setDefault() {
        radioGroup.check(R.id.firstSelection);
    }


}