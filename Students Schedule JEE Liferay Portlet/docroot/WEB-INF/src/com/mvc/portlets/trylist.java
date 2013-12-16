package com.mvc.portlets;

import java.awt.List;
import java.util.ArrayList;

public class trylist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Cell> cells = new ArrayList<Cell>();
		trylist l = new trylist();
		cells=l.getList();
		for (int i = 0; i < cells.size(); i++) {
			System.out.println(cells.get(i).getCourse1());
		}
		
	}
		//int compt = nbjour*nbseance;
		
		public ArrayList<Cell> getList(){
    	ArrayList<Cell> cells = new ArrayList<Cell>();
    	int k=0;
    	Seance s = new Seance();
		SousGroupe sg = new SousGroupe();
		Enseignant e = new Enseignant();
		Matiere m = new Matiere();
		Salle salle = new Salle();
		
		ReadFromDB db = new ReadFromDB();
		db.start();
		e=db.readEnseignant(k);
		
		while((e!=null)){
			k++;
			e=db.readEnseignant(k);
		}
		
		//System.out.println(k);
		for (int i = 0; i < k; i++) {
			
			//Cell cell = null ;
			Cell cell = new Cell();
			
			s=db.readSeance(i);
			sg=db.readSousGroupe(i);
			e=db.readEnseignant(i);
			m=db.readMatiere(i);
			salle=db.readSalle(i);
			
			cell.setCourse1(m.getNomMatiere());
			cell.setHour(s.getHeure());
			cell.setRoom1(salle.getNomSalle());
			cell.setSubclass1(sg.getNomSousGroupe());
			cell.setTeacher1(e.getNomEnseignant());
			cells.add(cell);
			
		}
		db.close();
		return cells;
		
		//writeToDB db1 = new writeToDB("C:/Users/Wissem/Desktop/emploie.pdf",3);
	//db1.writeInDB();	
		}
	

}
