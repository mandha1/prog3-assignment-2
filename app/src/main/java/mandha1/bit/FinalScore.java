package mandha1.bit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalScore extends AppCompatActivity implements View.OnClickListener {

    private TextView dispScore;
    private Button exitApp;

    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        dispScore = (TextView) findViewById(R.id.displayScore);

        exitApp = (Button) findViewById(R.id.exitApp);
        exitApp.setOnClickListener(this);

        Intent intent = getIntent();
        total = intent.getIntExtra("results", -1);
        dispScore.setText("You got a total of " + Integer.toString(total) + " out of 10 questions correct!");
    }

    public void onClick(View v) {

        if (v.getId() == R.id.exitApp) {
            System.exit(1);
        }
    }
}