
package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author chave
 */
public class ThreadBloque extends Thread{
    
    private MatrizJuego matrizJuego;
    private PantallaJuego pantalla;
    
    private int lineas;
    private int puntaje;
    private int aux;
    private int nivel=1;
    private boolean isRunning = true;
    
    
    
    public ThreadBloque(MatrizJuego matrizJuego, PantallaJuego pantalla){
    this.matrizJuego=matrizJuego;
    this.pantalla=pantalla;
    }
    
    
    
    @Override
    public void run(){
        
        
        while(isRunning){
        
           matrizJuego.generarBloques();
           pantalla.actualizarNivel(this.nivel);
           while(matrizJuego.limiteFinal()){//minetras que pueda seguir cayendo
                    matrizJuego.caer();
                try {
                     Thread.sleep(2000-(nivel*150));

                 } catch (InterruptedException ex) {
                     Logger.getLogger(ThreadBloque.class.getName()).log(Level.SEVERE, null, ex);
                 }
               
           } 
           if(matrizJuego.limiteTope()){//si el bloque toca el tope de la matriz se termina el juego
                JOptionPane.showMessageDialog(pantalla, "PERDISTE","Error", JOptionPane.ERROR_MESSAGE);

                break;
           }
            matrizJuego.pegarEnMatriz();
            aux=matrizJuego.revisarMatriz();
            lineas+=aux;
            if(aux==1)
                pantalla.actualizarPuntos(++puntaje);
            if(aux>1){
                puntaje+=aux+1;
                pantalla.actualizarPuntos(puntaje);
            
            }
            pantalla.actualizarLineas(lineas);
            
        }
    }
    
    public void aumentarNivel(){
        
        if (nivel<10){
            this.nivel= this.nivel +1;
            pantalla.actualizarNivel(this.nivel);
        }
    }
    
    public void setIsRunning(boolean estado){
        this.isRunning = estado;
    }
        
    
         
    
    
}
