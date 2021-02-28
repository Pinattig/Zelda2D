package com.zeros.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    private double x;
    private double y;
    private int width;
    private int height;

    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(double x) {
        this.x += x;
    }

    public void setY(double y) {
        this.y += y;
    }

    public void setWidth(int width) {
        this.width += width;
    }

    public void setHeight(int height) {
        this.height += height;
    }


    public void render(Graphics graphics, BufferedImage sprite){
        graphics.drawImage(sprite, (int)x, (int)y, null);
    }

    public void update(){

    }
}
