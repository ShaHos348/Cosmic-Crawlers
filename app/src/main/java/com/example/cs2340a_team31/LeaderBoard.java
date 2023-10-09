package com.example.cs2340a_team31;
import java.util.Arrays;

public class LeaderBoard {
    private volatile static LeaderBoard leaderboard;

    private LeaderBoardPlayer[] players;
    private int playerSize;

    private LeaderBoard() {
        players = new LeaderBoardPlayer[10];
        this.playerSize = 0;
    }

    public static LeaderBoard getleaderboard() {
        if (leaderboard == null) {
            synchronized (LeaderBoard.class) {
                if (leaderboard == null) {
                    leaderboard = new LeaderBoard();
                }
            }
        }
        return leaderboard;
    }

    public void add(LeaderBoardPlayer player) {
        if (this.playerSize + 1 >= players.length) { //over flow
            LeaderBoardPlayer[] temp = new LeaderBoardPlayer[this.players.length * 2];
            for (int i =0 ; i < this.players.length; i++) {
                temp [i] = players[i];
            }
            players = temp;
        }
        players[this.playerSize] = player;
        this.playerSize++;
    }



}
