/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package justification;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Wissem
 */
public class ReadWrite {
    String link;
    int nbline;
    ArrayList<String> phrases = new ArrayList<>();
    
    public  ReadWrite(String link){
        this.link=link;
    }
    public void read() throws FileNotFoundException, IOException{
         BufferedReader reader=new BufferedReader(new FileReader(this.link));
         String line=null;
         
         while((line=reader.readLine())!=null){
             //System.out.println(line);
             phrases.add(line.trim());
             this.nbline++;
         }
    }
    
  
}
