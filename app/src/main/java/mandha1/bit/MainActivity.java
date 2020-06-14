package mandha1.bit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> theQuestions = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void SetUpQuestions() {

        try {

            String questions = "questions.txt";
            AssetManager am = getAssets();
            InputStream is = am.open(questions);
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(ir);

            String newQuestion;
            while ((newQuestion = br.readLine()) != null) {
                theQuestions.add(newQuestion);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        br.close();
    }

    private void ShowQuestions() {

    }
}