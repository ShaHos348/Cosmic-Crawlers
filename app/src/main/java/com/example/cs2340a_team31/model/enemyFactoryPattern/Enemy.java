package com.example.cs2340a_team31.model.enemyFactoryPattern;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.cs2340a_team31.model.Player;
import com.example.cs2340a_team31.model.observers.EnemyObserver;

public abstract class Enemy implements EnemyObserver {

    double movementSpeed;

    String type;

    String direction;
    double damage;
    Drawable sprite;
    double health;

    boolean alive;

    double x;
    double y;

    double width;
    double height;

    void move() {
        if (!alive) {
            return;
        }
        // TODO: Thomas - remove this
        switch (direction) {
            case "UP":
                this.y -= movementSpeed;
                break;
            case "DOWN":
                this.y += movementSpeed;
                break;
            case "RIGHT":
                this.x += movementSpeed;
                break;
            case "LEFT":
                this.x -= movementSpeed;
                break;
        }
    }

    @Override
    public void checkCollision(Player player) {
        // TODO: Tran - Implement enemy collision
        // Simply use the checkWallCollision method in GameViewModel and change up the variables
        if (false) { // playerBounds.intersect(enemyBounds)
            player.notifyCollision(damage);
        }
    }

    void setSize(double w, double h) {
        width = w;
        height = h;
    }

    void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void kill() {
        this.alive = false;
    }

    boolean isAlive() {
        return alive;
    }

    public String getType() {
        return type;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDamage() {
        return damage;
    }
}

