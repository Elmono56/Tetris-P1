/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author chave
 */
public class Tetris {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Sonido cancion = new Sonido();
        
        String path = "C:\\Users\\hidal\\Desktop\\POO\\Tetris-P1\\Tetris\\music\\calamity.wav";
        
        cancion.playMusic(path);
    }
    
}
