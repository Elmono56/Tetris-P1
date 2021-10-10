
package tetris;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
    private ImageIcon i1= new ImageIcon(getClass().getResource("/Imagenes/rectangulo.jpg"));
    private ImageIcon i2= new ImageIcon(getClass().getResource("/Imagenes/cubo.jpg"));
    private ImageIcon i3= new ImageIcon(getClass().getResource("/Imagenes/ele.jpg"));
    private ImageIcon i4= new ImageIcon(getClass().getResource("/Imagenes/zeta.jpg"));
    private boolean ganador = false;

    
    
    public ThreadBloque(MatrizJuego matrizJuego, PantallaJuego pantalla){
        this.matrizJuego=matrizJuego;
        this.pantalla=pantalla;
    }
    
    
    
    @Override
    public void run(){
        Random r= new Random();
        int f1=r.nextInt(4);
        int f2=r.nextInt(4);
        int f3=r.nextInt(4);

        
        while(isRunning){
            
            matrizJuego.f3.setIcon(getColor(f3));
            matrizJuego.f2.setIcon(getColor(f2));
            matrizJuego.generarBloques(f1);
            f1=f2;
            f2=f3;
            f3=r.nextInt(4);

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
               this.pantalla.detenerCronometro();
                JOptionPane.showMessageDialog(pantalla, "PERDISTE","Error", JOptionPane.ERROR_MESSAGE);
                this.pantalla.guardarPuntaje();
                this.pantalla.setVisible(false);
                break;
           }
           if (ganador){
               this.pantalla.detenerCronometro();
               JOptionPane.showMessageDialog(pantalla, "GANASTE","FELICIDADES", JOptionPane.INFORMATION_MESSAGE);
               this.pantalla.guardarPuntaje();
               this.pantalla.setVisible(false);
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
    
    
    private ImageIcon getColor(int num){
        switch(num){
            case  0 :return i1;
            case  1 :return i2;
            case  2 :return i3; 
            case  3 :return i4;
        }
         return i1;
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
    
    
    public void setGanador(boolean sino){
        this.ganador = sino;
    }
    
}
