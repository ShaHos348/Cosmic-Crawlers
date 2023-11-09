package com.example.cs2340a_team31.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340a_team31.R;
import java.util.LinkedList;

import com.example.cs2340a_team31.model.*;
public class GameEndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_screen);

        TextView[] textViews = new TextView[5];

        textViews[0] = findViewById(R.id.leaderBoard1);
        textViews[1] = findViewById(R.id.leaderBoard2);
        textViews[2] = findViewById(R.id.leaderBoard3);
        textViews[3] = findViewById(R.id.leaderBoard4);
        textViews[4] = findViewById(R.id.leaderBoard5);


        //singletons
        Player player = Player.getPlayer();

        LeaderBoard leaderBoard = LeaderBoard.getleaderboard();

        //creating new LeaderBoardplayer
        LeaderBoardPlayer lbPlayer = new LeaderBoardPlayer(player.getName(),
                player.getDateTime(), player.getScore());

        LinkedList<LeaderBoardPlayer> players = LeaderBoard.getleaderboard().getPlayers();

// Check if the player already exists in the leaderboard
        boolean playerExists = false;
        for (LeaderBoardPlayer existingPlayer : players) {
            if (existingPlayer.getName().equals(lbPlayer.getName()) && existingPlayer.getScore() == lbPlayer.getScore()) {
                playerExists = true;
                break;
            }
        }

// If the player doesn't exist, add them to the leaderboard
        if (!playerExists) {
            leaderBoard.add(lbPlayer);
        }


        //adding current game to the current textview
        TextView currentScore = findViewById(R.id.currentScore);
        currentScore.setText("Current: " + "Name:" + lbPlayer.getName() + ", "
                                         + "Time:" + lbPlayer.getDateTime() + ", "
                                         + "Score:" + lbPlayer.getScore());


        //populating the play game data into textviews
        for (int i = 0; i < leaderBoard.getPlayerSize(); i++) {
            lbPlayer = players.get(i);
            textViews[i].setText((i  + 1) + ") " + "Name:" + lbPlayer.getName() + ", "
                    + "Time:" + lbPlayer.getDateTime() + ", "
                    + "Score:" + lbPlayer.getScore());
        }

        Button restartButton = findViewById(R.id.restartBtn);
        restartButton.setOnClickListener(v -> {
            Intent intent = new Intent(GameEndActivity.this, GameStartActivity.class);
            startActivity(intent);
            finish();
        });
    }


}


