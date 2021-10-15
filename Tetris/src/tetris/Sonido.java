/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author andres chaves y pablo hidalgo
 */

public class Sonido {
    
    String filepath;
    File musicpath;
    AudioInputStream music;
    Clip clip;
    
    public Sonido () throws UnsupportedAudioFileException, LineUnavailableException{
        this.filepath ="C:\\Users\\hidal\\Desktop\\POO\\Tetris-P1\\Tetris\\music\\lofi.wav";
        this.musicpath = new File(filepath);
        try{
            this.music = AudioSystem.getAudioInputStream(musicpath);
            this.clip = AudioSystem.getClip();
            this.clip.open(music);
        }
        catch (IOException ex) {
            System.out.println("No existe el audio");
        }
    }
    
    public void playMusic(){
        this.clip.start();
    }
    
    public void stopMusic(){
        clip.stop();
    }
}

