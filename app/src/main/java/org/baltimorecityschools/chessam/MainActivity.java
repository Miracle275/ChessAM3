package org.baltimorecityschools.chessam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button trueBTN;

    Button falseBTN;

    Button doneBTN;

    TextView qTV;

    int score;

    Question q1,q2,q3, q4, q5, q6, q7, q8, q9 ,q10, currentq;
    Question[] questions;
    int currentqnum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;

        trueBTN = (Button)  findViewById(R.id.trueBTN);

        falseBTN = (Button)  findViewById(R.id.falseBTN);

        doneBTN = (Button)   findViewById(R.id.DoneBTN);

        currentqnum = 0;

        qTV = (TextView) findViewById(R.id.qTV);

        q1 = new Question("The Queen is the most powerful piece in the board", true);

        q2 = new Question("The knight is the only piece that can jump over other pieces", true);

        q3 = new Question("Black always moves first", false);

        q4 = new Question("The king can be moved into check", false);

        q5 = new Question("A bishop can move backwards and forwards but not diagonally", false);

        q6 = new Question("A checkmate immediately ends the game", true);

        q7 = new Question("Checkmate is better than castling", true);

        q8 = new Question("There are more moves in chess than atoms in the universe", true);

        q9 = new Question("Early chess computers were made in the 1970s", true);

        q10 = new Question("The second book ever printed in English was about chess", true);

        questions = new Question[]{q1,q2,q3,q4,q5,q6,q7,q8,q9,q10};

        currentq = q1;
        doneBTN.setVisibility(View.INVISIBLE);



        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doneBTN.setVisibility(View.VISIBLE);
                trueBTN.setVisibility(View.INVISIBLE);
                falseBTN.setVisibility(View.INVISIBLE);
                if (currentq.getcorrectAns()==true) {
                    score++;
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Wrong" , Toast.LENGTH_LONG).show();
                }
            }
        });
        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doneBTN.setVisibility(View.VISIBLE);
                trueBTN.setVisibility(View.INVISIBLE);
                falseBTN.setVisibility(View.INVISIBLE);

                if (currentq.getcorrectAns()==false) {
                    score++;
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Wrong" , Toast.LENGTH_LONG).show();
                }
            }
        });
        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doneBTN.setVisibility(View.INVISIBLE);
                trueBTN.setVisibility(View.VISIBLE);
                falseBTN.setVisibility(View.VISIBLE);

                if (currentqnum >=9) {
                    Intent leaveIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    leaveIntent.putExtra("score", score);
                    startActivity(leaveIntent);
                }
                else {
                    currentqnum++;
                    currentq = questions[currentqnum];
                    qTV.setText(currentq.getqText());
                }
            }
        });

    }
}