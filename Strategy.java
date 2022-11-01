/**
* Pattern ayant pour vocation la gestion du comportement des consommateurs
* La classe abstraite permet de definir des comportements plus specifiques
* dans les classes filles
*/

public abstract class Strategy {

  /**
  * Constructeur vide
  */

  public Strategy () {}



  /**
  * Redefinition de la methode standard toString()
  *
  * @return le nom du pattern
  */

  @Override
  public String toString() {
    return "Strategie";
  }
  

  /**
  * Redefinition de la methode standard equals()
  *
  * @return l'egalite structurelle entre deux strategies
  */

  @Override
  public boolean equals(Object obj) {
    if ((this != null) && (this.getClass() == obj.getClass())) {
      return true;
    }
    return false;
  }


  /**
  * Methode abstraite forcant l'inclusion du comportement "acheteur"
  * du consommateur
  *
  * @param c : consommateur dont l'attribut strategy utilise la methode
  */

  public abstract void acheter(Consommateur c);
}
