package com.phuong.game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundManager {
    static void play(String name){
        try {
            File file=new File("src/sound/"+name);
            AudioInputStream stream= AudioSystem.getAudioInputStream(file);
            Clip c=AudioSystem.getClip();
            c.open(stream);
//            c.loop(2);  số lần lặp nhạc nền
            c.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
