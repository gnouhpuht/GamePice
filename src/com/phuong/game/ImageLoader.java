package com.phuong.game;

import javax.swing.*;
import java.awt.*;

public class ImageLoader {
    static Image getImage(String name){
        Image img=new ImageIcon(
                new ImageLoader().getClass().getResource("/imgs/"+name)
        ).getImage();
        return img;
    }
}
