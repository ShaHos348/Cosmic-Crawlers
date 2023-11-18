package com.example.cs2340a_team31.model.enemyFactoryPattern;

import com.example.cs2340a_team31.model.Player;

public class MiceEnemy extends Enemy {
    MiceEnemy(double w, double h, double difficulty, String direction) {
        setSize(1.5 * w, 1.5 * h);
        setMovementSpeed(w / 4);
        setDamage(difficulty * 5.0); // Scales the damage based on difficulty
        setHealth(0);
        setAlive(true);
        setType("mice");
        setDirection(direction);
    }

    @Override
    public void checkCollision(Player player) {
        super.checkCollision(player);
    }
}
