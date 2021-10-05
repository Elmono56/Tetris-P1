
package tetris;

import java.awt.Color;
import java.awt.Graphics;//sirve para pintar
import javax.swing.JPanel;//permite modificar el panel

/**
 *
 * @author chave
 */
public class MatrizJuego extends JPanel{
    
    private int Filas=20;
    private int Columnas=10;
    private int tamañodeCelda;
    private Bloques bloque;
    
    public MatrizJuego(JPanel pantalladeJuego){
        pantalladeJuego.setVisible(false);
        this.setBounds(pantalladeJuego.getBounds());//limite de pantalla de juego (tamaño del panel)
        this.setBackground(pantalladeJuego.getBackground());//pone color al area de juego 
        this.setBorder(pantalladeJuego.getBorder());//pone color al borde del area de juego
        tamañodeCelda=this.getBounds().width / Columnas;
        generarBloques();
        
    }
    
    public void generarBloques(){

    bloque= new Bloques(new int[][] {{1,0},{1,0},{1,1}}, Color.RED);

    }

    
    
    
    
    private void ponerBloque(Graphics pintor){
        
        int altura=bloque.getAltura();
        int ancho=bloque.getAncho();
        int [][]tamaño=bloque.getTamaño();
        int x,y;
        Color color= bloque.getColor();
        
        
    
        for (int fila = 0; fila < altura; fila++) {
            
            for (int columna = 0; columna < ancho; columna++) {
                
                if(tamaño[fila][columna]==1){//si el bloque de la matriz en ==1 entonces lo pinta
                    
                    x= (bloque.getX()+columna)*tamañodeCelda;
                    y= (bloque.getY()+fila)*tamañodeCelda;
                            
                    pintor.setColor(color);//color del bloque
                    pintor.fillRect(x, y, tamañodeCelda, tamañodeCelda);//pinta el bloque
                    pintor.setColor(Color.black);//color del borde del bloque
                    pintor.drawRect(x, y, tamañodeCelda, tamañodeCelda);//pinta el borde del bloque
                }
            }
            
        }
    
    
    }
    
    @Override
    protected  void paintComponent(Graphics pintor){//se encarga de pintar cada espacio de la matriz
     
        super.paintComponent(pintor);//se encarga de pintar la pieza del tetris
        
        for (int y = 0; y < Filas; y++) {
            
            for (int x = 0; x < Columnas; x++) {

                pintor.drawRect(x*tamañodeCelda, y*tamañodeCelda, tamañodeCelda, tamañodeCelda);
                pintor.setColor(Color.gray);

            }
        }
        ponerBloque(pintor);
    }
    
    
    
    
    
   
    
    
}
