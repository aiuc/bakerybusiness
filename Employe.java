public class Employe extends Personne {

  /**
  * Attribut relatif au salaire d'un employe 
  * Compteur d'employes
  */
  
  private static int nbEmployes = 0;
  private double salaire;



  /**
  * Constructeur 01
  *
  * @param n : nom
  * @param b : {@link Boulangerie} affiliee
  * @param s : salaire
  */

  public Employe (String n, double s) {
    super(n + nbEmployes, 0, 0);
    salaire = s;
  }


  /**
  * Constructeur 02
  *
  * @param n : nom
  * @param b : {@link Boulangerie} affiliee
  */

  public Employe (String n) {
    this(n, 1500);
  }



  /**
  * Redefinition de la methode standard toString()
  *
  * @return les caracteristiques de l'employe
  */

  @Override
  public String toString() {
    return "Employe (" + salaire + " euros) : " + super.toString();
  }


  /**
  * Redefinition de la methode standard equals()
  *
  * @return l'egalite structurelle entre deux employes
  */

  @Override
  public boolean equals(Object obj) {
    if ((this != null) && (this.getClass() == obj.getClass())) {
      Employe e = (Employe) obj;
      return super.equals(obj) && (salaire == e.salaire);
    }
    return false;
  }


  /**
  * Accesseur
  */

  public double getSalaire() {
    return salaire;
  }

  public static int getNbEmployes() {
    return nbEmployes;
  }
}
