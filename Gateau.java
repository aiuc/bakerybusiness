/**
* Cas particulier de {@link Consommable} ayant une saveur
*/

public class Gateau extends Consommable {

  /**
  * Attribut et compteur
  */

  private String saveur;
  private static int cptG = 0;



  /**
  * Constructeur
  *
  * @param n : nom
  * @param p : prix
  * @param x : abscisse
  * @param y 
  */

  public Gateau (String n, double p, int x, int y, String s) {
    super(n, p, x, y);
    saveur = s;
    cptG++;
  }



  /**
  * Redefinition de la methode standard toString()
  *
  * @return les caracteristiques du gateau
  */

  @Override
  public String toString() {
    return "Gateau : " + saveur + ", " + super.toString();
  }


  /**
  * Redefinition de la methode standard equals()
  *
  * @return l'egalite structurelle entre deux gateaux
  */

  @Override
  public boolean equals(Object obj) {
    if ((this.getClass() == obj.getClass()) && (this != null)) {
      Gateau g = (Gateau) obj;
      return super.equals(obj) && (saveur == g.saveur);
    }
    return false;
  }


  /**
  * Factory permettant la creation aisee d'un gateau
  *
  * @return un gateau predefini
  */

  public static Gateau make() {
    return new Gateau ("Galette des rois", 25, 0, 0, "Frangipane");
  }
  

  /**
  * Accesseur
  */

  public static int getCptG() {
    return cptG;
  }


  /**
  * Mutateur
  */

  public static void setCptG(int n) {
    cptG = n;
  }


  /**
  * Redefinition de la methode abstraite clone()
  *
  * @return un gateau identique
  */

  public Gateau clone() {
    return new Gateau(this.getNom(), this.getPrix(), this.getX(), this.getY(), saveur);
  }
}
