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
    private ArrayList<String> answers;

    public Questions(ArrayList<String> questions, ArrayList<String> answers) {

        this.questions = questions;
        this.answers = answers;
    }

}
