/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author hidal
 */
public class FileManager {
    
    public void createFile (String path){
        File myObj = new File(path);
    }
    
    public void writeToFile(String path, String text){
        try {
            
          FileWriter myWriter = new FileWriter(path, true);
          myWriter.write(text);
          myWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
    
    public String readFile(String filePath){
        
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) 
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
    
    public void cleanFile(String filepath){
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) 
        {
            String line;
            while ((line = br.readLine()) != null) {
                line ="";
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public ArrayList<Integer> getPuntajes(String filepath){
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            ArrayList<Integer> puntajes = new ArrayList<Integer>();
            String line;
            while ((line = br.readLine()) != null) {
                int numero = (int) Integer.parseInt(line);
                puntajes.add(numero);
            }
            if (puntajes.isEmpty()==true){
                return null;
            }
            Collections.sort(puntajes, Collections.reverseOrder());
            return puntajes;
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
    
}
