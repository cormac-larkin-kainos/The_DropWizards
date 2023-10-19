package org.kainos.ea.cli;

public class Team {

    private int teamId;
    private String teamType;

    public Team(int teamId, String teamType) {
        this.teamId = teamId;
        this.teamType = teamType;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }
}
