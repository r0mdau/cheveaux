# Jeux des petits cheveaux

## Projet
Langages Orientés Objets : `Java`

## Auteurs
* [Thomas Lorenzato](https://github.com/thomasgheberg/)
* [Romain Dauby](https://github.com/r0mdau/)

## Dates de début
* Début du projet : 01/02/2013
* Date remise du projet : 01/03/2013

## Technique de développement du projet
Test Driven Development

## Git Source du projet : 
En lecture seule.
[http://git.romaindauby.fr/cheveaux](http://git.romaindauby.fr/cheveaux)

## Contraintes techniques du projet :
* Le fichier .classpath est propre à chaque environnement pour inclure la librairie JUnit afin de lancer les tests unitaires. IL est ajouté dans le .gitignore pour ne pas interférer les commit entre les différents OS. Demandez aux administrateurs du projet si vous souhaitez récupérer un exemple.
* Afin de répondre au mieux au découpage objet qui est l'objectif principal de ce projet, chaque case du plateau est instanciée en tant qu'objet unique. Pour des raisons d'optimisations (rapidité du programme et mémoire système), nous devrions utiliser une collection d'entiers plutôt qu'une collection d'objets.
* Nous utilisons des collections de type ArrayList car elles sont rapides en lecture et lentes en écriture par rapport aux LinkedList. Ici, nous ne faisons que des lectures dans ces tableaux d'objets.

## Démarrage rapide :
* [Télécharger la dernière version](http://git.romaindauby.fr/cheveaux)
* Cloner le repo : `git clone http://git.romaindauby.fr/cheveaux`.
* Importer le dossier `cheveaux` dans le Workspace en tant que projet existant dans Eclipse
* Lancer le jeu

## Bug tracker

Si vous avez des question ou des bugs sur le projet, [merci d'ouvrir un ticket](https://github.com/r0mdau/cheveaux/issues). Avant d'ouvrir un ticket, merci de vérifier que la réponse à votre demande n'a jamais été traitée.

## Communauté

Rester à la page sur le développement du projet et les nouveautés de la communauté.

* Suivez [@r0mdau sur Twitter](http://twitter.com/r0mdau)
* Ou bien [@thomasGheberg sur Twitter](https://twitter.com/thomasGheberg)

## Copyright and license

Copyright 2013 r0mdau, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this work except in compliance with the License.
You may obtain a copy of the License in the LICENSE file, or at:

  [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
