Puissance 4

Description:
Puissance 4 est un jeu de plateau qui se joue à 2 joueurs, le but est d'aligner 4 jetons rouges ou jaunes.
Dans cette version les jetons sont remplacés par des croix et des ronds.
On peut soit jouer contre l'ordianateur, soit contre un autre joueur.

Description de l'implémentation technique du jeu:
Une méthode qui choisit deux joueurs ou un joueur.
Renvoi sur deux méthodes: - choix des prénoms des joueurs    - choix du prénom du joueur qui joue contre l'ordinateur.
Une methode plateau qui materialise la zone de jeu.
Une methode qui initialise la zone de jeu.
Une méthode de jeu avec 2 options: - jeu à 2 joueurs    - jeu contre l'ordinateur en stratégie naîve.
Une methode gagnant qui defini qui gagne ou s'il y a égalité
Une méthode rejouer qui propose si le ou les joueurs souhaitent recommencer une partie avec les memes joueurs.
Une methode jeux qui regroupe toute les méthodes
Le main qui appel la méthode choix des joueurs et jeu.

Notice d'utilisation:
Le joueur choisit s'il veut jouer seul ou à 2:
choix 1, jeu à 2:
-Une question demande le nom du joueur 1, une fois validé il demande le nom du joueur 2.
Une phrase indique le nom des joueurs et le plateau s'initialise en demandant au joueur 1 de choisir un chiffre entre 1 et 7.
choix 2, seul:
-Une question demande le nom du joueur.
Une phrase indique le nom du joueur joue contre l'ordinateur et le plateau s'initialise en demandant au joueur de choisir un chiffre entre 1 et 7.
Le jeu commence:
2 joueurs:
chaque joueurs choisit un chiffre entre 1 et 7 et le plateau se rempli automatiquement.
1 joueur:
Le joueur choisit un chiffre entre 1 et 7 et une croix se met dans le tableau, l'ordinateur chosit un chiffre au hasard et affiche un rond.
Pour finaliser la partie il y a 3 possibilités, soit il y a égalité, soit le joueur 1 gagne, soit le joueur 2.
A la fin de la partie, rejouer oui ou non.
Soit la partie est terminée, soit on recommence une partie avec les mêmes joueurs.

