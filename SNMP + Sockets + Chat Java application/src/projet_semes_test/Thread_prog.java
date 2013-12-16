/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_semes_test;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Wissem
 */
public class Thread_prog implements Runnable{

    JTextField text;
    JComboBox combo;
    JTextArea area;
    JTable table;
    String ip;
    int i=1;
    int l=1;
    int nbr=1;
    public Thread_prog(JTable j,String ip){
        
        this.ip=ip;
        this.table=j;
    }

  
    @Override
    public void run() {
       
        
        
        while(!new OID_info().recherche(ip,"1.3.6.1.2.1.25.6.3.1.2."+i).equals("Null"))
        {
             table.setValueAt( new OID_info().recherche(ip,"1.3.6.1.2.1.25.6.3.1.2."+i), i-1, 0);
             i++;
        }
      
    }
    
     int compteur(){
        
        return i;
        
    }
     
     int nbre_case(){
         while(!new OID_info().recherche(ip,"1.3.6.1.2.1.25.6.3.1.2."+nbr).equals("Null"))
        {
             //table.setValueAt( new Projet_semes_test().recherche("127.0.0.1","1.3.6.1.2.1.25.6.3.1.2."+i), i-1, 0);
             nbr++;
            
        }
         return nbr-1;
     }
    
}
