package com.phuong.game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    Player player;
    ArrayList<Bullet> arrBulletPlayer;
    ArrayList<Boss> arrBoss;
    ArrayList<Bullet> arrBulletBoss;
    BackGroud bg=new BackGroud();

    void initGame(){
        player=new Player(100,0);
        arrBulletPlayer=new ArrayList<>();
        arrBoss=new ArrayList<>();
        arrBulletBoss=new ArrayList<>();
    }

    void draw(Graphics2D g2d){
        bg.draw(g2d);
        for (Bullet b:arrBulletPlayer) {
            b.draw(g2d);
        }
        player.draw(g2d);

        for (Boss B:arrBoss) {
            B.draw(g2d);
        }

        for (Bullet bl:arrBulletBoss) {
            bl.draw(g2d);
        }
    }
    int time=0;
    void initBoss(){
        time++;
        if (time>500){
            arrBoss.add(new Boss());
            time=0;
        }
    }

    void bulletMove(ArrayList<Bullet> arr){
        for (int i = arr.size()-1; i >=0 ; i--) {
            boolean check=arr.get(i).move();
            if (check==true){
               arr.remove(i);
            }
        }
    }
    void explosionBullet(){
        for (int i = arrBulletPlayer.size()-1; i >=0; i--) {
            for (int j = 0; j <arrBulletBoss.size() ; j++) {
                Rectangle rect=arrBulletPlayer.get(i).getRect().intersection(arrBulletBoss.get(j).getRect());
                if (rect.isEmpty()==false){
                    SoundManager.play("BulletImpact.wav");
                    arrBulletPlayer.remove(i);
                    arrBulletBoss.remove(j);
                    break;
                }
            }
        }
    }
    void AI() {
        initBoss();
        player.move();
        bulletMove(arrBulletPlayer);

        for (int i = arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).fire(arrBulletBoss);
            boolean check = arrBoss.get(i).move();
            if (check == true) {
                arrBoss.remove(i);
            } else {
                for (int j = 0; j < arrBulletPlayer.size(); j++) {
                    Rectangle rect = arrBoss.get(i).getRect().intersection(arrBulletPlayer.get(j).getRect());
                    if (rect.isEmpty() == false) {
                        arrBulletPlayer.remove(j);
                        arrBoss.remove(i);
                        break;
                    }
                }
            }
        }

        bulletMove(arrBulletBoss);
        explosionBullet();
        boolean isDie=player.checkDie(arrBulletBoss,arrBoss);
        if (isDie==true){
            SoundManager.play("MonsterImpact.wav");
            int result= JOptionPane.showConfirmDialog(null,"bạn muốn chơi lai không","kết thúc",JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION){
                initGame();
            }else {
                System.exit(0);
            }
        }


    }
}
