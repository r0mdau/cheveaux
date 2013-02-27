
## 1.0.0 (27 Février 2013)

Première version fonctionnelle du jeu des petits cheveaux.

- **Modes de jeux:**
  - **Manuel par défaut** chaque joueur déclaré sur le plateau doit choisir après lancé du dé automatique un pion à faire avancer..
  - **Automatique**, après avoir créer les joueurs, la partie se joue tout seule. Cela permet de vérifier rapidement si le programme tourne dans sa totalité. Ainsi on obtient rapidement le joueur gagnant.
- **Erreurs de saisies**
  - Si l'utilisateur fait des erreurs de saisies, les valeurs adéquates au bon fonctionnement du programme sont appliquées contre son grès. Si par exemple il saisit 5 joueurs, alors le programme limite à 4 joueurs.

## TODO :
1. Il faut retourner un booleen afin de savoir si le pion a pu avancer ou non. Tant que le pion n'a pas pu avancer, alors on choisit un autre pion.
2. IA : le jeu possède déjà un mode automatique. Il faut optimiser ce mode afin de finir les parties en un nombre minime de lancés de dé, malgrès que le résultat du dé soit aléatoire.
3. Récupérer une entrée clavier (ex : Echap) qui permettrai au jeu de s'arrêter en utilisant la méthode Partie.quitter() et dans le main utiliser la méthode Partie.quitte() qui renvoit un booleen pour arrêter la boucle do ... while.
4. La partie s'arrête lorsqu'un joueur à fini la course de tout ses pions. Il faudrait qu'elle continue afin d'avoir un classement d'arrivée lorsque la partie contient + de 2 joueurs.
5. Interface graphique.
6. Lots of things ...
