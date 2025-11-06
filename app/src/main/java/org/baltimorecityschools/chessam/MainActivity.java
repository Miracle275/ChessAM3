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

    Question q1,q2,q3,currentq;
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

        q1 = new Question("The Queen is the most powerful piece in the board?", true);

        q2 = new Question("The knight is the only piece that can jump over other pieces?", true);

        q3 = new Question("Black always moves first?", false);

        questions = new Question[]{q1,q2,q3};

        currentq = q1;



        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                if (currentqnum >=2) {
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