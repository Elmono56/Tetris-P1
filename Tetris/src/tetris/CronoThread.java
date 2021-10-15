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
 * @author andres chaves y pablo hidalgo
 */

public class CronoThread extends Thread{
    private PantallaJuego refPantalla;
    private boolean isRunning = true;
    private int seconds = 0;
    private int minutes = 0;
    private boolean isPaused = false;

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
                if (refPantalla.getNivel()==9 & minutes==2){
                    this.refPantalla.setGanador(true);
                }
                if ((minutes%2)==0 & (minutes>1)){
                    refPantalla.aumentarLevel();
                    seconds=0;
                    minutes=0;
                }
                while (isPaused){
                    sleep(500);
                }
            } catch (InterruptedException ex) {
                
            }
        } 
    }
    
    private String setNiceFormat(int number){
        if (number < 10)
            return "0" + number;
        return "" + number;
    }
    
    public void setIsRunning(boolean estado){
        this.isRunning = estado;
    }
    
    public void pauseThreadCrono(){
        this.isPaused = true;
    }
        public void reanudarThreadCrono(){
        this.isPaused = false;
    }

    public String getSeconds() {
        return ""+seconds;
    }

    public String getMinutes() {
        return ""+minutes;
    }
    
    public void setSegundos(int seg){
        this.seconds = seg;
    }
    
    public void setMinutos(int min){
        this.minutes = min;
    }
    
}
