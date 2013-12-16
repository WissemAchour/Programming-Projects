/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ga;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Wissem
 */
public final class Population {

    ArrayList<Individu> Individus = new ArrayList<>();

 int taille;
 int nbGene;
 double min;
 double max;
 int nbFct;

    public Population(int taille, boolean  init , int nbGene, double min , double max, int nbFct) {

        this.taille=taille;
        this.nbGene= nbGene;
        this.min=min;
        this.max=max;
        this.nbFct=nbFct;
      
    
        if(init){

            for (int i = 0; i < taille; i++) {
                Individu ind = new Individu(nbGene, min, max);
                ind.genererGenes();
                ajouterIndividu(i, ind);
            }
        }
    }


    public Individu getIndividu(int index) {
        return Individus.get(index);
    }


    public int taille() {
        return this.taille;
    }


    public void ajouterIndividu(int index, Individu indiv) {
        
        Individus.add(index,indiv);
    }

    public Individu getFittest(boolean max) {
        double fittest = Individus.get(0).getValue(nbFct);
        Individu indv = null ;
        int ind = 0;
        boolean permut;
        double tampon;

        

        if(max){
        for (int i = 0; i < taille(); i++) {
            if (Individus.get(i).getValue(nbFct) >=fittest) {
                fittest = Individus.get(i).getValue(nbFct);
                indv=Individus.get(i);
                ind++;
            }
            else{
                ind++;
            }
        }
        }else{
            
            for (int i = 0; i < taille(); i++) {
            if (Individus.get(i).getValue(nbFct) <= fittest) {
                fittest = Individus.get(i).getValue(nbFct);
                indv=Individus.get(i);
                ind++;
            }
            else{
                ind++;
            }
        }
        }
       
        return indv;
    }
}
