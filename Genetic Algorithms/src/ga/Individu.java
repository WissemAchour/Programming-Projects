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
public class Individu {

    ArrayList<Double> genes = new ArrayList<>();
    private int fitness = 0;
    static int tailleGenes;
    double min;
    double max;

    public Individu(int tailleGenes, double min, double max) {

        this.tailleGenes = tailleGenes;
        this.min = min;
        this.max = max;
    }

    public void genererGenes() {
        genes.clear();
        //  System.out.println(tailleGenes);
        for (int i = 0; i < tailleGenes; i++) {
            //à faire à part par la suite 
            Random random = new Random();
            double gene = showRandomInteger(this.min, this.max, random);
            // gene = Math.floor(gene * 100) / 100;
            genes.add(i, gene);
        }
    }

    public double getGene(int index) {
        return genes.get(index);
    }

    public void setGene(int index, double value) {
        genes.add(index, value);
        fitness = 0;
    }

    public int tailleGenes() {
        return genes.size();
    }

    public double getValue(int nbFct) {

        double x = 0;
        double x1 = 0;
        double x2 = 0;
        double x3 = 0;
        double x4 = 0;
        double x5 = 0;
        double x6 = 0;
        double x7 = 0;
        double x8 = 0;
        double x9 = 0;
        double x10 = 0;
        double somme = 0;
        switch (nbFct) {
            case 1:
                x1 = genes.get(0);
                x2 = genes.get(1);
                x = 43.62 - 1.16 * x1 - 1.17 * x2 - 1.15 * Math.pow(x1, 2) - 0.61 * Math.pow(x2, 2) - 0.31 * x1 * x2;
                break;

            case 2:

                x1 = genes.get(0);
                x2 = genes.get(1);

                x = Math.pow(x1, 2) + Math.pow(x2, 2) + 40 * Math.sin(x1) * Math.sin(x2);
                break;

            case 3:


                x1 = genes.get(0);
                x2 = genes.get(1);
                x3 = genes.get(2);
                x4 = genes.get(3);
                x5 = genes.get(4);


                somme = somme + Math.pow(x1, 2);
                somme = somme + Math.pow(x2, 2);
                somme = somme + Math.pow(x3, 2);
                somme = somme + Math.pow(x4, 2);
                somme = somme + Math.pow(x5, 2);

                x = (0.01 * Math.pow(x1, 2) * (x1 + 2) * Math.pow((x1 - 5), 2) * (x1 - 12)) + somme;
                break;


            case 4:
                double v1 = 0;
                double v2 = 0;
                x1 = genes.get(0);
                x2 = genes.get(1);
                for (int i = 1; i <= 5; i++) {

                    v1 = v1 + ((i * Math.cos(i + 1) * x1) + i);
                    v2 = v2 + ((i * Math.cos(i + 1) * x2) + i);
                }

                x = -v1 * v2;
                break;

            case 5:
                x1 = genes.get(0);
                x2 = genes.get(1);
                x3 = genes.get(2);
                x4 = genes.get(3);


                x = Math.pow(Math.exp(x1) - x2, 4) + 100 * Math.pow(x2 - x3, 6) + Math.tan(Math.pow(x3 - x4, 4)) + Math.pow(x1, 8);

                break;


            case 6:
                double val = 0;

                x1 = genes.get(0);
                x2 = genes.get(1);
                x3 = genes.get(2);
                x4 = genes.get(3);
                x5 = genes.get(4);
                x6 = genes.get(5);
                x7 = genes.get(6);
                x8 = genes.get(7);
                x9 = genes.get(8);
                x10 = genes.get(9);

                for (int i = 1; i <= 9; i++) {

                    val = val + Math.pow(Math.pow(x1, 2) - genes.get(i), 2);
                }
                x = Math.pow(1 - x1, 2) + Math.pow(1 - x10, 2) + val;

                break;

            case 7:

                x1 = genes.get(0);
                x2 = genes.get(1);
                x3 = genes.get(2);
                x4 = genes.get(3);
                x5 = genes.get(4);

                x = 2 - ((1 / 1200) * (x1 * x2 * x3 * x4 * x5));
                break;

            case 8:

                double var = 0;

                for (int i = 0; i < 10; i++) {

                    var = var + (Math.pow(genes.get(i), 2) + 0.5 * genes.get(i));
                }
                x = -var;
                break;

            case 9:
                x1 = genes.get(0);
                x2 = genes.get(1);
                x = -Math.pow(x1, 2) - (2.1 * Math.pow(x1, 4)) - (0.33 * Math.pow(x1, 6)) + (x1 * x2) - (4 * Math.pow(x2, 2)) + (4 * Math.pow(x2, 4));
                break;

            case 10:

                
                double s = 0;
                double p=1;

                for (int i = 0; i < 10; i++) {

                    s=s+Math.pow(Math.log(genes.get(i)-2), 2)+Math.pow(Math.log(10-genes.get(i)), 2);
                }
                for (int i = 0; i < 10; i++) {

                    p=p*Math.pow(genes.get(i), 0.2);
                }
                x=s-p;
                if(!Double.isNaN(x)){
                System.out.println(x);
                }else{
                   x=0; 
                }
                break;

        }

        return x;
    }

    private static double showRandomInteger(double aStart, double aEnd, Random aRandom) {
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }

        double range = aEnd - aStart;

        double fraction = (range * aRandom.nextDouble());
        double randomNumber = (fraction + aStart);
        return randomNumber;
    }
}
