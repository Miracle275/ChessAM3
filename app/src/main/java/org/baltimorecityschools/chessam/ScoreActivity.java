package org.baltimorecityschools.chessam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    int score;

    TextView saysSCORETV;

    TextView scoreNumberTV;
    Intent intent;

   Button restartBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_score);
        score = 0;
        intent = getIntent();
        saysSCORETV = (TextView) findViewById(R.id.saysSCORE);
        scoreNumberTV = (TextView) findViewById(R.id.scoreTV);
        score = intent.getIntExtra("score", 0);
        scoreNumberTV .setText("You got a " + score + "/10 ");
        restartBTN = (Button) findViewById(R.id.restartBTN);

        restartBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  welcome = new Intent(ScoreActivity.this, WelcomeActivity.class);
                startActivity(welcome);
            }
        });

    }
    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}