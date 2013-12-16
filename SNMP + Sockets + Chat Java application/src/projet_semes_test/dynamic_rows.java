/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_semes_test;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wissem
 */
public class dynamic_rows implements Runnable{

    JTable table;
    int i;
    public dynamic_rows(JTable j,int k){
        table=j;
        i=k;
    }
    
    @Override
    public void run() {
        
        
       for(int f=0;f<i-4;f++)
               ((DefaultTableModel) table.getModel() ).addRow(new Object[]{""});
        
       
        
        }
    
    
}
