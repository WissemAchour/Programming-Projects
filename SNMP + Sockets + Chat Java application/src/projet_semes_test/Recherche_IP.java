/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package search.ip;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import projet_semes_test.recherche_inter;

/**
 *
 * @author Wissem
 */
public class Recherche_IP implements Runnable{


    /**
     * @param args the command line arguments
     */
    String sub ;
    JTextArea area;
    JLabel label;
    JComboBox combo;
    int i=0;
   public Recherche_IP(String sub , JTextArea area,JComboBox combo){
       this.sub=sub;
       this.area=area;
       this.label=label;
       this.combo=combo;
   }

public int compteur(){
    return i;
}
    @Override
    public void run() {
        try{
         for(i = 0 ; i< 256 ; i++){     
   recherche_inter rech = new recherche_inter();
   if(rech.isReachableByPing(sub+"."+i)){
       area.append(sub+"."+i);
       area.append("\n");
      combo.addItem(sub+"."+i);
   }
    
   // System.out.println(inet.isReachable(2000) ? "Existe" : "N'existe pas");
     }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    

}