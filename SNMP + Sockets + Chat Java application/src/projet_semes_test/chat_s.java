/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_semes_test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Wissem
 */
public class chat_s extends javax.swing.JFrame implements Runnable{


   private ObjectOutputStream out;
   private ObjectInputStream in;
   private ServerSocket server;
   private Socket connection;
    /**
     * Creates new form chat_s
     */
    public chat_s() {
        initComponents();
        Data_base db = new Data_base();
        
        this.setIconImage(new ImageIcon("./src/images/chat.png").getImage());
      chat c = new chat();
      Thread t = new Thread(c);
      t.start();
       try{
             
                String nom = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SNMP","root","");
	
	Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery("select Nom from menaces");
         while (rs.next()) {
        nom=rs.getString(1);
        jTextArea2.append(nom);
    jTextArea2.append("\n");
        
         }
        
	
}catch(Exception e){
JOptionPane.showMessageDialog(null, "Erreur d'accès");	
}  
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public class chat implements Runnable{
        public chat(){
            
        }
    public void startRunning()
   {
      try
      {
         server = new ServerSocket(2187, 4);
         while(true)
         {
             
            try
            {
               waitForConnection();
               setupStreams();
               whileChatting();
                
            }catch(EOFException eofException)
            {
               showMessage("\nLe Serveur mis fin à la connexion!");
            }finally{
               close();
               
            }
         }
      }catch(IOException ioException){
         ioException.printStackTrace();
      }
   }
   
  
   public void showMessage(final String message)
   {
      SwingUtilities.invokeLater(
         new Runnable()
         {
            public void run()
            {
               jTextArea1.append(message + "\n");
            }
         }
      );
   }
   
   
   public void sendMessage(String input)
   {
      try
      {
         
         out.writeObject("SERVEUR - " + input);
         out.flush();
         showMessage("SERVEUR - " + input);
      
      }catch(IOException ioException)
      {
         jTextArea1.append("ERREUR: Impossible d'envoyer un message");
      }
      
   }
   
 
   public void waitForConnection() throws IOException
   {
      showMessage("En attente de connexion...");
      connection = server.accept();
      showMessage("Vous etes maintement connecté à " + connection.getInetAddress().getHostName());
   }
   

   public void setupStreams() throws IOException
   {
      out = new ObjectOutputStream(connection.getOutputStream());
      out.flush();
      in = new ObjectInputStream(connection.getInputStream());
      showMessage("\nConfiguration Terminé!");
      
      
   }
   
 
   public void whileChatting() throws IOException
   {
       String arbo[]= new String[150];
       int j=0;
       String aux="";
      String message = "Vous etes connecté!!!";
      showMessage(message);
      ableToType(true);
      do{
        
             
         try
         {
            //out.writeObject("SERVEUR - chrome.exe");
            //out.flush();
            message = (String) in.readObject();
            if(message.endsWith("+")){
                 char[] s=message.toCharArray();
                 for(int i=0;i<s.length;i++){
                     
                     if(s[i]=='+'){
                         arbo[j]=aux;
                         j++;
                         aux="";
                         
                     }
                     else
                     aux+=s[i];
                 }
                
               
                for(int i=0;i<j;i++){
        DefaultMutableTreeNode admin = new DefaultMutableTreeNode(arbo[i]);
             
        DefaultMutableTreeNode set = (DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();
        DefaultTreeModel dt = (DefaultTreeModel)jTree1.getModel();
        dt.insertNodeInto(admin, set, set.getChildCount());
                }
                
            }
            else{
            showMessage(message);
             son s = new son("nudge.wav");  
               s.start();
                }
            
         }catch(ClassNotFoundException classNotFoundException)
         {
            showMessage("\n Input pas correct");
              
         }
       
      }while(!message.equals("CLIENT - END"));
   }
   
 
   public void close()
   {
      showMessage("FERMETURE DU CONNEXION...");
      ableToType(false);
      try
      {
         out.close();
         in.close();
         connection.close();
      }catch(IOException ioException)
      {
         ioException.printStackTrace();
      }
      
   }
   
   public void ableToType(final boolean able)
   {
      SwingUtilities.invokeLater(
            new Runnable()
            {
               public void run()
               {
                  jTextField1.setEditable(able);
               }
            }
         );
   }

        @Override
        public void run() {
           startRunning();
        }
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chat");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 360, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 360, 220));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jTree1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 240, 340));

        jScrollPane3.setHorizontalScrollBar(null);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 294, 180, -1));

        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Processus en tant que menace");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/skull.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 40, 60));

        jButton1.setText("Découvrir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
     chat c = new chat();
       c.sendMessage(evt.getActionCommand());
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText(jTree1.getLastSelectedPathComponent().toString()+".w");
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chat_s.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat_s.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat_s.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_s.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_s().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
