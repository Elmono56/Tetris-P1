
package tetris;

import java.awt.Color;
import java.awt.Graphics;//sirve para pintar
import javax.swing.JLabel;
import javax.swing.JPanel;//permite modificar el panel

/**
 *
 * @author chave
 */
public class MatrizJuego extends JPanel{
    
    private int filas=20;
    private int columnas=10;
    private int tamañodeCelda;
    public JLabel f2;
    public JLabel f3;
    private Bloques bloque;
    private Color[][] finales;
    public String resultado;

    //constructor
    public MatrizJuego(JPanel pantalladeJuego,JLabel figura2,JLabel figura3){
        iniciar(pantalladeJuego,figura2,figura3);
        finales= new Color[filas][columnas];
    }
    
    public MatrizJuego(JPanel pantalladeJuego,JLabel figura2,JLabel figura3,Color[][] aux){
        iniciar(pantalladeJuego,figura2,figura3);
        finales= aux;
    }
    
    public void iniciar(JPanel pantalladeJuego,JLabel figura2,JLabel figura3){
        this.f2 = figura2;
        this.f3 = figura3;
        pantalladeJuego.setVisible(false);
        this.setBounds(pantalladeJuego.getBounds());//limite de pantalla de juego (tamaño del panel)
        this.setBackground(pantalladeJuego.getBackground());//pone color al area de juego 
        this.setBorder(pantalladeJuego.getBorder());//pone color al borde del area de juego
        tamañodeCelda=this.getBounds().width / columnas;//le asigna el tamaño a cada celda
        this.resultado = "";
    }
   

    //metodos de bloques en la matriz
    
    public void generarBloques(int num){
    switch(num){
    case  0 -> bloque= new Rectangulo();
    case  1 -> bloque= new Cuadrado();
    case  2 -> bloque= new Ele();
    case  3 -> bloque= new Zeta();
   }
    }
    

    
   //limpiar lineas completas
    
    public int revisarMatriz(){
        boolean lineaCompleta;
        int lineasEliminadas=0;
        for (int fila = filas-1; fila >= 0; fila--) {//recorre la matriz de abajo hacia arriba
            
            lineaCompleta=true;
            for(int colu=0;colu<columnas;colu++){
            
                if(finales[fila][colu]==null){//si hay un espacio vacio en la linea omite la linea 
                    lineaCompleta=false;
                    break;
                }
            }
            if(lineaCompleta){
                lineasEliminadas++;
                limpiarLinea(fila);
                bajarLinea(fila);
                limpiarLinea(0);
                fila++;
                repaint();
            } 
        }
        
        return lineasEliminadas;
    }
    
    private void limpiarLinea(int fila){
    
        for (int i = 0; i < columnas; i++) {
            finales[fila][i]=null;//pone la linea en blanco
        }
    }
    
    private void bajarLinea(int filaBajar){
    //reccore la matrix desde la linea eliminada hasta arriba copiando el color de la fila superior
        
        for (int fila= filaBajar; fila>0; fila--){
            for (int colu= 0; colu < columnas; colu++) {
                finales[fila][colu]=finales[fila-1][colu];
            }
        }
    
    }
    
   


    //revisa los limites de la matriz 
   
    public boolean limiteFinal(){//hace que el bloque caiga hasta el final o al max   CHECKBOTTON
       
    //si la suma del alto de la figura con el resto de la matriz == al numro de filas se detiene   
        if(bloque.revisarFinal()==filas)return false;
    
        int[][]tamaño= bloque.getTamaño();
        int ancho= bloque.getAncho();
        int altura= bloque.getAltura();
        for(int colu =0; colu<ancho; colu++){
            for (int fila = altura-1; fila >=0; fila--) {
                if(tamaño[fila][colu]!=0){
                    int x= colu+bloque.getX();
                    int y= fila+bloque.getY()+1;
                    if(y<0) break;
                    if(finales[y][x]!=null) return false;
                    break;}
            }
        }
        return true;
    }
    

    public boolean limiteIzquierda(){
        
        if(bloque.revisarIzquierda()==0)return false;
        
        int[][]tamaño= bloque.getTamaño();
        int ancho= bloque.getAncho();
        int altura= bloque.getAltura();
        for(int fila =0; fila<altura; fila++){
            for (int colu = 0; colu<ancho; colu++) {
                if(tamaño[fila][colu]!=0){
                    int x= colu+bloque.getX()-1;
                    int y= fila+bloque.getY();
                    if(y<0) break;
                    if(finales[y][x]!=null) return false;
                    break;}
            }
        }       
        return true;
    }
    
    
    public boolean limiteDerecha(){
        if(bloque.revisarDerecha()==10)return false;
        
        int[][]tamaño= bloque.getTamaño();
        int ancho= bloque.getAncho();
        int altura= bloque.getAltura();
        
        for(int fila =0; fila<altura; fila++){
            for (int colu = ancho-1; colu>=0; colu--) {
                if(tamaño[fila][colu]!=0){
                    int x= colu+bloque.getX()+1;
                    int y= fila+bloque.getY();
                    if(y<0) break;
                    if(finales[y][x]!=null) return false;
                    break;}
            }
        }       

        return true;

    }
    
    
    public boolean limiteTope(){
        if(bloque.getY()<0){
            bloque=null;
            return true;
        }
        return false;
    }
    



//metodos de pintar la matriz
    
