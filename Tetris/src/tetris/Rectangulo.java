/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;
import java.awt.Color;


/**
 *
 * @author chave
 */
public class Rectangulo extends Bloques{
    
    public Rectangulo(){
        super(new int[][]{{1,1,1,1}},Color.CYAN);
        }
        
    
    @Override
    public void rotar(){
        super.rotar();
        if(this.getAncho()==1){
            this.setX(this.getX()+1);
            this.setY(this.getY()-1);
        
        }else{
            this.setX(this.getX()-1);
            this.setY(this.getY()+1);
        
        
        }
        
    }
    
}
