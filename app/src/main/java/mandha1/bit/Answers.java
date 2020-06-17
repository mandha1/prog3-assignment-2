package mandha1.bit;

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
        switch(qNum) {
            case 0:

                break;
            case 1:
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

        return 0;
    }

    public String getAnswer(int index) {

        return theAnswers[index];
    }

}
