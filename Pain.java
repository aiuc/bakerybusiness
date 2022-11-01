/**
* Cas particulier de {@link Consommable} ayant une forme specifique
* Pain est {@link Refaisable} : le stock de pains peut etre reassorti
*/

public class Pain extends Consommable implements Refaisable {

  /**
  * Attribut et compteur
  */

  private String forme;
  private static int cptP = 0;

  
  /**
  * Constructeur
  *
  * @param n : nom
  * @param p : prix
  * @param x : abscisse
  * @param y : ordonnee
  * @param f : forme
  */

  public Pain (String n, double p, int x, int y, String f) {
    super(n, p, x, y);
    forme = f;
    cptP++;
  }



  /**
  * Redefinition de la methode standard toString()
  *
  * @return les caracteristiques du pain
  */

  @Override
  public String toString() {
    return "Pain : " + forme + ", " + super.toString();
  }


  /**
  * Redefinition de la methode standard equals()
  *
  * @return l'egalite stricturelle entre deux pains
  */

  @Override
  public boolean equals(Object obj) {
    if ((this.getClass() == obj.getClass()) && (this != null)) {
      Pain p = (Pain) obj;
      return super.equals(obj) && (forme == p.forme);
    }
    return false;
  }


  /**
  * Redefinition de la methode refaire() de l'interface {@link Refaisable}
  *
  * @param tab : le tableau de pains a remplir
  */

  @Override
  public void refaire() {
    Boulangerie b = Boulangerie.getBoulangerie(0, 0, 0, 0, 0);
    b.remplirPains();
  }


  /**
  * Accesseur
  */

  public static int getCptP() {
    return cptP;
  }


  /**
  * Mutateur
  */

  public static void setCptP(int n) {
    cptP = n;
  }


  /**
  * Redefinition de la methode abstraite clone()
  *
  * @return un pain identique
  */

  public Pain clone() {
    return new Pain(this.getNom(), this.getPrix(), this.getX(), this.getY(), forme);
  }
}