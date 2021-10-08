/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author hidal
 */
public class Sonido {
    
    public Sonido (){
    }
    
    public void playMusic(String filepath){
        try{
            File musicpath = new File(filepath);
            
            if (musicpath.exists()){
                AudioInputStream music = AudioSystem.getAudioInputStream(musicpath);
                Clip clip = AudioSystem.getClip();
                clip.open(music);
                clip.start();
            }
            else{
                System.out.println("No existe el audio");
            }
        }
        catch (Exception e){
            
        }
    }

}

