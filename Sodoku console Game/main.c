#include <stdio.h>
#include <stdlib.h>

//fonction affichage.
void affichage (int m[9][9])
{
    int i,j;
     for(i=0;i<9;i++)
   {
       for(j=0;j<9;j++)
       {
printf("|");
printf("%d\t",m[i][j]);

   }
   printf("\n\n");
   }
}
//déclaration des variables.
int main()
{int nombre=0,max=8,min=0,score,i,c,v,diff,menu,k,j,n,v1,f,tab2[9]={0,1,2,3,4,5,6,7,8},tab1[9][9]={{1,2,5,3,7,8,9,4,6},{3,7,8,9,6,4,2,1,5},{4,9,6,1,2,5,8,3,7},{2,6,9,4,5,3,1,7,8},{8,4,1,7,9,2,6,5,3},{5,3,7,8,1,6,4,9,2},{9,1,2,5,8,7,3,6,4},{6,5,3,2,4,9,7,8,1},{7,8,4,6,3,1,5,2,9}},tab0[9][9]={{1,2,5,3,7,8,9,4,6},{3,7,8,9,6,4,2,1,5},{4,9,6,1,2,5,8,3,7},{2,6,9,4,5,3,1,7,8},{8,4,1,7,9,2,6,5,3},{5,3,7,8,1,6,4,9,2},{9,1,2,5,8,7,3,6,4},{6,5,3,2,4,9,7,8,1,},{7,8,4,6,3,1,5,2,9}};

    srand(time(NULL));
   nombre = (rand () % (max - min + 1)) + min; //pour prendre un nombre aléatoire.

 //premier menu.
do
{
printf("=== bienvenu!! ===\n\n");
printf("1.jouer\n");
printf("2.instruction\n");
printf("3.a propos\n");
printf("4.quitter\n");
scanf("%d", &menu);
printf("\n");
printf("\n");
switch (menu)

{
case 1:
printf(" Bon chance dans le jeu.\n\n");
system("pause");
break;

case 2:

system("CLS");
printf("\nBut du jeu: remplir chaque cellule de la grille avec les chiffres de 1 à 9.\n\nUn chiffre ne peut figurer qu'une seule fois par ligne, colonne et sous-grille. \n\n");
printf("-Appuyez sur 5 pour retourner\n");
scanf("%d",&menu);
break;

case 3:

system("CLS");
printf("\nCe jeu a ete cree par Achour Wissem et Chebil Hamed ©\n\n");

printf("-Appuyez sur 5 pour retourner\n");
scanf("%d",&menu);
break;
case 4:
printf("fin du jeu\n");
return 0;
break;
}

system("CLS");
}while((menu>4)||(menu<1));

system("CLS");
//deuxième menu de difficulté.
do
{
printf("=== Choisir la difficulte ===\n\n");
printf("1.Tres facile\n");
printf("2.Facile\n");
printf("3.Moyenne\n");
printf("4.Difficile\n");
printf("5.Test de Sodoku");
printf("\nVotre choix ? ");
scanf("%d", &diff);
printf("\n\n");

switch (diff)

{
case 1:
printf("Vous avez choisi la grille tres facile\n\n");
k=1;
f=9;
score=1000;//initialisation du score.
break;

case 2:
printf("Vous avez choisi la grille facile\n\n");
k=2;
f=18;
score=3000;//initialisation du score.
break;

case 3:
printf("Vous avez choisi la grille moyenne\n\n");
k=4;
f=36;
score=7000;//initialisation du score.
break;
case 4:
printf("Vous avez choisi la grille difficile!!\n\n");
k=5;
f=45;
score=10000;//initialisation du score.
case 5:
printf("Mode teste de la grille\n\n");
tab1[1][1]=0;
tab1[2][2]=0;
tab1[3][3]=0;
tab1[4][4]=0;
score=500;//initialisation du score

f=4;
k=0;
break;
}
system("pause");
}while((diff>5)||(diff<1));


system("CLS");

//élimination des cases de la matrice déclarée au début.

for(i=0;i<9;i++)
   {   int tab2[9]={0,1,2,3,4,5,6,7,8};//initialisation du tableau.
for(j=0;j<k;j++)
   {nombre = (rand () % (max - min + 1)) + min;//mise à jour du nombre aléatoire.

if (tab2[nombre]!=0)
{
tab1[i][tab2[nombre]]=0;
}
else
{j=j-1;}
tab2[nombre]=0;//la valeur utilisée va etre éliminé.
}
}
//affichage de la matrice.
affichage(tab1);
//initialisation du compteur.
c=0;

//boucle de remplissage et vérification.
while((c<f)||(v==0))
{
    do
       {
    printf("donner le numero de la ligne" );
scanf("%d",&i);
score=score-5;
if(score==0)
{
    printf("vous avez perdu...\n");//message d'échec.
    return 0;
}
       }while((i>8)||(i<0));
       do{
printf("donner le numero de la colonne" );
scanf("%d",&j);
score=score-5;

if(score==0)
{
    printf("vous avez perdu...\n");
    return 0;
}
       }while((j>8)||(j<0));
v1=1;
if(tab1[i][j]==0)
{
    do{

    printf("donner le nombre ");
scanf("%d",&n);
tab1[i][j]=n;

score=score-5;

if(score==0)
{
    printf("vous avez perdu...\n");
    return 0;
}
}while((n>9)||(n<1));
}
else{v1=0;};
v=1;

if(v1==1)
{
if ((tab1[i][j]==tab0[i][j]))
    {
        c=c+1;
    }

    else
{

    tab1[i][j]=0;
    v=0;
    printf("\nvotre nombre est incorrect!! ressayer un autre nombre svp\n\n");
    system("pause");
}
}

system("CLS");
affichage(tab1);

}//fin tant que.

//affichage finale si le joueur a gagné.
printf("vous avez gagne!!!!\n***************\n");
printf("votre score est\n");
printf("%d\n",score+f*100);
   return 0;
}

