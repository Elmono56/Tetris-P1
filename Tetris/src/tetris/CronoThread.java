/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hidal
 */
public class CronoThread extends Thread{
    private PantallaJuego refPantalla;
    private boolean isRunning = true;
    private int seconds = 0;
    private int minutes = 0;

    public CronoThread(PantallaJuego refPantalla) {
        this.refPantalla = refPantalla;
    }
    
    
    public void run(){
        
        while(isRunning){
            
            try {
                sleep(1000);
                
                seconds++;
                if (seconds > 59) {
                    seconds = 0;
                    minutes++;
                    if(minutes >59){
                        minutes = 0;
                    }
                }
                
                String newTime = setNiceFormat(minutes) + ":" + setNiceFormat(seconds); 
                refPantalla.setTextToCrono(newTime);
            } catch (InterruptedException ex) {
                
            }
        } 
    }
    
    private String setNiceFormat(int number){
        if (number < 10)
            return "0" + number;
        return "" + number;
    }
}
