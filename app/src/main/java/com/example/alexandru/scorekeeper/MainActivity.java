package com.example.alexandru.scorekeeper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FootBallGame teamA;
    FootBallGame teamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamA = new FootBallGame();
        teamB = new FootBallGame();
    }

    public void submitReport(View view) {
        String subject = getString(R.string.email_subject_text);
        String text = createReport(teamA, teamB);
        sendEmail(subject, text);
    }

    /**
     * @param teamALocal
     * @param teamBLocal
     * @return the report in text form
     */
    private String createReport(FootBallGame teamALocal, FootBallGame teamBLocal) {
        String report = getString(R.string.team_name_word) + getString(R.string.team_a_name)
                + "\n" + getString(R.string.goals_word) + teamALocal.getTeamGoals()
                + "\n" + getString(R.string.corners_word) + teamALocal.getTeamCorners()
                + "\n" + getString(R.string.yellow_cards_word) + teamALocal.getTeamYellowCards()
                + "\n" + getString(R.string.red_cards_word) + teamALocal.getTeamRedCards()
                + "\n\n" + getString(R.string.team_name_word) + getString(R.string.team_b_name)
                + "\n" + getString(R.string.goals_word) + teamBLocal.getTeamGoals()
                + "\n" + getString(R.string.corners_word) + teamBLocal.getTeamCorners()
                + "\n" + getString(R.string.yellow_cards_word) + teamBLocal.getTeamYellowCards()
                + "\n" + getString(R.string.red_cards_word) + teamBLocal.getTeamRedCards();
        return report;
    }

    /**
     * @param subject the subject of the mail
     * @param text    the text of the mail
     */
    private void sendEmail(String subject, String text) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Reset all the globals variables
     *
     * @param view
     */
    public void reset(View view) {
        teamA = new FootBallGame();
        teamB = new FootBallGame();
    }

    /**
     * Adds a goal to the score
     */
    public void addGoal(View view) {

        Button buttonTeamA = (Button) findViewById(R.id.button_add_goal_team_a);
        Button buttonTeamB = (Button) findViewById(R.id.button_add_goal_team_b);
        if (buttonTeamA.isPressed()) {
            int goals = teamA.getTeamGoals();
            goals++;
            teamA.setTeamGoals(goals);
            displayScore(1, teamA.getTeamGoals());
        }
        if (buttonTeamB.isPressed()) {
            int goals = teamB.getTeamGoals();
            goals++;
            teamB.setTeamGoals(goals);
            displayScore(2, teamB.getTeamGoals());
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
        }
        if (teamNumber == 2) {
            TextView scoreTeamB = (TextView) findViewById(R.id.text_view_score_team_b);
            scoreTeamB.setText("Goals: " + numberOfGoals);
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
            int corners = teamA.getTeamCorners();
            corners++;
            teamA.setTeamCorners(corners);
            displayCorner(1, teamA.getTeamCorners());
        }
        if (buttonTeamB.isPressed()) {
            int corners = teamB.getTeamCorners();
            corners++;
            teamB.setTeamCorners(corners);
            displayCorner(2, teamB.getTeamCorners());
        }
    }

    /**
     * @param teamNumber      1 is for team A, 2 is for team B
     * @param numberOfCorners the number of corners that will be displayed
     */
    public void displayCorner(int teamNumber, int numberOfCorners) {
        if (teamNumber == 1) {
            TextView scoreTeamA = (TextView) findViewById(R.id.text_view_corner_term_a);
            scoreTeamA.setText("Corners: " + numberOfCorners);
        }
        if (teamNumber == 2) {
            TextView scoreTeamB = (TextView) findViewById(R.id.text_view_corner_term_b);
            scoreTeamB.setText("Corners: " + numberOfCorners);
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
            int yellowCards = teamA.getTeamYellowCards();
            yellowCards++;
            teamA.setTeamYellowCards(yellowCards);
            displayYellowCard(1, teamA.getTeamYellowCards());
        }
        if (buttonTeamB.isPressed()) {
            int yellowCards = teamB.getTeamYellowCards();
            yellowCards++;
            teamB.setTeamYellowCards(yellowCards);
            displayYellowCard(2, teamB.getTeamYellowCards());
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
        }
        if (teamNumber == 2) {
            TextView yellowCards = (TextView) findViewById(R.id.text_view_yellow_cards_team_b);
            yellowCards.setText("Yellow cards: " + numberOfCards);
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
            int redCards = teamA.getTeamRedCards();
            redCards++;
            teamA.setTeamRedCards(redCards);
            displayRedCard(1, teamA.getTeamRedCards());
        }
        if (buttonTeamB.isPressed()) {
            int redCards = teamB.getTeamRedCards();
            redCards++;
            teamB.setTeamRedCards(redCards);
            displayRedCard(2, teamB.getTeamRedCards());
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
        }
        if (teamNumber == 2) {
            TextView redCards = (TextView) findViewById(R.id.text_view_red_cards_team_b);
            redCards.setText("Red cards:" + numberOfCards);
        }
    }
}
