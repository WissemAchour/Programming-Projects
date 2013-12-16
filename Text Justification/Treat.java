/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package justification;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Wissem
 */
public class Treat {
    private static final String ESPACE="*";
    private static final String PONCTUATION = ".,;!:?";

    public int CountChar(int line) throws IOException {
        ReadWrite wr = new ReadWrite("C:/Users/Wissem/Desktop/input.txt");
        wr.read();
        int nb = wr.phrases.get(line - 1).length();
        return nb;

    }

    public int CountSpaces(int line) throws FileNotFoundException, IOException {
        int compt = 0;
        ReadWrite wr = new ReadWrite("C:/Users/Wissem/Desktop/input.txt");
        wr.read();
        for (int i = 0; i < wr.phrases.get(line).length(); i++) {

            if (Character.isSpaceChar(wr.phrases.get(line).charAt(i))) {
                compt++;
            }
        }
        return compt;
    }

//    public String[] tokenize(String s){
//        StringTokenizer st=new StringTokenizer(s," ");
//        List<String> list=new ArrayList<>();
//        while(st.hasMoreTokens()){
//            list.add(st.nextToken());
//        }
//        return list.toArray(new String[list.size()]);
//    }
//    
    public String[] tokenize() throws FileNotFoundException, IOException {
        ReadWrite wr = new ReadWrite("C:/Users/Wissem/Desktop/input.txt");
        wr.read();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < wr.nbline; i++) {
            StringTokenizer st = new StringTokenizer(wr.phrases.get(i), PONCTUATION + " ", true);

            // List<String> list=new ArrayList<>();
            while (st.hasMoreTokens()) {
                final String v = st.nextToken();
                if (!v.equals(" ")) {
                    list.add(v);
                }
            }

        }

        return list.toArray(new String[list.size()]);
    }

    public int Countwords(int line) throws FileNotFoundException, IOException {

        ReadWrite wr = new ReadWrite("C:/Users/Wissem/Desktop/input.txt");
        wr.read();

        StringTokenizer st = new StringTokenizer(wr.phrases.get(line), " ");
        List<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        return list.size();

    }

    public boolean isPonctuation(String word) {
        return PONCTUATION.indexOf(word) >= 0;
    }

    public boolean canAddWord(List<String> ligneEnCours, int ligneEnCoursLength, String word) {
        if (word.length() == 1 && isPonctuation(word)) {
            // c'est ue ponctuation
            return (ligneEnCoursLength + 1 < 50);
        }
        return (ligneEnCoursLength + 1 + word.length() < 50);
    }

    public boolean needsSpace(List<String> words, int pos) {
        if (pos > 1) {
            String curr = words.get(pos);
            String last = words.get(pos-1);
            boolean currPonc = isPonctuation(curr);
            boolean lastPonc = isPonctuation(last);
            return (!currPonc && !lastPonc)
                    || (!currPonc && lastPonc)
                    || (currPonc && lastPonc);
        }
        return false;
    }

    public int findSpaceCount(List<String> words) {
        int spaces = 0;
        for (int i = 1; i < words.size(); i++) {
            if (needsSpace(words, i)) {
                spaces++;
            }
        }
        return spaces;
    }
    public void out2() throws FileNotFoundException, IOException {
        List<String> ligneEnCours = new ArrayList<>();
        int ligneEnCoursLength = 0;
        StringBuilder resultatFinal = new StringBuilder();
        String[] mots = tokenize();
        for (String m : mots) {
            if (canAddWord(ligneEnCours, ligneEnCoursLength, m)) {
                ligneEnCours.add(m);
                if (needsSpace(ligneEnCours, ligneEnCours.size()-1)) {
                    ligneEnCoursLength++;
                }
                ligneEnCoursLength += m.length();
            } else {
                //justification
                final int spaceCount = findSpaceCount(ligneEnCours);
                int justEspaces = (50 - ligneEnCoursLength) / spaceCount;
                int extra = (50 - ligneEnCoursLength) % spaceCount;
                if (resultatFinal.length() > 0) {
                    resultatFinal.append("\n");
                }
                int x=resultatFinal.length();
                for (int i = 0; i < ligneEnCours.size(); i++) {
                    if(needsSpace(ligneEnCours, i)){
                        for (int j = 0; j <= justEspaces; j++) {
                            resultatFinal.append(ESPACE);
                        }
                        if (extra > 0) {
                            resultatFinal.append(ESPACE);
                            extra--;
                        }
                    }
                    resultatFinal.append(ligneEnCours.get(i));
                }
                resultatFinal.append("[").append(resultatFinal.length()-x).append("]");
                ligneEnCours.clear();
                ligneEnCoursLength = 0;

                //ligne suivante
                ligneEnCours.add(m);
                ligneEnCoursLength += m.length();
            }
        }
        if (ligneEnCours.size() > 0) {
            if (resultatFinal.length() > 0) {
                resultatFinal.append("\n");
            }
            for (int i = 0; i < ligneEnCours.size(); i++) {
                if (needsSpace(ligneEnCours, i)) {
                    resultatFinal.append(ESPACE);
                }
                resultatFinal.append(ligneEnCours.get(i));
            }
        }
        System.out.println(resultatFinal);
    }

    public void out() throws FileNotFoundException, IOException {
        //Treat t = new Treat();
        int j = 0;
        String display = "";
        String[] tab = tokenize();
        int nbtotal = 0;
        for (int i = 0; i < tab.length; i++) {

            nbtotal += tab[i].length() + 1;
        }
        int nbCh = 0;
        int total = 0;
        while (j < tab.length) {
            display = "";
            total += nbCh;
            nbCh = 0;

            while (nbCh < 50) {

                if (nbtotal - total < 50) {
                    for (int i = j; i < tab.length; i++) {




                        nbCh += tab[i].length() + 1;
                        if (nbCh > 50) {
                            break;
                        }
                        display += tab[i] + " ";
                        j++;

                        //if()
                        // break;

                    }
                } else {
                    nbCh += tab[j].length() + 1;

                    if (nbCh < 50 && j < tab.length) {

                        display += tab[j] + " ";
                        j++;
                    } else {
                        break;
                    }
                }

            }

            System.out.println(display);
        }


    }
}
