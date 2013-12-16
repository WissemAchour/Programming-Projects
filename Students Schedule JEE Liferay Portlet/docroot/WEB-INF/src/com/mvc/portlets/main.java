package com.mvc.portlets;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.apache.jasper.tagplugins.jstl.core.Redirect;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public class main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args)  {
	
		//EntityManager entityManager;
		//entityManager = Persistence.createEntityManagerFactory("JPA_test").createEntityManager();
		// TODO Auto-generated method stub
				/*String[] txt = { "a", "b", "c", "d" };
				
				EntityManager em;
				em=Persistence.createEntityManagerFactory("JPA_test").createEntityManager();
				EntityManager entity = em;
				entity.getTransaction().begin();
				for (int i = 0; i < txt.length; i++) {
					Message msg = new Message();
					msg.setVal(txt[i]);
					entity.persist(msg);
				}
				entity.getTransaction().commit();*/
    	/*EntityManager entity = entityManager;
    	entity.getTransaction().begin();
    	Query q1 = entity.createQuery("DELETE FROM Salle");
		q1.executeUpdate();
		
		entity.getTransaction().commit();*/
		
		
		/*EntityManager em;
		em=Persistence.createEntityManagerFactory("JPA_test").createEntityManager();
		EntityManager entity = em;
    	entity.getTransaction().begin();
    	Query q1 = entity.createQuery("DELETE FROM Salle");
		q1.executeUpdate();
		
		entity.getTransaction().commit();
		
	*/	
	/*	ArrayList<String> horaire = new ArrayList<String>();	
		pdf_reader cells = new pdf_reader("C:/Users/Wissem/Desktop/emploie.pdf",3);

	java.util.List<Cell> cell = cells.getCells();
		
		for(int i=0;i<cell.size();i++){
			if(horaire.isEmpty()){
				horaire.add(cell.get(i).getHour());
			}
			else if(!cell.get(i).getHour().equals(horaire.get(horaire.size()-1))){
				horaire.add(cell.get(i).getHour());
				
			}
			}
		System.out.println("nb sceance= "+horaire.size());
		System.out.println("nb jour= "+cell.size()/horaire.size());
		
		
		
		writeToDB db1 = new writeToDB("C:/Users/Wissem/Desktop/emploie.pdf",3);
		db1.writeInDB();
		
		Seance s = new Seance();
		SousGroupe sg = new SousGroupe();
		Enseignant e = new Enseignant();
		Matiere m = new Matiere();
		Salle salle = new Salle();
		
		ReadFromDB db = new ReadFromDB();
		db.start();
		s=db.readSeance(0);
		sg=db.readSousGroupe(0);
		e=db.readEnseignant(0);
		m=db.readMatiere(0);
		salle=db.readSalle(0);
		
		System.out.println(s.getHeure()+sg.getNomSousGroupe()+e.getNomEnseignant()+m.getNomMatiere()+salle.getNomSalle());
		db.close();*/
		/*ArrayList<String> horaire = new ArrayList<String>();	
		pdf_reader cells = new pdf_reader("C:/Users/Wissem/Desktop/emploie.pdf",3);

	java.util.List<Cell> cell = cells.getCells();
		
		for(int i=0;i<cell.size();i++){
			if(horaire.isEmpty()){
				horaire.add(cell.get(i).getHour());
			}
			else if(!cell.get(i).getHour().equals(horaire.get(horaire.size()-1))){
				horaire.add(cell.get(i).getHour());
				
			}
			}
		System.out.println("nb sceance= "+horaire.size());
		System.out.println("nb jour= "+cell.size()/horaire.size());
		
		
		 try {
	            Document iText_Create_Table = new Document();
	            String dirName = System.getProperty("user.home");
	            PdfWriter.getInstance(iText_Create_Table, new FileOutputStream(dirName+"\\wissem.pdf"));
	            iText_Create_Table.open();
	            
	                     
	            PdfPTable my_second_table = new PdfPTable(1); 
	            PdfPCell table_cell2;
	            table_cell2=new PdfPCell();
	            my_second_table.addCell(table_cell2);//p
	            table_cell2.setColspan(0); 
	            table_cell2.setRowspan(2);

	            my_second_table.addCell("                                                        Eniso");
	            my_second_table.addCell("                                                        E-1-1");

	            
	            PdfPTable my_first_table = new PdfPTable(7);
	            PdfPCell table_cell; 
	            table_cell=new PdfPCell();
	            table_cell.setColspan(8); 
	            table_cell.setRowspan(7); 
	            my_first_table.addCell(table_cell);
	            
	            

	            
	            my_first_table.addCell("");
	            my_first_table.addCell("Lundi");
	            my_first_table.addCell("Mardi");
	            my_first_table.addCell("Mercredi");
	            my_first_table.addCell("Jeudi");
	            my_first_table.addCell("Vendredi");
	            my_first_table.addCell("Samedi");
	            
	            
	            my_first_table.addCell("8:30");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            
	            my_first_table.addCell("10:15");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            
	            my_first_table.addCell("12:00");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            
	            my_first_table.addCell("13:30");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            
	            my_first_table.addCell("15:10");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            
	            my_first_table.addCell("16:50");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            my_first_table.addCell("à remplir");
	            
	          
	            iText_Create_Table.add(my_second_table);
	            iText_Create_Table.add(my_first_table);    
  
	            iText_Create_Table.close();
	        }
	        catch (Exception i)
	        {
	            System.out.println(i);
	        }*/
		ArrayList<Cell> cells = new ArrayList<Cell>();
		trylist l = new trylist();
		cells=l.getList();
		for (int i = 0; i < cells.size(); i++) {
			System.out.println(cells.get(i).getCourse1());
		}
		
	}
}
