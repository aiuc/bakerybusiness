/**
* Classe abstraite definissant le concept de consommable
* Transmet les caracteristiques standards aux consommables specifiques
*/

public abstract class Consommable {

  /**
  * Attributs permettant de definir le consommable
  * Compteur de consommables crees
  */

  private String nom;
  private double prix;
  private int x, y;

  private static int nbConsommables = 0;


  /**
  * Constructeur 01
  *
  * @param n : nom du consommable
  * @param p : prix du consommable
  */

  public Consommable(String n, double p) {
    nom = n;
    prix = p;
    nbConsommables++;
  }


  /**
  * Constructeur 02
  *
  * @param n : nom du consommable
  * @param p : prix du consommable
  * @param x : abscisse du consommable
  * @param y : ordonnee du consommable
  */

  public Consommable(String n, double p, int x, int y) {
    this(n, p);
    this.x = x;
    this.y = y;
  }



  /**
  * Redefinition de la methode standard toString()
  *
  * @return le nom et le prix du consommable
  */

  @Override
  public String toString() {
    return nom + ", Prix : " + prix;
  }


  /**
  * Redefinition de la methode standard equals()
  *
  * @return l'egalite structurelle entre deux consommables
  */

  @Override
  public boolean equals(Object obj) {
    if ((this.getClass() == obj.getClass()) && (this != null)) {
      Consommable c = (Consommable) obj;
      return (nom == c.nom) && (prix == c.prix) && (x == c.x) && (y == c.y);
    }
    return false;
  }


  /**
  * Accesseurs
  */

  public String getNom() {
    return nom;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public double getPrix() {
    return prix;
  }

  public static int getNbConsommables() {
    return nbConsommables;
  }


  /**
  * Mutateur
  */

  public void setXY(int xx, int yy) {
    x = xx; y = yy;
  }


  /**
  * Methode abstraite clone()
  *
  * @return un consommable identique
  */

  public abstract Consommable clone();
}
