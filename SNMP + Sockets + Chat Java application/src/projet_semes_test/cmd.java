/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


    

/**
 *
 * @author Wissem
 */
public class cmd {
    
    public cmd(){
        
    }
    void kill(String p){
        String command="taskkill /IM "+p;
        try {
            Process process = Runtime.getRuntime().exec(command);                
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
