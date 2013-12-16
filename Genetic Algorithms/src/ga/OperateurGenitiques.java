/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Wissem
 */
public class OperateurGenitiques {

    int nbFct;
    boolean max;
    int nbGene;
    double min1;
    double max1;

    public OperateurGenitiques(int nbGene, double min1, double max1, int nbFct, boolean max) {

        this.nbFct = nbFct;
        this.max = max;
        this.nbGene = nbGene;
        this.min1 = min1;
        this.max1 = max1;
    }

    public ArrayList<Individu> croisement(Individu parent1, Individu parent2) {
        //p appart [0,1]
        Random x = new Random();
        ArrayList<Individu> indivs = new ArrayList<>();

        Individu enfant1 = new Individu(parent1.tailleGenes(), parent1.min, parent1.max);
        Individu enfant2 = new Individu(parent1.tailleGenes(), parent1.min, parent1.max);
        // double p = Math.floor(x.nextDouble() * 100) / 100;
        for (int i = 0; i < parent1.tailleGenes; i++) {
            double p = x.nextDouble() * 100;

            enfant1.setGene(i, p * parent1.getGene(i) + (1 - p) * parent2.getGene(i));
            enfant2.setGene(i, p * parent2.getGene(i) + (1 - p) * parent1.getGene(i));

        }

        indivs.add(enfant1);
        indivs.add(enfant2);

        return indivs;
    }

    public Individu troncation(Population p, boolean max, int maxim) {

        ArrayList<Individu> select = new ArrayList<>();
        //Population p = new Population(50, true);
        Population pop = new Population(p.taille(), false, nbGene, min1, max1, nbFct);
        pop.Individus.clear();
        OperateurGenitiques op = new OperateurGenitiques(nbGene, min1, max1, nbFct, max);
        int k;
        ArrayList<Individu> inter = new ArrayList<>();
        inter.clear();
        LinkedHashMap<Individu, Double> indivs = new LinkedHashMap<>();
        LinkedHashMap<Individu, Double> finals = new LinkedHashMap<>();
        ArrayList<Individu> enf = new ArrayList<>();
        for (int i = 0; i < p.taille(); i++) {
            //   System.out.println("i= " + i + " " + p.Individus.get(i).getValue());
            indivs.put(p.Individus.get(i), p.Individus.get(i).getValue(nbFct));

        }
        if (max) {
            finals = op.triBulleDecroissant(indivs);
        } else {
            finals = op.triBulleCroissant(indivs);
        }


        k = 0;
        for (Map.Entry<Individu, Double> entry : finals.entrySet()) {

            inter.add(k, entry.getKey());

            k++;
        }



        int iv = (int) (Math.random() * maxim);
     
        return inter.get(iv);

    }

    public LinkedHashMap<Individu, Double> triBulleDecroissant(LinkedHashMap<Individu, Double> map) {
        int longueur = map.size();
        double tampon = 0;
        int k = 0;
        boolean permut;
        ArrayList<Double> wiss = new ArrayList<>();
        ArrayList<Individu> ind = new ArrayList<>();
        LinkedHashMap<Individu, Double> arr = new LinkedHashMap<>();

        for (Map.Entry<Individu, Double> entry : map.entrySet()) {

            wiss.add(entry.getValue());

        }
        do {
            permut = false;
            for (int i = 0; i < longueur - 1; i++) {
                if (wiss.get(i) < wiss.get(i + 1)) {
                    tampon = wiss.get(i);
                    wiss.set(i, wiss.get(i + 1));
                    wiss.set(i + 1, tampon);
                    permut = true;
                }
            }
        } while (permut);

        for (int i = 0; i < wiss.size(); i++) {

            arr.put(getKeyByValue(map, wiss.get(i)), wiss.get(i));
        }
        return arr;
    }

    public LinkedHashMap<Individu, Double> triBulleCroissant(LinkedHashMap<Individu, Double> map) {
        int longueur = map.size();
        double tampon = 0;
        int k = 0;
        boolean permut;
        ArrayList<Double> wiss = new ArrayList<>();
        ArrayList<Individu> ind = new ArrayList<>();
        LinkedHashMap<Individu, Double> arr = new LinkedHashMap<>();

        for (Map.Entry<Individu, Double> entry : map.entrySet()) {

            wiss.add(entry.getValue());

        }
        do {
            permut = false;
            for (int i = 0; i < longueur - 1; i++) {
                if (wiss.get(i) > wiss.get(i + 1)) {
                    tampon = wiss.get(i);
                    wiss.set(i, wiss.get(i + 1));
                    wiss.set(i + 1, tampon);
                    permut = true;
                }
            }
        } while (permut);

        for (int i = 0; i < wiss.size(); i++) {

            arr.put(getKeyByValue(map, wiss.get(i)), wiss.get(i));
        }
        return arr;
    }

    public static <T, E> T getKeyByValue(LinkedHashMap<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Individu tournoi(Population pop) {
        // Create a tournament population
        Random r = new Random();
        int tournamentSize = pop.taille / 2;
        Population tournament = new Population(tournamentSize, false, nbGene, min1, max1, nbFct);
        tournament.Individus.clear();
        // For each place in the tournament get a random individual

        int randomId = 0;
        for (int i = 0; i < tournamentSize; i++) {
            randomId = (int) (Math.random() * pop.taille());


            tournament.ajouterIndividu(i, pop.Individus.get(randomId));
        }
        // Get the fittest
        Individu fittest = tournament.getFittest(this.max);
        //System.out.println(tournament.getFittest().getValue());
        return fittest;
    }

    public static void mutation(Population p, double tauxMutation) {
        Random r = new Random();
        int nbModif = 0;
        int posModif = 0;
        double nombre = 0;
        int NbMut = (int) (p.taille() * tauxMutation) / 100;

        for (int i = 0; i < NbMut; i++) {

            int Nbgene = r.nextInt(p.Individus.get(0).tailleGenes());
            for (int j = 0; j < Nbgene; j++) {
                nbModif = r.nextInt(10);
                posModif = r.nextInt(13);
                nombre = nbModif / (Math.pow(10, posModif));
                p.Individus.get(i).setGene(j, p.Individus.get(i).getGene(j) + nombre);
                //p.Individus.get(i).setGene(1, p.Individus.get(i).getGene(1) + 0.0001);
            }

        }

    }
}
