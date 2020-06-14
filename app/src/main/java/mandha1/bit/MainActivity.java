package mandha1.bit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> questions = new ArrayList<String>();
    private String[][] answers = new String[10][4];

    int questionNum = 0;
    int score = 0;

    String ans = "";

    private Questions initQ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpAnswers();
        Button checkAns = (Button) findViewById(R.id.ansBtn);
        loadAnswers();
        checkAns.setOnClickListener(this);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.ansBtn) {
            loadAnswers();
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

                if (column != 4) {
                        answers[row][column] = newA;
                        column += 1;
                        System.out.println(answers[row][column]);
                }
                else {
                        column = 0;
                        row += 1;
                }
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAnswers() {

        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton rb4 = (RadioButton) findViewById(R.id.radioButton4);

        rb1.setText(answers[0][1]);
        rb2.setText(answers[0][2]);
        rb3.setText(answers[0][3]);
        rb4.setText(answers[0][4]);



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