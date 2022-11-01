# Bakery Business 2021 [fr]
## Schéma UML des classes (vision fournisseur)
![image](https://user-images.githubusercontent.com/117222949/199342879-fcb000cc-44de-485b-8c72-6ef457b276e7.png)


## Présentation rapide du projet 
On considère une unique Boulangerie dont le stock est prédéfini. En saisissant les divers
paramètres (coût moyen d’un pain, nombre de consommateurs moyen par jour, …) et en écrivant
dans un fichier texte les transactions effectuées, le but est de déterminer si la boulangerie est
rentable (chiffre d’affaires positif).

Pour simplifier, on considère un unique article par catégorie de Consommable. Un Consommateur,
dont le comportement est géré par un objet Strategy, achète un certain Consommable selon son
comportement. Sous une certaine probabilité, il est également susceptible de racheter des
Consommables.

La Boulangerie possède un Employé qu’elle paye tous les 30 jours (= simulations).

Les paramètres initiaux ont été pris en accord avec des études de la INBP. 

## Éléments de code Java
- Classe contenant un tableau ou une ArrayList : Boulangerie, Commande
- Classe avec membres et méthodes statiques : BaguetteFactory, Boulangerie, Consommable, Consommateur, Employe, Gateau, Pain, Sucrerie, Viennoiserie
- Classe abstraite et méthode abstraite : Consommable, Personne, Strategy
- Interface : Refaisable
- Classe avec un constructeur par copie ou clone() : Gateau, Pain, Sucrerie, Viennoiserie
- Définition de classe étendant Exception : StockException
- Gestion des exceptions : Consommateur
- Utilisation du pattern singleton : Boulangerie 
