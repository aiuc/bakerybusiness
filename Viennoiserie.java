/**
* Cas particulier d'un {@link Consommable} a la pate particuliere
*/

public class Viennoiserie extends Consommable {

  /**
  * Attribut et compteur
  */

  private String pate;
  private static int cptV = 0;


  /**
  * Constructeur
  *
  * @param n : nom
  * @param p : prix
  * @param x : abscisse
  * @param y : ordonnee
  * @param pa : pate
  */

  public Viennoiserie (String n, double p, int x, int y, String pa) {
    super(n, p, x, y);
    pate = pa;
    cptV++;
  }



  /**
  * Redefinition de la methode standard toString()
  *
  * @return les caracteristiques d'une viennoiserie
  */

  @Override
  public String toString() {
    return "Viennoiserie : " + pate + ", " + super.toString();
  }


  /**
  * Redefinition de la methode standard equals()
  *
  * @return l'egalite structurelle entre deux viennoiseries
  */

  @Override
  public boolean equals(Object obj) {
    if ((this.getClass() == obj.getClass()) && (this != null)) {
      Viennoiserie v = (Viennoiserie) obj;
      return super.equals(obj) && (pate == v.pate);
    }
    return false;
  }


  /**
  * Factory permettant la creation simplifiee d'une viennoiserie 
  *
  * @return une viennoiserie predefinie
  */

  public static Viennoiserie make() {
    return new Viennoiserie ("Pain suisse", 1.95, 0, 0, "Feuilletee");
  }


  /**
  * Accesseur
  */

  public static int getCptV() {
    return cptV;
  }


  /**
  * Mutateur
  */

  public static void setCptV(int n) {
    cptV = n;
  }


  /**
  * Redefinition de la methode abstraite clone()
  *
  * @return une viennoiserie identique
  */

  public Viennoiserie clone() {
    return new Viennoiserie(this.getNom(), this.getPrix(), this.getX(), this.getY(), pate);
  }
}
