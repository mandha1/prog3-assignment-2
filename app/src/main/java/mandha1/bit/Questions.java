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

    public int[] getQSet(int qNum) {

        int[] qSet = new int[3];

        switch (qNum) {
            case 0:
                //answers to choose from
                qSet[0] = 0;
                qSet[1] = 1;
                qSet[2] = 2;
                qSet[3] = 3;
                break;
            case 1:
                qSet[0] = 4;
                qSet[1] = 5;
                qSet[2] = 6;
                qSet[3] = 7;
                break;
            case 2:
                qSet[0] = 8;
                qSet[1] = 9;
                qSet[2] = 10;
                qSet[3] = 11;
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

        return qSet;
    }
}
