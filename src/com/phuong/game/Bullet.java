package com.phuong.game;

import com.phuong.interf.Constant;

import java.awt.*;

public class Bullet implements Constant {
    Image image;
    int x,y;
    int orient;

    public Bullet(Image image, int x, int y, int orient) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.orient = orient;
    }
    void draw(Graphics2D g2d){
        g2d.drawImage(image,x,y,50,50,null);
    }

    boolean move(){
        x+=orient;
        return x<=0||x>=W_FRAME;
    }

    Rectangle getRect(){
        Rectangle rect=new Rectangle(
                x+5,y+5,50-10,50-10
        );
        return rect;
    }
}
