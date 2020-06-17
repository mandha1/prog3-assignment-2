package mandha1.bit;

import android.content.Intent;

import java.util.ArrayList;

public class Answers {

    private String[] theAnswers;
    private ArrayList<String> ans;

    public Answers(ArrayList<String> ans) {

        int[] ansNum = { 1, 6, 10, 15, 20, 22, 25, 32, 35, 39 };

        theAnswers = new String[10];
        this.ans = ans;

        for (int i = 0; i < theAnswers.length; i++) {

            theAnswers[i] = ans.get(ansNum[i]);
        }
    }

    public int CheckAnswer(int qNum, String userAns) {

        String realAns = theAnswers[qNum];

        if (userAns.equalsIgnoreCase(realAns)) {
            return 1;
        }

        return 0;
    }

    public String getAnswer(int index) {

        return theAnswers[index];
    }

}
