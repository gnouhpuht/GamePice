package com.phuong.game;

import com.phuong.interf.Constant;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Boss implements Constant {
    Image[] images;
    int x,y;
    int index;
    int speed;

    public Boss() {
        Random rd=new Random();
        speed=rd.nextInt(3)+1;
        int type=rd.nextInt(4);
        x=W_FRAME;

        if (type==0){
            images=new Image[]{
                    ImageLoader.getImage("Monster1_1.png"),
                    ImageLoader.getImage("Monster1_2.png"),
                    ImageLoader.getImage("Monster1_3.png"),
                    ImageLoader.getImage("Monster1_4.png"),
                    ImageLoader.getImage("Monster1_5.png"),
                    ImageLoader.getImage("Monster1_6.png"),
                    ImageLoader.getImage("Monster1_7.png"),
                    ImageLoader.getImage("Monster1_8.png"),

            };
        }else if (type==1){
            images=new Image[]{
                    ImageLoader.getImage("Monster2_1.png"),
                    ImageLoader.getImage("Monster2_2.png"),
                    ImageLoader.getImage("Monster2_3.png"),
                    ImageLoader.getImage("Monster2_4.png"),
                    ImageLoader.getImage("Monster2_5.png"),
                    ImageLoader.getImage("Monster2_6.png"),

            };
        }else if (type==2){
            images=new Image[]{
                    ImageLoader.getImage("Monster3_1.png"),
                    ImageLoader.getImage("Monster3_2.png"),
                    ImageLoader.getImage("Monster3_3.png"),
                    ImageLoader.getImage("Monster3_4.png"),


            };
        }else {
            images=new Image[]{
                    ImageLoader.getImage("Marine1.png"),
                    ImageLoader.getImage("Marine2.png"),
                    ImageLoader.getImage("Marine3.png"),
                    ImageLoader.getImage("Marine4.png"),



            };
        }
        if (type<2){
            y=rd.nextInt(BOUND-100-100);
        }else {
            y=BOUND-100-rd.nextInt(100);
        }

    }
    void draw(Graphics2D g2d){
        g2d.drawImage(images[index],x,y,100,100,null);
    }


    int count=0;
    boolean move(){
        count++;
        if (count>50){
            index++;
            if (index>=images.length){
                index=0;
            }
            count=0;
        }

        x-=speed;
        return x<0-images[index].getWidth(null);
    }

    long t;
    void fire(ArrayList<Bullet> arr){
        long T=System.currentTimeMillis();
        if (T-t<2000){
            return;
        }
        t=T;
        int xB=x;
        int yB=y+50;
        Bullet bullet=new Bullet(ImageLoader.getImage("Monster1Bullet.png"),xB,yB,-(speed+1));
        arr.add(bullet);
    }
    Rectangle getRect(){
        Rectangle rect=new Rectangle(
                x,y,100,100
        );
        return rect;
    }
}
