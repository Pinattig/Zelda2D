package com.zeros.main;

import com.zeros.entities.Entity;
import com.zeros.entities.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardPlayerInspector implements KeyListener {

    private Player entity;

    public KeyboardPlayerInspector(Player entity) {
       this.entity = entity;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            entity.setRight(true);
        }

        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
            entity.setLeft(true);

        else if(e.getKeyCode() == KeyEvent.VK_UP)
            entity.setUp(true);
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
            entity.setDown(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            entity.setRight(false);
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
            entity.setLeft(false);

        else if(e.getKeyCode() == KeyEvent.VK_UP)
            entity.setUp(false);
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
            entity.setDown(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
