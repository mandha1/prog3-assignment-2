package mandha1.bit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Results extends AppCompatActivity implements View.OnClickListener {

    private ImageView img;

    private TextView res;
    private TextView faq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Button nextQ = (Button) findViewById(R.id.nextQ);

        nextQ.setOnClickListener(this);

        loadResult();
    }

    public void onClick(View v) {

        if (v.getId() == R.id.nextQ) {
            Intent setNextQ = new Intent(Results.this, MainActivity.class);
            startActivity(setNextQ);
        }
    }

    public void loadResult() {

        //Image to be displayed that's relevant to current question
        img = (ImageView) findViewById(R.id.theImg);

        //Tells user if they got question right or wrong
        res = (TextView) findViewById(R.id.txtResult);

        //Some FAQ about the question
        faq = (TextView) findViewById(R.id.txtFAQ);

        Intent getRes = getIntent();
        int qNum = getRes.getIntExtra("qNum", -1);
        int outcome = getRes.getIntExtra("outcome", -1);

        if (outcome == 1) {

            res.setText("You got it right!");
        }
        else {

            res.setText("Oof, wrong answer.");
        }

        String theFAQ = "";

        switch (qNum) {
            case 0:
                img.setImageResource(R.drawable.carrot);
                theFAQ = "This is the celebrity carrot from Ohakune!\n" +
                        "It is approximately 7.5m tall and is made to represent\n" +
                        "the town's Growers Association.";
                break;
            case 1:
                img.setImageResource(R.drawable.trout);
                theFAQ = "Also another statue, this brown trout represents\n" +
                        "Gore as the brown trout capital.";
                break;
            case 2:
                img.setImageResource(R.drawable.toilet);
                theFAQ = "This austrian-born artist came to NZ in 1970\n" +
                        "and made this toilet out of recycled materials\n" +
                        "in Kawakawa.";
                break;
            case 3:
                img.setImageResource(R.drawable.landpaeroa);
                theFAQ = "This L&P bottle was originally a rocket made\n" +
                        "as a christmas promotion in 1967.";
                break;
            case 4:
                img.setImageResource(R.drawable.fruit);
                theFAQ = "Probably one of the most popular things in Cromwell,\n" +
                        "the giant stone fruits. The question one was a pear.";
                break;
            case 5:
                img.setImageResource(R.drawable.jersey);
                theFAQ = "The giant jersey from Geraldine weighs 5.5kg, 2m high\n" +
                        "and 5m from wrist to wrist. I think it doesn't hold the \n" +
                        "world record anymore.";
                break;
            case 6:
                img.setImageResource(R.drawable.bottles);
                theFAQ = "It took 20,000 bottles to make this bottle house.\n" +
                        "It is three-stories tall.";
                break;
            case 7:
                img.setImageResource(R.drawable.minions);
                theFAQ = "They're Minions made from hay.";
                break;
            case 8:
                img.setImageResource(R.drawable.kumara);
                theFAQ = "There's a farm in Dargaville somewhere\n" +
                        "that will teach you all things Kumara called\n" +
                        "The Kumara Box.";
                break;
            case 9:
                img.setImageResource(R.drawable.statue);
                theFAQ = "It's a statue of Richard's character, Riff Raff\n" +
                        "in the Rocky Horror Picture Show.";
                break;
        }

        faq.setText(theFAQ);
    }
}