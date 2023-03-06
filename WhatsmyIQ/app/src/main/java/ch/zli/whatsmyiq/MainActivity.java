package ch.zli.whatsmyiq;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView appIcon;

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appIcon = findViewById(R.id.app_icon);
        appIcon.setImageDrawable(getAppIcon());

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

                SharedPreferences sharedPreferences = getSharedPreferences("database", MODE_PRIVATE);
                sharedPreferences.edit().putString("age", option).apply();

                Intent intent = new Intent(MainActivity.this, FirstQuestionActivity.class);
                startActivity(intent);
            }
        });
    }

    private Drawable getAppIcon() {
        try {
            return getPackageManager().getApplicationIcon(getPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setDefault() {
        radioGroup.check(R.id.firstSelection);
    }


}