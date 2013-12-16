/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package justification;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Wissem
 */
public class Justification {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
       /// ReadWrite wr = new ReadWrite("C:/Users/Wissem/Desktop/input.txt");
        //wr.read();
        Treat t = new Treat();
        System.out.println(t.CountChar(1));
        System.out.println(t.CountSpaces(1));
        System.out.println(t.Countwords(1));
        String[] tab = t.tokenize();
        t.out2();
       
        
    }
}
