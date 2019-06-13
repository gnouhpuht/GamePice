package com.phuong.game;

import com.phuong.interf.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements Constant {
    GameManager gameManager=new GameManager();
    boolean[] flag = new boolean[256];
    public MyPanel() {
        setSize(W_FRAME, H_FRAME);
//        setBackground(Color.black);
        gameManager.initGame();
        setFocusable(true);
        addKeyListener(key);

        Thread thread = new Thread(run);
        thread.start();

    }

    KeyListener key=new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            flag[e.getKeyCode()]=true;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            flag[e.getKeyCode()]=false;
        }
    };

    Runnable run = new Runnable() {
        @Override
        public void run() {
            while (true) {
                if (flag[KeyEvent.VK_UP]==true){
                    gameManager.player.orient=UP;
                }else {
                    gameManager.player.orient=DOWN;
                }
                if (flag[KeyEvent.VK_SPACE]==true){
                    gameManager.player.fire(gameManager.arrBulletPlayer);
                }
                gameManager.AI();
                repaint();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d=(Graphics2D)g;
        super.paintComponent(g2d);
        gameManager.draw(g2d);

    }
}
