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

        int[] qSet = new int[4];

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
                qSet[0] = 12;
                qSet[1] = 13;
                qSet[2] = 14;
                qSet[3] = 15;
                break;
            case 4:
                qSet[0] = 16;
                qSet[1] = 17;
                qSet[2] = 18;
                qSet[3] = 19;
                break;
            case 5:
                qSet[0] = 20;
                qSet[1] = 21;
                qSet[2] = 22;
                qSet[3] = 23;
                break;
            case 6:
                qSet[0] = 24;
                qSet[1] = 25;
                qSet[2] = 26;
                qSet[3] = 27;
                break;
            case 7:
                qSet[0] = 28;
                qSet[1] = 29;
                qSet[2] = 30;
                qSet[3] = 31;
                break;
            case 8:
                qSet[0] = 31;
                qSet[1] = 32;
                qSet[2] = 33;
                qSet[3] = 34;
                break;
            case 9:
                qSet[0] = 35;
                qSet[1] = 36;
                qSet[2] = 37;
                qSet[3] = 38;
                break;
        }

        return qSet;
    }
}
