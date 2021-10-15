
package tetris;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author andres chaves y pablo hidalgo
 */

public class Bloques {
    private int [][] tamaño;
    private Color color;
    private int x,y;
    private int [][][] formas;
    private int formaActual;
   
    public  Bloques(int [][] tamaño,Color color){
        
        this.color=color;
        this.tamaño=tamaño;
        iniciarFormas();
        ponerBloque();
    }
    
    private void iniciarFormas(){//entender bien 
        formas=new int[4][][];//cuatro rotaciones posibles 
        int fila;
        int columna;
        for (int i = 0; i < 4; i++) {
            fila= tamaño[0].length;
            columna = tamaño.length;
            formas[i]=new int[fila][columna];
            
            for(int y = 0; y < fila; y++){
               
                for (int x = 0; x < columna; x++) {
                    formas[i][y][x]= tamaño[columna-x-1][y];
                }     
            }
            tamaño=formas[i];
        }
    }
    
    public void ponerBloque(){
        Random num= new Random();
        formaActual=3;
        tamaño= formas[formaActual];
        this.setX(4);//medida para que aparezca en el medio 
        this.setY(-4);//medida para que aparezca arriba de la matriz }
    }
 
    //metodos de reenviar la pos del bloque
    public int revisarIzquierda(){
        return x;
    }
 
    public int revisarDerecha(){
        return x+getAncho();
    } 
    
    public int revisarFinal(){
    return y+getAltura();
    }
    
    //moviemientos del bloque
    public void caida(){
        y++;
    }
 
    public void der(){
        x++;
    }
 
    public void izq(){
        x--;
    }
   
    public void rotar(){
        formaActual++;
        if(formaActual>3)formaActual=0;
        tamaño = formas[formaActual];
    }
   
    public void regresar(){
        formaActual--;
        if(formaActual<0)formaActual=3;
        tamaño = formas[formaActual];
    } 
    
    
    //getter y setter
    public int[][] getTamaño() {
        return tamaño;
    }

    public Color getColor() {
        return color;
    }

    public int getAltura(){
        return tamaño.length;
    }
    public int getAncho(){
        return tamaño[0].length;
    }    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
