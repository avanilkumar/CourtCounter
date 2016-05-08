package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String teamA = "Team A";
    private final String teamB = "Team B";
    private int teamAScore;
    private int teamBScore;

    public void updateScores(){
        ( (TextView) findViewById(R.id.teamA).findViewById(R.id.score)).setText(""+teamAScore);
        ( (TextView) findViewById(R.id.teamB).findViewById(R.id.score)).setText(""+teamBScore);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.teamA).findViewById(R.id.team)).setText(teamA);
        ((TextView) findViewById(R.id.teamB).findViewById(R.id.team)).setText(teamB);

        if(savedInstanceState==null){
            teamAScore = teamBScore = 0;
        }else{
            teamAScore = savedInstanceState.getInt(teamA);
            teamBScore = savedInstanceState.getInt(teamB);
        }

        updateScores();

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(teamA,teamAScore);
        outState.putInt(teamB,teamBScore);
    }

    public void freeThrow(View view) {

        if(((ViewGroup)view.getParent()).getId() == R.id.teamA){
            teamAScore++;
        }else{
            teamBScore++;
        }
        updateScores();
    }

    public void plusTwo(View view) {
        if(((ViewGroup)view.getParent()).getId() == R.id.teamA){
            teamAScore+=2;
        }else{
            teamBScore+=2;
        }
        updateScores();

    }

    public void plusThree(View view) {
        if(((ViewGroup)view.getParent()).getId() == R.id.teamA){
            teamAScore+=3;
        }else{
            teamBScore+=3;
        }
        updateScores();

    }

    public void Reset(View view) {
        teamAScore = teamBScore = 0;
        updateScores();
    }
}

