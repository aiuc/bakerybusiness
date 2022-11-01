/**
* Comportement par defaut d'un consommateur
*/

public class StrategyDefault extends Strategy {
  
  /**
  * Constructeur vide
  */

  public StrategyDefault () {}



  /**
  * Redefinition de la methode standard toString()
  *
  * @return le type de strategie
  */

  @Override
  public String toString() {
    return super.toString() + " par defaut";
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
  * @param c : consommateur dont le comportement est a simuler
  */

  @Override
  public void acheter(Consommateur c) {
    double pR = c.getPRachat();
    Boulangerie b = Boulangerie.getBoulangerie(0, 0, 0, 0, 0);
    boolean bool;

    bool = c.ajouter(b.getPTab(), b.getNbPains());
    if (bool) {
      b.decrNbP();
    }

    for (double p = Math.random(); p <= pR; p *= 1.5) {
      bool = c.ajouter(b.getPTab(), b.getNbPains());
      if (bool) {
        b.decrNbP();
      }
    }


    for (double p = Math.random(); p <= pR; p *= 1.8) {
      double p2 = Math.random();

      if (p2 <= 0.33) {
        bool = c.ajouter(b.getGTab(), b.getNbGateaux());
        if (bool) {
          b.decrNbG();
        }
      }

      bool = c.ajouter(b.getVTab(), b.getNbViennoiseries());
      if (bool) {
        b.decrNbV();
      }
    }
  }
}
