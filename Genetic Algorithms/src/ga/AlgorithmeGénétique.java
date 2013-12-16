/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmegénétique;

import java.util.*;
import java.math.*;
import java.util.Scanner;

/**
 *
 * @author Asma Ben Dhaou
 */


public class AlgorithmeGénétique {
    
    public static class individu{
     
     double x1;
     double x2;
     individu(double x1,double x2,String ch)
     {
         this.x1=x1;
         this.x2=x2;
     }
    }

    int saisirN()
    {
        System.out.println("Donner la taille de la population :");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
       // System.out.println("n="+n); 
        return n;
    }
    
    //  ******* Génération aléatoire des individus de la population
    
    double[] genése(int n)
    {
        /*individu X[]=new individu[n];
        for(int i=0;i<n;i++)
        {
            X[i]=null;
        }
        for (int i=0;i<X.length;i++)
        {
            double x1=(double)(-1.5+ Math.random()*3);
            double x2=(double)(-1.5+ Math.random()*3);
            X[i].x1=x1;
            X[i].x2=x2;
        }*/
         
         
        
        //les val aléa sont mises ds un tab de dim 2n
       double tab[]=new double[2*n];
       
            for(int j=0;j<2*n;j++)
            {
               // Random rand=new Random();
                double x;
              // x=(float)(rand.nextInt(2)+1.5);
                x =(double)(-1.5+ Math.random()*4);
                if (x>= -1.5 && x<=1.5)
                tab[j]=x;
            }   
   
    //verif que -1.5<x1,x2<1.5 
            int k=1;
            for(int j=0;j<2*n;j=j+2) 
            {
               
               System.out.println("X"+k+"=(x1,x2)= ("+tab[j]+" , "+tab[j+1]+")");
               k++;
            } 
            
            /*int k=1;
            for(int j=0;j<n;j++) 
            {
               System.out.println("X"+k+"=(x1,x2)= ("+X[j].x1+" , "+X[j].x2+")");
               k++;
            } */
            return tab;
    }
    
    double Z1(double x1,double x2)
    {
        double r=43.62-1.16*x1-1.17*x2-1.15*x1*x1-0.61*x2*x2-0.31*x1*x2;
        return r;
    }
    
   double[] selection(double[] indiv,int n) //par tournoi  //n=taille de la popul
   {
           System.out.println("SELECTION");
      double Xsel[]=new double[2*n]; 
      for(int m=0;m<2*n;m=m+2)
      {
          int p=5;  //p=le paramétre k de la selection par tournoi
          //selection aléatoire des coulpes
          double iAléa[]=new double[p];
          for (int s=0;s<p;s++)
          {
             int i=(int)(Math.random()*(2*n)); // selection 1er individu//0+random*((2n-1)-0) mais jé mis seulement 2n 
             //System.out.println("i aléatoire ="+i);           // pr ne pas exclure la borne sup de l'intervalle
             iAléa[s]=i;
          }
      
       double XselInter[]=new double[2*p]; //contient les p individus selestionnés
           
       int f=0, x;   
           for(int s=0;s<2*p-1;s=s+2)
           {
               if(iAléa[f]%2==0)
               {
                 x=(int)iAléa[f];
                 XselInter[s]=indiv[x];
                 XselInter[s+1]=indiv[x+1];
               }
               else 
               {
                   x=(int)iAléa[f];
                 XselInter[s]=indiv[x-1];
                 XselInter[s+1]=indiv[x];
               }
               f++;
           }
          
           double FxSelInter[]=new double[p];
           int r=0;
           for(int s=0;s<p;s++)     // calcul de Z1 pour les p individus choisis 
           {
               FxSelInter[s]=Z1(XselInter[r],XselInter[r+1]);
               r=r+2;
           }
           
           //recherche du meilleur indiv dans le tab  FxSelInter
           double max=FxSelInter[0];
           int indiceSel=0;
           for(int s=1;s<p;s++)
           {
               if ( FxSelInter[s]>max)
               {
                  max=FxSelInter[s];
                  indiceSel=s;
               }
           }
           
            Xsel[m]=XselInter[2*indiceSel];
            Xsel[m+1]=XselInter[2*indiceSel+1];
      }
      return Xsel;
   } 
   
