package com.zeros.entities;

import com.zeros.graphics.PlayerSprites;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Locale;

public class Player extends Entity{

    private boolean up,down,left,right;
    private final double speed = 0.03;


    private int lastedSpriteWalkToUp;
    private int lastedSpriteWalkToDown;
    private int lastedSpriteWalkToLeft;
    private int lastedSpriteWalkToRight;
    private String lastedDirectionToWalk;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        lastedDirectionToWalk = "";
    }

    @Override
    public void update(){
        if(up)
            super.setY(-speed);
        else if(down)
            super.setY(speed);

        else if(right)
            super.setX(speed);
        else if(left)
            super.setX(-speed);
    }

    public void render(Graphics graphics){
        if(up)
            super.render(graphics, getWalkToUp());
        else if(down)
            super.render(graphics, getWalkToUp());
        else if(right)
            super.render(graphics, getWalkToRight());
        else if(left)
            super.render(graphics, getWalkToRight());
        else
            super.render(graphics, getLastDirectionWalk());
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    private BufferedImage getWalkToUp(){
        lastedDirectionToWalk = "up";
        if(lastedSpriteWalkToUp == 0){
            lastedSpriteWalkToUp = 1;
            return PlayerSprites.walkLeftToFront;
        }

        else if(lastedSpriteWalkToUp == 1){
            lastedSpriteWalkToUp = 0;
            return PlayerSprites.walkRightToFront;
        }

        return PlayerSprites.standingInFront;
    }

    private BufferedImage getWalkToRight(){
        lastedDirectionToWalk = "right";
        if(lastedSpriteWalkToRight == 0){
            lastedSpriteWalkToRight = 1;
            return PlayerSprites.walkRightToLeft;
        }

        else if(lastedSpriteWalkToUp == 1){
            lastedSpriteWalkToRight = 0;
            return PlayerSprites.walkLeftToLeft;
        }

        return PlayerSprites.standingInLeft;
    }

    private BufferedImage getLastDirectionWalk(){
        switch (lastedDirectionToWalk.toLowerCase(Locale.ROOT)){
            case "right" : return PlayerSprites.standingInLeft;
            default: return PlayerSprites.standingInFront;
        }
    }
}
