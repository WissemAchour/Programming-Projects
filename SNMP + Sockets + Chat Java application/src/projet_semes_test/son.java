/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_semes_test;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.*;

/**
 *
 * @author Wissem
 */

public class son {
    String name;
     InputStream in;
     AudioStream au;
public son(String name) throws FileNotFoundException, IOException {
    this.name="./src/sound/"+name;
        in   = new FileInputStream(this.name);
      au = new AudioStream(in);
}
    

public void start() throws FileNotFoundException, IOException{
 
    AudioPlayer.player.start(au);
}

public void stop() throws FileNotFoundException, IOException{
     
    AudioPlayer.player.stop(au);
    
}

   public static void main(String args[]) throws FileNotFoundException, IOException {
       son s = new son("nudge.wav");
       s.start();
   }
}


