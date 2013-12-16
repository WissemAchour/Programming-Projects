/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_semes_test;
import java.sql.*;
import javax.swing.JOptionPane;

 
public class Data_base {
   public void afficher(String request){
try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SNMP","root","");
	
	Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(request);

	while(rs.next()){
		
		System.out.println(rs.getString(1)+ " \n" +rs.getString(2));
	}
}catch(Exception e){
JOptionPane.showMessageDialog(null, "Erreur d'accès");	
}
}
   
      public String get(String request){
try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SNMP","root","");
	
	Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(request);
        return rs.getString(1);
	
}catch(Exception e){
JOptionPane.showMessageDialog(null, "Erreur d'accès");	
}
       return null;
      
}
   
   public void insertion(String request,boolean affichage){
try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SNMP","root","");
	
	Statement stat = con.createStatement();
       
          int rs = stat.executeUpdate(request);
          if(affichage == true)
          JOptionPane.showMessageDialog(null, "Succès d'ajout");

}catch(Exception e){
JOptionPane.showMessageDialog(null, e.getMessage());

}
}  
   
    public void suppression(String request,boolean affichage){
try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SNMP","root","");
	
	Statement stat = con.createStatement();
       
          int rs = stat.executeUpdate(request);
          if(affichage == true)
          JOptionPane.showMessageDialog(null, "Succès de suppression");

}catch(Exception e){
JOptionPane.showMessageDialog(null, e.getMessage());

}
}
   
}
