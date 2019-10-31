/**
 * @Rob the bear
 * Puissance 4 Simplon
 */

import java.util.*;
/**
 * déclaration de toutes les variables utiles dans les différentes méthodes
 */
public class Puissance4 {
    int choix;
    String joueur1 = "";
    String joueur2 = "";
    int N;
    int L;
    int C;
    char[][] plateau;
    int i;
    String ligne = "";
    int gagnant;
    int o;
    int low;
    int high;
    int choix1;
    int choix2;
    String reponse = " ";
    int infoIa;

    Puissance4(){

    };

   
    /**
     * Méthode qui donne le choix de un ou 2 joueurs
     * @return sur la méthode jouers ou ordinateur
     */

    public void choixJoueurs() {
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
 * Choix des prénoms des joueurs 
 * @return les prénoms seront utilisés pendant toute la partie
 */
    public void joueurs() {
        System.out.println("Entrer le nom du joueur 1: ");
        Scanner j1 = new Scanner(System.in);
        joueur1 = j1.nextLine();
        System.out.println("Entrer le nom du joueur 2: ");
        Scanner j2 = new Scanner(System.in);
        joueur2 = j2.nextLine();
        System.out.println("Le joueur 1 est " + joueur1 + ", et le joueur 2 est " + joueur2 + ".");

    }
    /**
     * Choix du prénom du joueur, le joueur 2 est l'ordinateur
     */

    public void ordinateur() {
        System.out.println("Entrer le nom du joueur: ");
        Scanner j1 = new Scanner(System.in);
        joueur1 = j1.nextLine();
        joueur2 = "Ordinateur";
        System.out.println("Le joueur est " + joueur1 + ", et il joue avec l'" + joueur2 + ".");

    }
    /**
     * Initialisation du plateau de jeu
     */
    public void initJeu() {
        /**Je donne une valeur au 3 variables, 
        * N qui est le nombre de jetons alignés pour gagner, C la taille de la colonne et L la taille de la ligne.
        * Ce qui permet de faire un puissance 3, 5, 10, etc... en changeant ces valeurs.
        */
        N = 4;
        C = 7;
        L = 6;
        /**
         * parcours dans une boucle tous les emplacements du tableau à 2 entrées et y met un point.
         */
        plateau = new char[C][L];
        for (int x = 0; x < C; x++)
            for (int y = 0; y < L; y++)
                plateau[x][y] = '.';

    /**
     * debut de la partie avec l'affichage du tableau et la proposition de jeu en nommant le joueur.
     */
        for (i = 1; i <= C * L; i++) {
            plateau();
            System.out.println();
            System.out.println((i % 2 == 1 ? joueur1 : joueur2) + " choisis un chiffre entre 1 et " + C + "...");
            System.out.println();
            methodeDeJeu();
            
        }
        
    }
    /**
     * formatage du tour de plateau
     * le plateau est utilisé plusieurs fois, une seule méthode à appeler
     */
    
    public void plateau() {
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
    /**
     * Méthode de jeu naive avec l'ordinateur
     * @return un chiffre aléatoire entre 1 et 7;
     */

    public int random() {
        high = 7;
        low = 1;
        return ((int) (Math.random() * (high + 1 - low)) + low);
    }
    /**
     * Tentative d'ia, il récupère le chiffre saisie par l'utilisateur
     * @return donne un chiffre aléatoire autour de ce chiffre
     */
    public int ia() {
    
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
 * methode de jeu
 */
    public void methodeDeJeu() {
        
        boolean placement = false;//boolean qui permet de verifier le placement du jeton
        int colonne = -1;
        Scanner sc = new Scanner(System.in);
        //boucle while pour tester si les informations saisies sont juste
        while (!placement) {
            //condition si choix ordinateur ou 2 joueurs
            if (choix == choix1)
                ligne = sc.nextLine();
            if (choix == choix2) {
                // Condition qui permet un jeu alternatif entre ordi et joueur
                if (i % 2 == 1){
                    ligne = sc.nextLine();
                    infoIa = Integer.valueOf(ligne);}//variable utilisé pour l'ia mais pas convaincante
                else 
                    ligne = String.valueOf(random());
            }
            try {
                //permet de savoir si la saisie est un nombre entier
                colonne = Integer.valueOf(ligne);
                if (colonne >= 1 && colonne <= C) {
                    //permet de savoir si l'emplacement choisi est un point ou un symbol
                    if (plateau[colonne - 1][0] != '.') {
                        // si ça n'est pas un point il propose de rejouer
                        System.out.println("Colonne pleine! Rejouez!");
                    } else {//sinon il donne le placement vrai et il place le symbole
                        placement = true;

                    }

                } else {//si c'est un chiffre mais pas entre 1 et 7
                    System.out.println("Choisir un chiffre entre 1 et "+C+" est si compliqué??? \n\nRejouez!!!!");
                }

            } catch (Exception e) {//si c'est autre chose
                System.out.println("Pas autre chose qu'un chiffre entre 1 et "+C+"!!!! \n\nRejouez!!!!");

            }
        }
        //On retire 1 à rang pour partir à 1 et non à 0
        int rang = L - 1;
        //Si ça n'est pas un . on décrémente rang
        while (plateau[colonne - 1][rang] != '.') {
            rang--;
        }//Si ce n'est pas un point c'est un symbole
        plateau[colonne - 1][rang] = (i % 2 == 1 ? 'X' : 'O');
        //Choix du type de symbole en fonction du nombre restant de cases vides
        char symbole = (i % 2 == 1 ? 'X' : 'O');
        int max = 0;
        int x;
        int y;
        int somme;
        // test les différentes possibilitées pour trouver un gagnant
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
    /*
    * La méthode gagnant donne le résultat
    **/

    public void gagnants() {
        //je lance la méthode plateau pour afficher le plateau après le dernier choix
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
    /**
     * L'option rejouer 
     */
    public void rejouer() {
        String oui = "O";
        String non = "N";
        System.out.println();
        System.out.println("Voulez-vous recommencer une partie?\n-O\n-N");
        Scanner sc = new Scanner(System.in);
        reponse = sc.nextLine();
        //il transforme la lettre en majuscule au cas où
        reponse = reponse.toUpperCase();
        if (reponse.equals(oui)) {
            jeu();
        } if (reponse.equals(non)) { 
            System.out.println("Merci d'avoir joué");
            
        }
    }
    
    /**
     * Une méthode qui appelle mes autres méthodes
     */
    public void jeu() {
        initJeu();
        gagnants();
        rejouer();
        
    }
// Dans le main je n'appelle que 2 méthodes
    public static void main(String[] args) {
        //je créé un exemplaire de mon objet pour appeler les méthodes de mon objet
        Puissance4 monPuissance4 = new Puissance4();
        
        monPuissance4.choixJoueurs();
        monPuissance4.jeu();
    }

}