/**
* Comportement d'un consommateur designe comme un enfant
*/

public class StrategyEnfant extends Strategy {

  /**
  * Constructeur vide
  */

  public StrategyEnfant () {}



  /**
  * Redefinition de la methode standard toString()
  *
  * @return le type de la strategie
  */

  @Override
  public String toString() {
    return super.toString() + " enfant";
  }


  /**
  * Redefinition de la methode standard equals()
  *
  * @return si deux strategies sont de meme type
  */

  @Override
  public boolean equals(Object obj) {
    if ((this != null) && (this.getClass() == obj.getClass())) {
      return super.equals(obj);
    }
    return false;
  }


  /**
  * Redefinition de la methode abstraite acheter()
  *
  * @param c : consommateur dont le comportement est celui d'un enfant
  */

  @Override
  public void acheter(Consommateur c) {
    double pR = c.getPRachat();
    Boulangerie b = Boulangerie.getBoulangerie(0, 0, 0, 0, 0);
    boolean bool;

    bool = c.ajouter(b.getSTab(), b.getNbSucreries());
    if (bool) {
      b.decrNbS();
    }
    
    for (double p = Math.random(); p <= pR; p *= 1.2) {
      bool = c.ajouter(b.getSTab(), b.getNbSucreries());
      if (bool) {
        b.decrNbS();
      }
    }
  }
}
