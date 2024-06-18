package com.ipl.Ipl.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ipl_matches")
public class IplEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "season")
    private String season;
    @Column(name = "city")
    private String city;
    @Column(name = "team1")
    private String team1;
    @Column(name = "team2")
    private String team2;
    @Column(name = "date")
    private String date;
    @Column(name = "match_type")
    private String match_type;
    @Column(name = "target")
    private String target;
    @Column(name = "winner")
    private String winner;
    @Column(name = "result_margin")
    private String result_margin;
    @Column(name = "result")
    private String result;
    @Column(name = "player_of_match")
    private String player_of_match;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getResult_margin() {
        return result_margin;
    }

    public void setResult_margin(String result_margin) {
        this.result_margin = result_margin;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPlayer_of_match() {
        return player_of_match;
    }

    public void setPlayer_of_match(String player_of_match) {
        this.player_of_match = player_of_match;
    }

    public String getMatch_type() {
        return match_type;
    }

    public void setMatch_type(String match_type) {
        this.match_type = match_type;
    }
}
