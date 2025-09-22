package org.baltimorecityschools.chessam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    int score;

    TextView saysSCORETV;

    TextView scoreNumberTV;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_score);
        score = 0;
        intent = getIntent();
        saysSCORETV = (TextView) findViewById(R.id.saysSCORE);
        scoreNumberTV = (TextView) findViewById(R.id.scoreTV);
        score = intent.getIntExtra("score", 0);
        scoreNumberTV .setText("You got" + score + "question(s) so far");

    }
}