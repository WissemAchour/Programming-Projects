package com.mvc.portlets;

import java.awt.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class writeToDB {

String link;
int nbpage;
	public writeToDB(String link,int nbpage){
		this.link=link;
		this.nbpage=nbpage;
	}
	public EntityManager entityManager;
	pdf_reader pdf;
	
	public EntityManager getEntityManager() {
        return entityManager;
    }
	
    public void writeInDB(){
    	entityManager = Persistence.createEntityManagerFactory("JPA_test").createEntityManager();
    	EntityManager entity = entityManager;
    	entity.getTransaction().begin();
    	
    	Query q1 = entity.createQuery("DELETE FROM Salle");
		q1.executeUpdate();
	//	getEntityManager().createQuery("DELETE s FROM Salle s where s.id_salle='"+i+"'");
		Query q2 = entity.createQuery("DELETE FROM Enseignant");
		q2.executeUpdate();
		
		Query q3 = entity.createQuery("DELETE FROM Matiere");
		q3.executeUpdate();
		
		Query q4 = entity.createQuery("DELETE FROM Seance");
		q4.executeUpdate();
		
		Query q5 = entity.createQuery("DELETE FROM SousGroupe");
		q5.executeUpdate();
    	
		int id=0;
    	for (int j = 2; j <=nbpage; j++) {
			
		
    	pdf_reader cells = new pdf_reader(this.link,j);
  
    	java.util.List<Cell> cell = cells.getCells();
    	
      	//int initial = (nbpage-2)*36;
      			
    	//
 
    	//for (int i = initial; i < initial+36; i++) {
			
    		
		//}
    	

		
    	for(int i = 0;i<cell.size();i++){
    		
    		if(cell.get(i).teacher1==null){
    			
    			Seance seance = new Seance();
    			seance.setIdSeance(id);
    		   // seance.setJour(cell.get(i).jour);
    		    seance.setHeure((cell.get(i).hour));
    		    entity.persist(seance);
    		    
    		   
    		    SousGroupe sousGroupe = new SousGroupe();
    		    sousGroupe.setIdSousGroupe(id);
    		    sousGroupe.setNomSousGroupe("empty");
    		    entity.persist(sousGroupe);
    		   
    		    
    		    Enseignant enseignant = new Enseignant();
    		    enseignant.setIdEnseignant(id);
    		    enseignant.setNomEnseignant("empty");
    		    entity.persist(enseignant);

    		    Matiere matiere = new Matiere();
    		    matiere.setIdMatiere(id);
    		    matiere.setNomMatiere("empty");
    		    entity.persist(matiere);

    		  
    		    Salle salle = new Salle();
    		    salle.setIdSalle(id);
    		    salle.setNomSalle("empty");
    		    entity.persist(salle);
    		    
    		    
    			/*Affectation affectation = new Affectation();
    			affectation.setId(id);
    		    affectation.setEnseignant(enseignant);
    		    affectation.setMatiere(matiere);
    		    affectation.setSalle(salle);
    		    affectation.setSeance(seance);
    		    affectation.setSousGroupe(sousGroupe);
    		    entity.persist(affectation);*/
    		    
    		    id++;
    		}
    		
    		else if(cell.get(i).teacher2==null){
    	
    			
    			Seance seance = new Seance();
    			seance.setIdSeance(id);
    		   // seance.setJour(cell.get(i).jour);
    		    seance.setHeure((cell.get(i).hour));
    		    entity.persist(seance);
    		    
    		    if(cell.get(i).subclass1==null){
        		    SousGroupe sousGroupe = new SousGroupe();
        		    sousGroupe.setIdSousGroupe(id);
        		    sousGroupe.setNomSousGroupe("empty");
        		    entity.persist(sousGroupe);
    		    }
        		else{
        		    	
        		    	SousGroupe sousGroupe = new SousGroupe();
            		    sousGroupe.setIdSousGroupe(id);
            		    sousGroupe.setNomSousGroupe(cell.get(i).subclass1);
            		    entity.persist(sousGroupe);
        		    }
    		    
    		    Enseignant enseignant = new Enseignant();
    		    enseignant.setIdEnseignant(id);
    		    enseignant.setNomEnseignant(cell.get(i).teacher1);
    		    entity.persist(enseignant);

    		    Matiere matiere = new Matiere();
    		    matiere.setIdMatiere(id);
    		    matiere.setNomMatiere(cell.get(i).course1);
    		    entity.persist(matiere);

    		  
    		    Salle salle = new Salle();
    		    salle.setIdSalle(id);
    		    salle.setNomSalle(cell.get(i).room1);
    		    entity.persist(salle);
    		    
    		    
    			/*Affectation affectation = new Affectation();
    			affectation.setId(id);
    		    affectation.setEnseignant(enseignant);
    		    affectation.setMatiere(matiere);
    		    affectation.setSalle(salle);
    		    affectation.setSeance(seance);
    		    affectation.setSousGroupe(sousGroupe);
    		    entity.persist(affectation);*/
    		    
    		    id++;
    		}
    		else if(cell.get(i).teacher2!=null){
    			//Affectation affectation = new Affectation();
    			//affectation.setId(id);
    			//entity.persist(affectation);
    			
    			//Affectation affectation2 = new Affectation();
    			//affectation2.setId(id++);
    			//entity.persist(affectation2);
    			
    			Seance seance1 = new Seance();
    			seance1.setIdSeance(id);
    		   // seance1.setJour(cell.get(i).jour);
    		    seance1.setHeure((cell.get(i).hour));
    		    entity.persist(seance1);

    		   // Seance seance2 = new Seance();
    		   // seance2.setIdSeance(id++);
    		  //  seance2.setJour(cell.get(i).jour);
    		  //  seance2.setHeure((cell.get(i).hour));
    		   // entity.persist(seance2);

    		    SousGroupe sousGroupe1 = new SousGroupe();
    		    
    		    if(cell.get(i).subclass2!=null){
    		    	sousGroupe1.setIdSousGroupe(id);
        		    sousGroupe1.setNomSousGroupe(cell.get(i).subclass1+" "+cell.get(i).subclass2);
        		    entity.persist(sousGroupe1);
    		    }
    		    else if(cell.get(i).subclass1!=null && cell.get(i).subclass2==null){
    		    sousGroupe1.setIdSousGroupe(id);
    		    sousGroupe1.setNomSousGroupe(cell.get(i).subclass1);
    		    entity.persist(sousGroupe1);
    		    }
    		    else{
    		    	 sousGroupe1.setIdSousGroupe(id);
    	    		    sousGroupe1.setNomSousGroupe("empty");
    	    		    entity.persist(sousGroupe1);
    		    }

    		    /*SousGroupe sousGroupe2 = new SousGroupe();
    		    sousGroupe2.setIdSousGroupe(id++);
    		    sousGroupe2.setNomSousGroupe(cell.get(i).subclass2);
    		    entity.persist(sousGroupe2);*/

    		    Enseignant enseignant1 = new Enseignant();
    		    enseignant1.setIdEnseignant(id);
    		    enseignant1.setNomEnseignant(cell.get(i).teacher1+" "+cell.get(i).teacher2);
    		    entity.persist(enseignant1);

    		    /*Enseignant enseignant2 = new Enseignant();
    		    enseignant2.setIdEnseignant(id++);
    		    enseignant2.setNomEnseignant(cell.get(i).teacher2);
    		    entity.persist(enseignant2);*/

    		    if(cell.get(i).course2!=null){
    		    Matiere matiere1 = new Matiere();
    		    matiere1.setIdMatiere(id);
    		    matiere1.setNomMatiere(cell.get(i).course1+" "+cell.get(i).course2);
    		    entity.persist(matiere1);
    		    }else{
    		    	Matiere matiere1 = new Matiere();
        		    matiere1.setIdMatiere(id);
        		    matiere1.setNomMatiere(cell.get(i).course1);
        		    entity.persist(matiere1);
    		    }

    		    /*Matiere matiere2 = new Matiere();
    		    matiere2.setIdMatiere(id++);
    		    matiere2.setNomMatiere(cell.get(i).course2);
    		    entity.persist(matiere2);*/

    		    if(cell.get(i).room2==null){
    		    Salle salle1 = new Salle();
    		    salle1.setIdSalle(id);
    		    salle1.setNomSalle(cell.get(i).room1);
    		    entity.persist(salle1);
    		    }
    		    else if(cell.get(i).room1!=null&&cell.get(i).room2!=null){
    		    	Salle salle1 = new Salle();
        		    salle1.setIdSalle(id);
        		    salle1.setNomSalle(cell.get(i).room1+" "+cell.get(i).room2);
        		    entity.persist(salle1);
    		    }

    		    /*Salle salle2 = new Salle();
    		    salle2.setIdSalle(id++);
    		    salle2.setNomSalle(cell.get(i).room1);
    		    entity.persist(salle2);
    		    
    		    affectation.setEnseignant(enseignant1);
    		    affectation.setMatiere(matiere1);
    		    affectation.setSalle(salle1);
    		    affectation.setSeance(seance1);
    		    affectation.setSousGroupe(sousGroupe1);
    		    */

    		    
    		    id++;
    		}
    		
    		
    	}
    	
    }
    	entity.getTransaction().commit();
    }

}
