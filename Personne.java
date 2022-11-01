public abstract class Personne {

  /**
  * Attributs relatifs a l'identite de la personne
  * Une personne est affiliee a une {@link Boulangerie}
  */
  
  private String nom;
  private int x, y;


  /**
  * Constructeur
  *
  * @param n : nom
  * @param b : {@link Boulangerie} affiliee
  * @param xx : abscisse
  * @param yy : ordonnee
  */

  public Personne (String n, int xx, int yy) {
    nom = n;
    x = xx;
    y = yy;
  }



  /**
  * Redefinition de la methode standard toString()
  *
  * @return le nom de l'individu
  */

  @Override
  public String toString() {
    return nom;
  }


  /**
  * Redefinition de la methode standard equals()
  *
  * @return l'egalite identitaire entre deux individus
  */

  @Override
  public boolean equals(Object obj) {
    if ((this != null) && this.getClass() == obj.getClass()) {
      Personne p = (Personne) obj;
      return (nom == p.nom) && (x == p.x) && (y == p.y);
    }
    return false;
  }


  /**
  * Accesseurs
  */

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
