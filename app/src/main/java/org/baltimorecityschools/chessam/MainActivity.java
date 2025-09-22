package org.baltimorecityschools.chessam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;

        trueBTN = (Button)  findViewById(R.id.trueBTN);

        falseBTN = (Button)  findViewById(R.id.falseBTN);

        doneBTN = (Button)   findViewById(R.id.DoneBTN);

        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                Toast.makeText(MainActivity.this, "Correct" , Toast.LENGTH_LONG).show();

            }
        });
        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Wrong" , Toast.LENGTH_LONG).show();
            }
        });
        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leaveIntent = new Intent(MainActivity.this, ScoreActivity.class);
                leaveIntent.putExtra("score", score);
                startActivity(leaveIntent);
            }
        });

    }
}