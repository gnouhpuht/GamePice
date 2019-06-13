package com.phuong.game;

import com.phuong.interf.Constant;
import sun.plugin.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;

public class Player implements Constant {
    int orient=DOWN;
    Image[] images = {
            ImageLoader.getImage("SanjiDown.png"),
            ImageLoader.getImage("SanjiUp.png")
    };

    int x,y,score;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void draw(Graphics2D g2d){
        g2d.drawImage(images[orient],x,y,150,150,null);
    }

    void move(){
        int yR=y;
        switch (orient){
            case DOWN:
                y+=3;
                break;
            case UP:
//                SoundManager.play("Move.wav");
                y-=3;
                break;
        }
        if (y<=0||y>=BOUND-images[orient].getHeight(null)){
            y=yR;
        }
    }

    long t;
    void fire(ArrayList<Bullet> arr){
        long T=System.currentTimeMillis();
        if (T-t<500){
            return;
        }
        t=T;
        int xB=x+images[orient].getWidth(null);
        int yB=y+images[orient].getHeight(null)/2;
        Bullet bullet=new Bullet(ImageLoader.getImage("ZoroBullet.png"),xB,yB,1);
        arr.add(bullet);
        SoundManager.play("LuffyBulletSound.wav");
    }

    Rectangle getRect(){
        Rectangle rect=new Rectangle(
                x+5,y+5,150-15,150-15
        );
        return rect;
    }

    boolean checkDie(ArrayList<Bullet> arrBulletBoss,ArrayList<Boss> arrBoss){
        for (Bullet b:arrBulletBoss) {
           Rectangle rect=getRect().intersection(b.getRect());
           if (rect.isEmpty()==false){
               return true;
           }
        }
        for (Boss b:arrBoss) {
            Rectangle rect=getRect().intersection(b.getRect());
            if (rect.isEmpty()==false){
                return true;
            }
        }
        return false;
    }
}