   double[] croisement(double[] Xsel,int n) //(les indiv selectionnés,taille de la population)
   {
           System.out.println("CROISEMENT");
       double enfants[]=new double[2*2*n];  //2*2*n 
       int d=0;
       
       for(int m=0;m<2*(2*n);m=m+4)   //pour pouvoir ajouter 4 val ensemble ds le tab enfantsintermediaire
       {
             int i=(int)(Math.random()*(2*n)); // selection 1er individu//0+random*((2n-1)-0) mais jé mis seulement 2n 
             //System.out.println("i"+d+" aléatoire ="+i);           // pr ne pas exclure la borne sup de l'intervalle
             int j=(int)(Math.random()*(2*n));
             //System.out.println("j"+d+" aléatoire ="+j);
             
             double poids=(double)(Math.random());
             //System.out.println("poids "+d+" aléatoire ="+poids);
             d++;  
          
               if(i%2==0 && j%2==0)
               {
                 enfants[m]=poids*Xsel[i]+(1-poids)*Xsel[j];
                 enfants[m+1]=poids*Xsel[i+1]+(1-poids)*Xsel[j+1];
                 enfants[m+2]=poids*Xsel[j]+(1-poids)*Xsel[i];
                 enfants[m+3]=poids*Xsel[j+1]+(1-poids)*Xsel[i+1];
                 
               }
               else if (i%2!=0 && j%2!=0)
               {
                 enfants[m]=poids*Xsel[i-1]+(1-poids)*Xsel[j-1];
                 enfants[m+1]=poids*Xsel[i]+(1-poids)*Xsel[j];
                 enfants[m+2]=poids*Xsel[j-1]+(1-poids)*Xsel[i-1];
                 enfants[m+3]=poids*Xsel[j]+(1-poids)*Xsel[i];
               }
               else if(i%2==0 && j%2!=0)
               {
                   enfants[m]=poids*Xsel[i+1]+(1-poids)*Xsel[j-1];
                 enfants[m+1]=poids*Xsel[i+1]+(1-poids)*Xsel[j];
                 enfants[m+2]=poids*Xsel[j-1]+(1-poids)*Xsel[i+1];
                 enfants[m+3]=poids*Xsel[j]+(1-poids)*Xsel[i+1];
               }
               else
               {
                 enfants[m]=poids*Xsel[i-1]+(1-poids)*Xsel[j];
                 enfants[m+1]=poids*Xsel[i-1]+(1-poids)*Xsel[j+1];
                 enfants[m+2]=poids*Xsel[j]+(1-poids)*Xsel[i];
                 enfants[m+3]=poids*Xsel[j+1]+(1-poids)*Xsel[i];  
               }
           
       }
     
       return enfants;
   }
   
   
   double[] mutation (double[]enfants, int n,int p)
   {
    double[] enfantsAprMut= new double[2*n]; 
    System.out.println("MUTATION");
    //les indices des enfants qui vont muter
    int[] indiceMut=new int[p];
    for(int i=0;i<p;i++)
    {
        indiceMut[i]=(int)(Math.random()*(2*n));
    }
    
    //mutation
    for(int i=0;i<p;i++)
    {
        int x=indiceMut[i];
        if(x%2==0)
        {
            enfants[x]=enfants[x]-0.000001;
            enfants[x+1]=enfants[x+1]-0.000001;
        }
        else
        {
            enfants[x-1]=enfants[x-1]-0.000001;
            enfants[x]=enfants[x]-0.000001;   
        }
    }
    
    for(int i=0;i<2*n;i++)
    {
        enfantsAprMut[i]=enfants[i];
    }
    
    return enfantsAprMut;
   }
    
   double maxApMut(double[] enfantsAprMut,int n)
   {
       
       double FxEnfApMut[]=new double[n]; 
       int r=0;
           for(int s=0;s<n;s++)     // calcul de Z1 pour les p enfants aprés mutation 
           {
               FxEnfApMut[s]=Z1(enfantsAprMut[r],enfantsAprMut[r+1]);
               r=r+2;
           }
        
        double maxG1=FxEnfApMut[0];  // determination du max de Z1 par les enfants ap mutation
        int indiceMax;
        for(int s=1;s<n;s++)
           {
               if ( FxEnfApMut[s]>maxG1)
               {
                  maxG1=FxEnfApMut[s];
                  indiceMax=s;
               }
           } 
        
       return maxG1;
   }
   
   
    public static void main(String[] args) {
      AlgorithmeGénétique AG=new AlgorithmeGénétique();
      int n=AG.saisirN();
      double individu[]=new double[2*n];
      individu=AG.genése(n);
     // System.out.println("indiv 0="+individu[0]); // test de bonne affectation 
      
      //********************************************************* c bon  GENESE réalisée
       double IndivSel[]=new double[2*n];     
       double enfants[]=new double[2*2*n];
       double enfantsAprMut[]=new double[2*n]; 
       
      
     double maxG0=0.01,maxG1=0;
     
     while(maxG1-maxG0!=0)
     {
         maxG0=maxG1;
         IndivSel=AG.selection(individu,n);  //(tab d'individu,taille de la population)
         enfants=AG.croisement(IndivSel, n);
         enfantsAprMut=AG.mutation(enfants, n, 5);  //la val=5 à saisir par l'utilisateur de l'app
         maxG1=AG.maxApMut(enfantsAprMut, n); 
          System.out.println("max aprés mutation est"+maxG1);
          individu=enfantsAprMut;
     }
     System.out.println("Z1optimale est"+maxG1); 
     
      
      /*int j=1;
      for(int i=0;i<=IndivSel.length-2;i=i+2)
      {
      System.out.println("indivSel"+j+" =(" +IndivSel[i]+ ","+IndivSel[i+1] +")");
      j++;
      }
      //********************************************************** c bon  SELECTION réalisée
    
   
    
    
    int p=1;
      for(int i=0;i<(2*n);i=i+2)
      {
      System.out.println("Enfant"+p+" =(" +enfants[i]+ ","+enfants[i+1] +")");
      p++;
      }
   //************************************************************** c bon croisement réalisé
   
    
    
    int k=1;
      for(int i=0;i<(2*n);i=i+2)
      {
      System.out.println("EnfantAprésMutation "+k+" =(" +enfantsAprMut[i]+ ","+enfantsAprMut[i+1] +")");
      k++;
      }*/
    
    }
    
    
}
