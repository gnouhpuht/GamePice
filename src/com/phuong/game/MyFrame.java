package com.phuong.game;

import com.phuong.interf.Constant;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame implements Constant {
//    static final int W_FRAME =800;
//    static final int H_FRAME=600;


    public MyFrame() {
        setTitle("Game One Piece");
        setSize(W_FRAME,H_FRAME);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyPanel myPanel=new MyPanel();
        add(myPanel);
    }

    public static void main(String[] args) {
//        MyFrame frame=new MyFrame();
//        frame.setVisible(true);
        new MyFrame().setVisible(true);
    }
}
