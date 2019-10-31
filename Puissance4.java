

import java.util.*;

public class Puissance4 {
    // je déclare mes variables en static pour les utiliser partout
    static int choix;
    static String joueur1 = "";
    static String joueur2 = "";
    static int N;
    static int L;
    static int C;
    static char[][] plateau;
    static int i;
    static String ligne = "";
    static int gagnant;
    static int o;
    static int low;
    static int high;
    static int choix1;
    static int choix2;
    static String reponse = " ";
    static int infoIa;

    public Puissance4() {

    }
    /**
     * Je créé ma méthode pour choisir le de jouer à 2 ou contre l'ordinateur
     */

    public static void choixJoueurs() {
        choix1 = 1;
        choix2 = 2;
        String choixJoueur = "Choix des joueurs: \n- Choix 1: 2 joueurs. \n- Choix 2: 1 joueur.";
        System.out.println(choixJoueur);
        Scanner sc = new Scanner(System.in);
        choix = sc.nextInt();
        if (choix == choix1)
            joueurs();
        if (choix == choix2)
            ordinateur();

    }
/**
 * Si on choisit l'option 1, on rentre le nom des joueurs
 */
    public static void joueurs() {
        System.out.println("Entrer le nom du joueur 1: ");
        Scanner j1 = new Scanner(System.in);
        joueur1 = j1.nextLine();
        System.out.println("Entrer le nom du joueur 2: ");
        Scanner j2 = new Scanner(System.in);
        joueur2 = j2.nextLine();
        System.out.println("Le joueur 1 est " + joueur1 + ", et le joueur 2 est " + joueur2 + ".");

    }
    /**
     * Pour l'option 2 on rentre son nom est le joueur 2 est l'ordiateur
     */

    public static void ordinateur() {
        System.out.println("Entrer le nom du joueur: ");
        Scanner j1 = new Scanner(System.in);
        joueur1 = j1.nextLine();
        joueur2 = "Ordinateur";
        System.out.println("Le joueur est " + joueur1 + ", et il joue avec l'" + joueur2 + ".");

    }
    /**
     * J'initialise mon plateau de jeu
     */
    public static void initJeu() {
        N = 4;
        C = 7;
        L = 6;
        plateau = new char[C][L];
        for (int x = 0; x < C; x++)
            for (int y = 0; y < L; y++)
                plateau[x][y] = '.';
    
        for (i = 1; i <= C * L; i++) {
            plateau();
            System.out.println();
            System.out.println((i % 2 == 1 ? joueur1 : joueur2) + " choisis un chiffre entre 1 et " + C + "...");
            System.out.println();
            methodeDeJeu();
            
        }
        
    }
    // Je formate mon plateau
    
    public static void plateau() {
        System.out.println("Tour " + i + ", Etat du plateau: ");
        for (int loop = 0; loop < C + 2 + 2 * C; loop++) {
            System.out.print('-');
        }
        System.out.println();
        for (int y = 0; y < L; y++) {
            System.out.print('|');
            for (int x = 0; x < C; x++) {
                System.out.print(" " + plateau[x][y] + " ");
            }
            System.out.print('|');
            System.out.println();
        }
        for (int loop = 0; loop < C + 2 + 2 * C; loop++) {
            System.out.print('-');
        }
        System.out.println();
        for (int q = 1; q < L + 2; q++) {
            System.out.print("  " + q);
        }
    }
    // Ma méthode de jeu de l'ordinateur

