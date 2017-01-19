package com.example.alexandru.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamAScore = 0;
    int teamACorner = 0;
    int teamAYellowCards = 0;
    int teamARedCards = 0;
    int teamBScore = 0;
    int teamBCorner = 0;
    int teamBYellowCards = 0;
    int teamBRedCards = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Reset all the globals variables
     *
     * @param view
     */

    public void reset(View view) {
        teamBScore = teamAScore = 0;
        teamBCorner = teamACorner = 0;
        teamBRedCards = teamARedCards = 0;
        teamAYellowCards = teamBYellowCards = 0;
    }


    /**
     * Adds a goal to the score
     */
    public void addGoal(View view) {

        Button buttonTeamA = (Button) findViewById(R.id.id_button_add_goal_team_a);
        Button buttonTeamB = (Button) findViewById(R.id.id_button_add_goal_team_b);
        if (buttonTeamA.isPressed()) {
            teamAScore++;
            displayScore(1, teamAScore);
            return;
        }
        if (buttonTeamB.isPressed()) {
            teamBScore++;
            displayScore(2, teamBScore);
            return;
        }
    }

    /**
     * @param teamNumber    1 is for team A, 2 is for team B
     * @param numberOfGoals the number of goals that will be displayed
     */
    public void displayScore(int teamNumber, int numberOfGoals) {
        if (teamNumber == 1) {
            TextView scoreTeamA = (TextView) findViewById(R.id.id_score_team_a);
            scoreTeamA.setText("Goals: " + numberOfGoals);
            return;
        }
        if (teamNumber == 2) {
            TextView scoreTeamB = (TextView) findViewById(R.id.id_score_team_b);
            scoreTeamB.setText("Goals: " + numberOfGoals);
            return;
        }
    }


    /**
     * Adds a corner kick
     *
     * @param view
     */
    public void addCorner(View view) {
        teamACorner++;
    }

    public void addYellowCard(View view) {
        teamAYellowCards++;
    }

    public void addRedCard(View view) {
        teamARedCards++;
    }
}
