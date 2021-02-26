package com.zeros.main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    private boolean isRunning;

    private static final int WIDTH = 240;
    private static final int HEIGHT = 120;
    private static final int SCALE = 3;

    private final int gameWidth = WIDTH*SCALE;
    private final int gameHeight = HEIGHT*SCALE;

    private BufferedImage layer;


    public Game(){
        this.setPreferredSize(new Dimension(gameWidth, gameHeight));
        layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        initializeFrame();
    }


    private void initializeFrame(){
        JFrame frame = new JFrame("Zelda 2D");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics graphics = layer.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0, gameWidth, gameHeight);

        graphics = bs.getDrawGraphics();
        graphics.drawImage(layer, 0,0 , gameWidth, gameHeight, null);
        bs.show();
    }
    private void update() {
    }

    private synchronized void start(){
        isRunning = true;
        new Thread(this).start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double ns = 1000000000 / 60.0;
        double delta = 0;

        while (isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            now = lastTime;
            if(delta > 1){
                update();
                render();
                delta = 0;
            }
        }
    }

    public static void main(String[] args) {
        new Game().start();
    }


}