    public static int random() {
        high = 7;
        low = 1;
        return ((int) (Math.random() * (high + 1 - low)) + low);
    }
    public static int ia() {
    
                if (infoIa == 1) {
                    high = 2;
                    low = 1;
                    return ((int) (Math.random() * (high + 1 - low)) + low);
                }
                if (infoIa == 2) {
                    high = 3;
                    low = 1;
                    return ((int) (Math.random() * (high + 1 - low)) + low);
                }
                if (infoIa == 3) {
                    high = 4;
                    low = 2;
                    return ((int) (Math.random() * (high + 1 - low)) + low);
                }
                if (infoIa == 4) {
                    high = 5;
                    low = 3;
                    return ((int) (Math.random() * (high + 1 - low)) + low);
                }
                if (infoIa == 5) {
                    high = 6;
                    low = 4;
                    return ((int) (Math.random() * (high + 1 - low)) + low);
                }
                if (infoIa == 6) {
                    high = 7;
                    low = 5;
                    return ((int) (Math.random() * (high + 1 - low)) + low);
                } if (infoIa == 7) 
                    high = 7;
                    low = 6;
                
        return ((int) (Math.random() * (high + 1 - low)) + low);
            
        
    }
/**
 * Dans ma méthode de jeu en rapport avec les choix précédents il va choisir sa facon de jouer
 */
    public static void methodeDeJeu() {
        
        boolean placement = false;
        int colonne = -1;
        Scanner sc = new Scanner(System.in);
        while (!placement) {
            if (choix == choix1)
                ligne = sc.nextLine();
            if (choix == choix2) {
                if (i % 2 == 1){
                    ligne = sc.nextLine();
                    infoIa = Integer.valueOf(ligne);}
                else 
                    ligne = String.valueOf(random());
            }
            try {
                colonne = Integer.valueOf(ligne);
                if (colonne >= 1 && colonne <= C) {
                    if (plateau[colonne - 1][0] != '.') {
                        System.out.println("Colonne pleine! Rejouez!");
                    } else {
                        placement = true;

                    }

                } else {
                    System.out.println("Choisir un chiffre entre 1 et 7 est si compliqué??? \n\nRejouez!!!!");
                }

            } catch (Exception e) {
                System.out.println("Pas autre chose qu'un chiffre entre 1 et "+C+"!!!! \n\nRejouez!!!!");

            }
        }

        int rang = L - 1;
        while (plateau[colonne - 1][rang] != '.') {
            rang--;
        }
        plateau[colonne - 1][rang] = (i % 2 == 1 ? 'X' : 'O');

        char symbole = (i % 2 == 1 ? 'X' : 'O');
        int max = 0;
        int x;
        int y;
        int somme;

        // Verticale:
        x = colonne - 1;
        y = rang;
        somme = -1;
        while (y >= 0 && plateau[x][y] == symbole) {y--;somme++;}
        y = rang;    
        while (y < L && plateau[x][y] == symbole) {y++;somme++;}
        if (somme > max)max = somme;
                
        
        // Horizontale:
        x = colonne - 1;
        y = rang;
        somme = -1;
        while (x >= 0 && plateau[x][y] == symbole) { x--;somme++; }
        x = colonne - 1;
        while (x < C && plateau[x][y] == symbole) { x++;somme++;}      
        if (somme > max)max = somme;
        
            

        // Diagonale HG-BD
        x = colonne - 1;
        y = rang;
        somme = -1;
        while (y >= 0 && x >= 0 && plateau[x][y] == symbole) {y--;x--;somme++;}
        x = colonne - 1;
        y = rang;
        while (y < L && x < C && plateau[x][y] == symbole) {y++;x++;somme++;}
        if (somme > max)max = somme;
            

        // Diagonale HD-BG
        x = colonne - 1;
        y = rang;
        somme = -1;
        while (y >= 0 && x < C && plateau[x][y] == symbole) {y--;x++;somme++;}
        x = colonne - 1;
        y = rang;
        while (y < L && x >= 0 && plateau[x][y] == symbole) {y++;x--;somme++;}
        if (somme > max)max = somme;
            

        if (max >= N) {gagnant = (i % 2 == 1 ? 1 : 2);i = C * L + 1;}
            
    }
    //La méthode gagnant donne le résultat

    public static void gagnants() {
        plateau();
        System.out.println();
        System.out.println("\n");
        if (gagnant == 0) {
            System.out.println("********EGALITE********");
        } else if (gagnant == 1) {
            System.out.println("*****VICTOIRE DE " + joueur1 + " *****");
        } else if (gagnant == 2) {
            System.out.println("*****VICTOIRE DE " + joueur2 + " *****");
        }

    }
// L'option rejouer 
    public static void rejouer() {
        String oui = "O";
        String non = "N";
        System.out.println();
        System.out.println("Voulez-vous recommencer une partie?\n-O\n-N");
        Scanner sc = new Scanner(System.in);
        reponse = sc.nextLine();
        reponse = reponse.toUpperCase();
        if (reponse.equals(oui)) {
            jeu();
        } if (reponse.equals(non)) { 
            System.out.println("Merci d'avoir joué");
            
        }
    }
    
    //Une méthode qui appelle mes autres méthodes
    public static void jeu() {
        initJeu();
        gagnants();
        rejouer();
        
    }
// Dans le main je n'appelle que 2 méthodes
    public static void main(String[] args) {
        choixJoueurs();
        jeu();
    }

}