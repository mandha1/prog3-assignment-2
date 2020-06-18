package mandha1.bit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.media.Image;
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

    private RadioButton[] radBtns = new RadioButton[4];

    private RadioGroup ansGroup;
    private RadioButton selectedBtn;

    int questionNum = 0;
    int score = 0;

    private int[] imgs = new int[10];
    private ImageView qImg;

    String userAns = "";

    private Questions qs;

    private Answers rawAns;

    int iterate = 0;

    protected void onCreate(Bundle savedInstanceState) {
        loadImages();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ansGroup = (RadioGroup) findViewById(R.id.ansGroup);

        radBtns[0] = (RadioButton) findViewById(R.id.radioButton1);
        radBtns[1] = (RadioButton) findViewById(R.id.radioButton2);
        radBtns[2] = (RadioButton) findViewById(R.id.radioButton3);
        radBtns[3] = (RadioButton) findViewById(R.id.radioButton4);

        setUpQuestions();
        setUpAnswers();

        rawAns = new Answers(answers);

        qs = new Questions(questions, answers);

        Button checkAns = (Button) findViewById(R.id.ansBtn);

        checkAns.setOnClickListener(this);
        System.out.println(questionNum);
        loadQuestion();
    }

    public void loadImages() {
        imgs[0] = R.drawable.carrot;
        imgs[1] = R.drawable.trout;
        imgs[2] = R.drawable.toilet;
        imgs[3] = R.drawable.landpaeroa;
        imgs[4] = R.drawable.fruit;
        imgs[5] = R.drawable.jersey;
        imgs[6] = R.drawable.bottles;
        imgs[7] = R.drawable.minions;
        imgs[8] = R.drawable.kumara;
        imgs[9] = R.drawable.statue;
    }

    public void onClick(View v) {

        if (v.getId() == R.id.ansBtn) {

            int selectedID = ansGroup.getCheckedRadioButtonId();
            selectedBtn = (RadioButton) findViewById(selectedID);
            userAns = selectedBtn.getText().toString();

            if (userAns == "") {
                Toast.makeText(this, "You haven't put an answer yet.", Toast.LENGTH_LONG).show();
            }

            else {

                Intent giveRes = new Intent(MainActivity.this, Results.class);

                //If the user gets the answer right
                if (rawAns.CheckAnswer(questionNum, userAns) == 1) {

                    giveRes.putExtra("outcome", 1);
                    score += 1;
                }
                else {
                    giveRes.putExtra("outcome", 0);
                }

                giveRes.putExtra("qNum", questionNum);
                startActivity(giveRes);
            }

            //loadQuestion();


        }

        if (questionNum > 9) {
            Intent finalRes = new Intent(this, FinalScore.class);
            finalRes.putExtra("results", this.score);
            startActivity(finalRes);
        }
    }



    public void loadQuestion() {

//        Intent nextQu = getIntent();
//        int iterate = nextQu.getIntExtra("iterateQ", -1);
//        questionNum = iterate;

        questionNum += 1;
        int[] currQSet = new int[4];
        TextView que = (TextView) findViewById(R.id.qsTxtView);
        qImg = (ImageView) findViewById(R.id.imageView);

        ansGroup.clearCheck();

        currQSet = qs.getQSet(questionNum);

        qImg.setImageResource(imgs[questionNum]);

        que.setText(questions.get(questionNum));

        for (int i = 0; i < radBtns.length; i++) {
            radBtns[i].setText(answers.get(currQSet[i]));
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
}