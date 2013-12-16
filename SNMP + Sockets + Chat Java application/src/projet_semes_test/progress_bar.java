/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_semes_test;

import javax.swing.JProgressBar;

/**
 *
 * @author Wissem
 */
public class progress_bar implements Runnable{

    
    int max;
    JProgressBar k;
    Thread_process th;
    Thread_prog rech;
    int assign;
    search.ip.Recherche_IP rech_ip;
    public progress_bar(int max , JProgressBar k,Thread_process th){
        
        this.max=max;
        this.k=k;
        this.th=th;
        assign=1;
    }
    
        public progress_bar(int max , JProgressBar k,Thread_prog rech){
        
        this.max=max;
        this.k=k;
        this.rech = rech;
        assign=2;
    }
        
  public progress_bar(int max ,JProgressBar k,search.ip.Recherche_IP rech_ip){
    this.max=max;
    this.k=k;
      this.rech_ip=rech_ip;
      assign=3;
  }


    @Override
    public void run() {
        k.setVisible(true);
        k.setMaximum(max);
        if(assign==1)
        while(th.compteur()<max)
        {
            k.setValue(th.compteur());
        }
        k.setValue(0);
        
        if(assign==2){
          
           while(rech.compteur()<max)
        {
            k.setValue(rech.compteur());
        } 
         }
        
        if(assign==3){
            
         while(rech_ip.compteur()<max)
        {
            k.setValue(rech_ip.compteur());
        }    
            
        }
         k.setValue(0);
   }
}