/**
* Cas particulier de {@link Consommable} possedant un certain gout
* Sucrerie est {@link Refaisable} : reapprovisionnement possible
*/

public class Sucrerie extends Consommable implements Refaisable {

  /**
  * Attribut et compteur
  */

  private String gout;
  private static int cptS = 0;


  /**
  * Constructeur
  *
  * @param n : nom
  * @param p : prix
  * @param x : abscisse
  * @param y : ordonnee
  * @param g : gout
  */

  public Sucrerie (String n, double p, int x, int y, String g) {
    super(n, p, x, y);
    gout = g;
    cptS++;
  }



  /**
  * Redefinition de la methode standard toString()
  *
  * @return les caracteristiques d'une sucrerie
  */

  @Override
  public String toString() {
    return "Sucrerie : " + gout + ", " + super.toString();
  }

  
  /**
  * Redefinition de la methode standard equals()
  *
  * @return l'egalite structurelle entre deux sucreries
  */

  @Override
  public boolean equals(Object obj) {
    if ((this.getClass() == obj.getClass()) && (this != null)) {
      Sucrerie s = (Sucrerie) obj;
      return super.equals(obj) && (gout == s.gout);
    }
    return false;
  }


  /**
  * Redefinition de la methode refaire() de l'interface Refaisable
  *
  * @param tab : tableau de sucreries a remplir
  */

  @Override
  public void refaire() {
    Boulangerie b = Boulangerie.getBoulangerie(0, 0, 0, 0, 0);
    b.remplirSucreries();
  }


  /*
  * Factory permettant la creation simplifiee d'une sucrerie 
  *
  * @return une sucrerie predefinie
  */

  public static Sucrerie make() {
    return new Sucrerie ("Paquet de carambars", 2.44, 0, 0, "Citron");
  }


  /* 
  * Accesseur
  */

  public static int getCptS() {
    return cptS;
  }


  /*
  * Mutateur
  */

  public static void setCptS(int n) {
    cptS = n;
  }


  /**
  * Redefinition de la methode abstraite clone()
  *
  * @return une sucrerie identique
  */

  public Sucrerie clone() {
    return new Sucrerie(this.getNom(), this.getPrix(), this.getX(), this.getY(), gout);
  }
}
