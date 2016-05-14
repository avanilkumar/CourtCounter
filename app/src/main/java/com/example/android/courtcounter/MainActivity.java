package com.example.android.courtcounter;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private final String teamA = "Team A";
    private final String teamB = "Team B";
    private int teamAScore;
    private int teamBScore;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void updateScores() {
        ((TextView) findViewById(R.id.teamA).findViewById(R.id.score)).setText("" + teamAScore);
        ((TextView) findViewById(R.id.teamB).findViewById(R.id.score)).setText("" + teamBScore);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.app_bar));
        //setActionBar((Toolbar)findViewById(R.id.app_bar));
         ((Toolbar) findViewById(R.id.app_bar)).showOverflowMenu();

        ((TextView) findViewById(R.id.teamA).findViewById(R.id.team)).setText(teamA);
        ((TextView) findViewById(R.id.teamB).findViewById(R.id.team)).setText(teamB);

        if (savedInstanceState == null) {
            teamAScore = teamBScore = 0;
        } else {
            teamAScore = savedInstanceState.getInt(teamA);
            teamBScore = savedInstanceState.getInt(teamB);
        }
        updateScores();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(teamA, teamAScore);
        outState.putInt(teamB, teamBScore);
    }

    public void freeThrow(View view) {

        if (((ViewGroup) view.getParent()).getId() == R.id.teamA) {
            teamAScore++;
        } else {
            teamBScore++;
        }
        updateScores();
    }

    public void plusTwo(View view) {
        if (((ViewGroup) view.getParent()).getId() == R.id.teamA) {
            teamAScore += 2;
        } else {
            teamBScore += 2;
        }
        updateScores();

    }

    public void plusThree(View view) {
        if (((ViewGroup) view.getParent()).getId() == R.id.teamA) {
            teamAScore += 3;
        } else {
            teamBScore += 3;
        }
        updateScores();

    }

    public void Reset(View view) {
        teamAScore = teamBScore = 0;
        updateScores();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.android.courtcounter/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.android.courtcounter/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

