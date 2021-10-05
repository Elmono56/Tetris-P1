
package tetris;
import java.awt.Color;

/**
 *
 * @author chave
 */


public class Bloques {
    private int [][] tamaño;
    private Color color;
    private int x,y;
   
    public  Bloques(int [][] tamaño,Color color){
        
        this.color=color;
        this.tamaño=tamaño;
        this.setX(3);
        this.setY(2);

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
