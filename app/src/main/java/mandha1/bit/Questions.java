package mandha1.bit;

import android.content.res.AssetManager;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Questions {

    private ArrayList<String> questions;

    public Questions() {

        questions = new ArrayList<String>();
    }



    public ArrayList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }
}
