package mandha1.bit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> questions = new ArrayList<String>();
    private ArrayList<String> answers = new ArrayList<String>();

    private RadioGroup ansGroup;
    private RadioButton selectedBtn;

    int questionNum = 0;
    int score = 0;

    String userAns = "";

    private Questions initQ;
    private Answers rawAns;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ansGroup = (RadioGroup) findViewById(R.id.ansGroup);

        setUpQuestions();
        setUpAnswers();

        rawAns = new Answers(answers);

        Button checkAns = (Button) findViewById(R.id.ansBtn);
        loadQuestion();
        checkAns.setOnClickListener(this);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.ansBtn) {

            if (userAns == "") {
                Toast.makeText(this, "You haven't put an answer yet.", Toast.LENGTH_LONG).show();
            }

            else {

                int selectedID = ansGroup.getCheckedRadioButtonId();
                selectedBtn = (RadioButton) findViewById(selectedID);

                userAns = selectedBtn.getText().toString();
                rawAns.CheckAnswer(questionNum, userAns);
            }
        }

        if (questionNum > 9) {
            Intent intent = new Intent(this, FinalScore.class);
            intent.putExtra("results", this.score);
            startActivity(intent);
        }
    }

    public void setUpAnswers() {

        try {
            AssetManager am = getAssets();
            InputStream is = am.open("answers.txt");
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(ir);

            String newA = "";
            int row = 0;
            int column = 0;

            while ((newA = br.readLine()) != null) {

                answers.add(newA);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadQuestion() {

        TextView que = (TextView) findViewById(R.id.qsTxtView);

        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton rb4 = (RadioButton) findViewById(R.id.radioButton4);

        switch(questionNum) {
            case 0:
                que.setText(questions.get(0));

                rb1.setText(answers.get(0));
                rb2.setText(answers.get(1));
                rb3.setText(answers.get(2));
                rb4.setText(answers.get(3));
                break;
            case 1:
                que.setText(questions.get(1));

                rb1.setText(answers.get(4));
                rb2.setText(answers.get(5));
                rb3.setText(answers.get(6));
                rb4.setText(answers.get(7));
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            default:
                break;
        }


    }

    private void setUpQuestions() {

        try {
            AssetManager am = getAssets();
            InputStream is = am.open("questions.txt");
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(ir);

            String newQ = "";

            while ((newQ = br.readLine()) != null) {
                questions.add(newQ);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ShowQuestions() {

    }
}