/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_semes_test;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author Wissem
 */
public class Thread_process implements Runnable{
   String ip;
    JComboBox area;
   JTable table;
  int i=0;
    boolean test;
    public Thread_process(String ip,JTable j)
    {
     this.ip=ip;  
     table=j;
     test=true;
    }
    
     public Thread_process(String ip,JComboBox area)
    {
     this.ip=ip;  
     this.area=area;
     test=false;
    }
    
    @Override
    public void run() {
         int k=0;
        int nbre=Integer.parseInt(new OID_info().recherche(ip, "1.3.6.1.2.1.25.1.6.0"));
        while(i<nbre)
        {
            k++;
           if(!new OID_info().recherche(ip, ".1.3.6.1.2.1.25.4.2.1.2."+k).equals("Null"))
           { //System.out.println(new Projet_semes_test().recherche(ip, ".1.3.6.1.2.1.25.4.2.1.2."+k));i++;
          // area.append(new Projet_semes_test().recherche(ip, ".1.3.6.1.2.1.25.4.2.1.2."+k));i++;
           //area.append("\n");
               if(test==true){
               table.setValueAt(new OID_info().recherche(ip, ".1.3.6.1.2.1.25.4.2.1.1."+k), i, 0);
               table.setValueAt(new OID_info().recherche(ip, ".1.3.6.1.2.1.25.4.2.1.2."+k), i, 1);
               }
               else
               {
                   area.addItem(new OID_info().recherche(ip, ".1.3.6.1.2.1.25.4.2.1.2."+k));
                   
               }
               i++;
           // System.out.println(new Projet_semes_test().recherche(ip, ".1.3.6.1.2.1.25.4.2.1.6."+k));
           }
               
         }
    }
    
    int compteur(){
        
        return i;
        
    }
    
}
