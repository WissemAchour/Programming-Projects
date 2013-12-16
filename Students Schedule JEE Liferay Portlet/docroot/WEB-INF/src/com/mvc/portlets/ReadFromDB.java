package com.mvc.portlets;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ReadFromDB {

	public EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    
	public Seance readSeance(int id){
		
		 return getEntityManager().find(Seance.class, id);
	}
	
	public Enseignant readEnseignant(int id){
		
		 return getEntityManager().find(Enseignant.class, id);
	}
	
	public Salle readSalle(int id){
		
		 return getEntityManager().find(Salle.class, id);
	}
	
	public SousGroupe readSousGroupe(int id){
		
		 return getEntityManager().find(SousGroupe.class, id);
	}
	
	public Matiere readMatiere(int id){
		
		 return getEntityManager().find(Matiere.class, id);
	}
	
    public void start() {
        entityManager = Persistence.createEntityManagerFactory("JPA_test").createEntityManager();
    }

    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
    

    
    public ArrayList<Cell> getList(int initial){
    	ArrayList<Cell> cells = new ArrayList<Cell>();
    	//int k=initial;
    	Seance s = new Seance();
		SousGroupe sg = new SousGroupe();
		Enseignant e = new Enseignant();
		Matiere m = new Matiere();
		Salle salle = new Salle();
		
		ReadFromDB db = new ReadFromDB();
		db.start();
		//e=db.readEnseignant(k);
		
		/*while((e!=null)){
			k++;
			e=db.readEnseignant(k);
		}*/

		for (int i = initial; i < initial+36; i++) {

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
