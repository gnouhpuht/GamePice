package com.phuong.game;

import com.phuong.interf.Constant;

import java.awt.*;

public class BackGroud implements Constant {
    Image image=ImageLoader.getImage("PlayBackground1.png");
    int x;

    void draw(Graphics2D g2d){
        x--;
        if (x<=-W_FRAME){
            x=0;
        }
        g2d.drawImage(image,x,0,W_FRAME,H_FRAME,null);
        g2d.drawImage(image,x+W_FRAME-5,0,W_FRAME,H_FRAME,null);
    }
}
