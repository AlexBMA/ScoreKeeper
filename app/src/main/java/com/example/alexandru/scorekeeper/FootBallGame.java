package com.example.alexandru.scorekeeper;

/**
 * Created by Alexandru on 1/19/2017.
 */

public class FootBallGame {

    private int teamGoals;
    private int teamCorners;
    private int teamYelloCards;
    private int teamRedCards;

    public FootBallGame() {
        teamGoals = 0;
        teamCorners = 0;
        teamRedCards = 0;
        teamYelloCards = 0;
    }

    public int getTeamGoals() {
        return teamGoals;
    }

    public void setTeamGoals(int teamGoals) {
        this.teamGoals = teamGoals;
    }

    public int getTeamCorners() {
        return teamCorners;
    }

    public void setTeamCorners(int teamCorners) {
        this.teamCorners = teamCorners;
    }

    public int getTeamYelloCards() {
        return teamYelloCards;
    }

    public void setTeamYelloCards(int teamYelloCards) {
        this.teamYelloCards = teamYelloCards;
    }

    public int getTeamRedCards() {
        return teamRedCards;
    }

    public void setTeamRedCards(int teamRedCards) {
        this.teamRedCards = teamRedCards;
    }
}
