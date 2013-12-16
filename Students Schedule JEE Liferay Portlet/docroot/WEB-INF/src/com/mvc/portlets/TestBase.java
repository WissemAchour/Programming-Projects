package com.mvc.portlets;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.pdf.PdfReader;
		
public class TestBase {
		
	/** 
	 * @param args
	 * @throws IOException 
	 */ 
	public static void main(String[] args) throws IOException {
		
		//writeToDB db = new writeToDB("C:/Users/Wissem/Desktop/emploie.pdf", 3);
	//db.writeInDB();
		int nbpage=2;
		String classe="EI-1-1";
		ArrayList<Cell> cells = new ArrayList<Cell>();
		ReadFromDB RD = new ReadFromDB();
		cells=RD.getList((nbpage-2)*36);
		System.out.println(cells.size());
		PDFCreator pdf = new PDFCreator();
		pdf.create(cells, "emploie "+classe,classe,2);
		
	}

}
