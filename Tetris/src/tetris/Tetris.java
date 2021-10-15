/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author andres chaves y pablo hidalgo
 */

public class Tetris {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        FileManager archivo = new FileManager();
        
        String jugadaspath = "C:\\Users\\hidal\\Desktop\\POO\\Tetris-P1\\Tetris\\src\\tetris\\MejoresJugadas.txt"; 
        
        String memoria = "C:\\Users\\hidal\\Desktop\\POO\\Tetris-P1\\Tetris\\src\\tetris\\memoria";
        
        archivo.createFile(jugadaspath);
        
        TopResultados mejores = new TopResultados();
        
        MenuInicio inicio = new MenuInicio(mejores,jugadaspath,archivo,memoria);
        
        inicio.setVisible(true);
    }
    
}
