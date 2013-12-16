package com.mvc.portlets;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.Pfm2afm;

/**
 * @author Wissem
 * 
 */
public class test_strings {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		pdf_reader cells = new pdf_reader("C:\\Users\\Wissem\\Desktop\\emploie.pdf",2);
		List<Cell> cell = cells.getCells();
		System.out.println(cell.size());

		
		//seance 8:30 de mercredi
		
				System.out.println(cell.get(2).hour + "***"+cell.get(2).subclass1 + "***"+cell.get(2).subclass2 + "***"+cell.get(2).course1 + "***"+cell.get(2).course2+ 
						"***"+cell.get(2).teacher1+"***"+cell.get(2).teacher2+"***"+cell.get(2).room1 + "***"+cell.get(2).room2 + "***");
		
	}

}
