package com.example.alexandru.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        Button buttonTeamA = (Button) findViewById(R.id.button_add_goal_team_a);
        Button buttonTeamB = (Button) findViewById(R.id.button_add_goal_team_b);
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
     * Displays the score in the TextBox
     *
     * @param teamNumber    1 is for team A, 2 is for team B
     * @param numberOfGoals the number of goals that will be displayed
     */
    public void displayScore(int teamNumber, int numberOfGoals) {
        if (teamNumber == 1) {
            TextView scoreTeamA = (TextView) findViewById(R.id.text_view_score_team_a);
            scoreTeamA.setText("Goals: " + numberOfGoals);
            return;
        }
        if (teamNumber == 2) {
            TextView scoreTeamB = (TextView) findViewById(R.id.text_view_score_team_b);
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
        Button buttonTeamA = (Button) findViewById(R.id.button_add_corner_team_a);
        Button buttonTeamB = (Button) findViewById(R.id.button_add_corner_team_b);
        if (buttonTeamA.isPressed()) {
            teamACorner++;
            displayCorner(1, teamACorner);
            return;
        }
        if (buttonTeamB.isPressed()) {
            teamBCorner++;
            displayCorner(2, teamBCorner);
            return;
        }
    }

    /**
     * @param teamNumber      1 is for team A, 2 is for team B
     * @param numberOfCorners the number of corners that will be displayed
     */
    public void displayCorner(int teamNumber, int numberOfCorners) {
        if (teamNumber == 1) {
            TextView scoreTeamA = (TextView) findViewById(R.id.text_view_corner_term_a);
            scoreTeamA.setText("Corners " + numberOfCorners);
            return;
        }
        if (teamNumber == 2) {
            TextView scoreTeamB = (TextView) findViewById(R.id.text_view_corner_term_b);
            scoreTeamB.setText("Corners " + numberOfCorners);
            return;
        }
    }

    /**
     * Adds a yellow card
     *
     * @param view
     */

    public void addYellowCard(View view) {
        Button buttonTeamA = (Button) findViewById(R.id.button_add_yellow_card_team_a);
        Button buttonTeamB = (Button) findViewById(R.id.button_add_yellow_card_team_b);
        if (buttonTeamA.isPressed()) {
            teamAYellowCards++;
            displayYellowCard(1, teamAYellowCards);
            return;
        }
        if (buttonTeamB.isPressed()) {
            teamBYellowCards++;
            displayYellowCard(2, teamBYellowCards);
            return;
        }

    }


    /**
     * @param teamNumber    1 is for team A, 2 is for team B
     * @param numberOfCards the number of cards that will be displayed
     */
    public void displayYellowCard(int teamNumber, int numberOfCards) {
        if (teamNumber == 1) {
            TextView yellowCards = (TextView) findViewById(R.id.text_view_yellow_cards_team_a);
            yellowCards.setText("Yellow cards: " + numberOfCards);
            return;
        }
        if (teamNumber == 2) {
            TextView yellowCards = (TextView) findViewById(R.id.text_view_yellow_cards_team_b);
            yellowCards.setText("Yellow cards: " + numberOfCards);
            return;
        }
    }


    /**
     * Adds a red card
     *
     * @param view
     */
    public void addRedCard(View view) {

        Button buttonTeamA = (Button) findViewById(R.id.button_add_red_card_team_a);
        Button buttonTeamB = (Button) findViewById(R.id.button_add_red_card_team_b);
        if (buttonTeamA.isPressed()) {
            teamARedCards++;
            displayRedCard(1, teamARedCards);
            return;
        }
        if (buttonTeamB.isPressed()) {
            teamBRedCards++;
            displayRedCard(2, teamBRedCards);
            return;
        }
    }

    /**
     * @param teamNumber    1 is for team A, 2 is for team B
     * @param numberOfCards the number of cards that will be displayed
     */

    public void displayRedCard(int teamNumber, int numberOfCards) {
        if (teamNumber == 1) {
            TextView redCards = (TextView) findViewById(R.id.text_view_red_cards_team_a);
            redCards.setText("Red cards:" + numberOfCards);
            return;
        }
        if (teamNumber == 2) {
            TextView redCards = (TextView) findViewById(R.id.text_view_red_cards_team_b);
            redCards.setText("Red cards:" + numberOfCards);
            return;
        }
    }
}
