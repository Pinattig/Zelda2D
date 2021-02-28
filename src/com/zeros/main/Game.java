package com.zeros.main;

import com.zeros.entities.Entity;
import com.zeros.entities.Player;
import com.zeros.graphics.Spritesheet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ResourceBundle;

public class Game extends Canvas implements Runnable {

    private boolean isRunning;

    private static final int WIDTH = 240;
    private static final int HEIGHT = 120;
    private static final int SCALE = 3;

    private final int gameWidth = WIDTH*SCALE;
    private final int gameHeight = HEIGHT*SCALE;

    private BufferedImage layer;
    private List<Entity> entities;
    private Spritesheet spritesheet;

    private Player player;
    private KeyboardPlayerInspector playerInspector;

    public Game() throws IOException {
        this.setPreferredSize(new Dimension(gameWidth, gameHeight));
        layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        spritesheet = new Spritesheet("/spritesheet-player.png");
        entities = new ArrayList<Entity>();

        player = new Player(0,0,16,20);
        playerInspector = new KeyboardPlayerInspector(player);
        setFocusable(true);
        addKeyListener(playerInspector);


        entities.add(player);

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

        for (Entity entity : entities) {
            if(entity instanceof Player){
                ((Player) entity).render(graphics);
            }

        }

        graphics = bs.getDrawGraphics();
        graphics.drawImage(layer, 0,0 , gameWidth, gameHeight, null);
        bs.show();
    }
    private void update() {
        for (Entity entity : entities) {
            entity.update();
        }
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

    public static void main(String[] args) throws IOException {
        new Game().start();
    }


}