    public void pegarEnMatriz(){
    
        int [][]cuadro=bloque.getTamaño();//cuadro de la matriz
        int altura=bloque.getAltura();
        int ancho= bloque.getAncho();
        int posX= bloque.getX();
        int posY= bloque.getY();
        Color color=bloque.getColor();
        
        for (int fila = 0; fila < altura; fila++){    
            for (int columna = 0; columna < ancho; columna++) {
              
                if(cuadro[fila][columna]==1){//si el cuadro está en 1 se pinta
                    finales[fila + posY][columna + posX]=color;
                }
            }
        }
    
    
    
    }
    
    private void pintarMatriz(Graphics pintor){//pinta el bloque cayendo en la matriz
        
        int altura=bloque.getAltura();
        int ancho=bloque.getAncho();
        int [][]tamaño=bloque.getTamaño();
        int x,y;
        Color color= bloque.getColor();

        for (int fila = 0; fila < altura; fila++) {
            
            for (int columna = 0; columna < ancho; columna++) {
                
                if(tamaño[fila][columna]==1){//si el bloque de la matriz en ==1 entonces lo pinta
                    
                    x = (bloque.getX()+columna)*tamañodeCelda;
                    y = (bloque.getY()+fila)*tamañodeCelda;
                    pintar(x, y, pintor, color);//se encarga de pintar el bloque cayendo
                }
            }
            
        }
    
    
    }
    
    public void pintarBloqueTetris(Graphics pintor){//permite pintar el bloque en su posicion max final
        
        Color celda;
        int x,y;
         for (int fila = 0; fila < filas; fila++) {
            
            for (int columna = 0; columna < columnas; columna++) {
                
                celda=finales[fila][columna];//posicion de la celda
                
                if(celda!=null){ //si no tiene ningun color entonce == null
                    x=columna*tamañodeCelda;
                    y=fila*tamañodeCelda;
                    pintar(x, y, pintor,celda);//se encarga de pintar el bloque
                }            
            }
         }
    }
    
    public void pintar(int x,int y, Graphics pintor, Color color){
    
        pintor.setColor(color);//color del bloque
        pintor.fillRect(x, y, tamañodeCelda, tamañodeCelda);//rellena la posicion dada
        pintor.setColor(Color.black);//color del borde del bloque
        pintor.drawRect(x, y, tamañodeCelda, tamañodeCelda);//pinta el borde del bloque

    }
    
    
    
    //guarda la informacion de la matriz
    
    public String revisar(){  
        
        Color celda;
        for (int fila = 0; fila < filas; fila++) {
            
            for (int columna = 0; columna < columnas; columna++) {
                
                celda=(Color)finales[fila][columna];//posicion de la celda
                System.out.println(celda);
                if(celda!=null){
                   if(celda==Color.CYAN)resultado+=1;
                   if(celda==Color.ORANGE)resultado+=2;
                   if(celda==Color.YELLOW)resultado+=3;
                   if(celda==Color.GREEN)resultado+=4;
                }else{
                      resultado+=0;
                }

                }
                
            }
         return resultado+"\n";
    }

    


//movimientos
    
    
    public void izquierda(){
        if(bloque==null)return;
        if(!limiteIzquierda())return;
        bloque.izq();
        repaint();
    }
    
    public void derecha(){
        if(bloque==null)return;
        if(!limiteDerecha())return ;
        bloque.der();
        repaint();
    }
    
    public void rotar(){
        if(bloque==null)return; 
        
        bloque.rotar();

        if( bloque.revisarDerecha()>=columnas)
            bloque.setX(columnas - bloque.getAncho());
        
        
        if(bloque.revisarIzquierda()<0)
            bloque.setX(0);
        
        if (bloque.revisarFinal()>=filas) bloque.setY(filas - bloque.getAltura());
        
        verificar();//evita que los bloques se traspasen 
    }

    
    public void caer(){//DROPBLOCK
        if(bloque==null)return;
        if(!limiteFinal())return;
            bloque.caida();
            repaint();
    }
    
    
    public void verificar(){

    for(int fila = 0; fila < bloque.getAltura(); fila++) {
           for( int col = 0; col < bloque.getAncho(); col++) {
               if(bloque.getTamaño()[fila][col] != 0) {
                   int x = col + bloque.getX();
                   int y = fila + bloque.getY();
                   if(y < 0)
                       break;
                   if(finales[y][x] != null){
                      bloque.regresar();
                       repaint();
                       return;
                   }
                       
               }
           }
       }
        repaint();
   }

    
    
    
    @Override
    protected  void paintComponent(Graphics pintor){//se encarga de pintar cada espacio de la matriz
     
        super.paintComponent(pintor);//permite pintar la pieza de tetris
        
        for (int y = 0; y < filas; y++) {
            
            for (int x = 0; x < columnas; x++) {

                pintor.drawRect(x*tamañodeCelda, y*tamañodeCelda, tamañodeCelda, tamañodeCelda);
                pintor.setColor(Color.LIGHT_GRAY);//color del borde de la matriz

            }
        }        
        pintarBloqueTetris(pintor);//permite pintar el bloque cuando toque el fondo maximo
        pintarMatriz(pintor);//permite pintar el bloque cayendo

    }
    

}
