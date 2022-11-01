/**
* {@link Personne} achetant un certain nombre d'articles dans la
* {@link Boulangerie} a laquelle elle est affiliee
*/

public class Consommateur extends Personne {

  /**
  * Attributs et compteur
  */

  private double pRachat;
  private Commande cmd;
  private Strategy strategy;
  private static int nbConsommateurs = 0;



  /**
  * Constructeur 01
  *
  * @param n : nom
  * @param b : {@link Boulangerie} affiliee
  * @param pR : probabilite de racheter un {@link Consommable}
  * @param x : abscisse
  * @param y : ordonnee
  */

  public Consommateur (String n, double pR, int x, int y) {
    super(n + ++nbConsommateurs, x, y);
    cmd = new Commande();
    pRachat = pR;
  }


  /**
  * Constructeur 02
  *
  * @param n : nom
  * @param b : {@link Boulangerie} affiliee
  * @param x : abscisse
  * @param y : ordonnee
  */

  public Consommateur (String n, int x, int y) {
    this(n, Math.random(), x, y);
  }



  /**
  * Redefinition de la methode standard toString()
  *
  * @return les caracteristiques du consommateur
  */

  @Override
  public String toString() {
    return "Consommateur : " + super.toString();
  }


  /**
  * Redefinition de la methode standard equals()
  *
  * @return l'egalite des attributs entre deux consommateurs
  */

  @Override
  public boolean equals(Object obj) {
    if ((this != null) && (this.getClass() == obj.getClass())) {
      Consommateur c = (Consommateur) obj;
      return super.equals(obj) && (pRachat == c.pRachat) && (strategy.equals(c.strategy)) && (cmd.equals(c.cmd));
    }
    return false;
  }

  
  /**
  * Ajout d'un consommable dans le tableau dynamique cmd
  *
  * @param tab : tableau duquel est pris le {@link Consommable}
  * @param cpt : quantite actuelle de ce type de {@link Consommable}
  */

  public boolean ajouter(Consommable[] tab, int cpt) {
    Consommable c;

    try {
      switch (cpt) {
        case 0:
          throw new StockException("Stock insuffisant");

        case 1:
          if (tab[0] instanceof Refaisable) {
            ((Refaisable) tab[0]).refaire();

            Boulangerie.setAllXY(tab, tab[0].getX(), tab[0].getY());

            c = tab[tab.length-1];
            tab[tab.length-1] = null;
          }

          else {
            c = tab[0];
            tab[0] = null;
          }
          cmd.ajouterConsommable(c);
          return true;
          
        default:
          c = tab[cpt-1];
          tab[cpt-1] = null;
          cmd.ajouterConsommable(c);
          return true;
      }
    }

    catch (StockException e) {
      return false;
    }
  }


  /**
  * Application du comportement defini dans l'objet {@link Strategy}
  */

  public void acheter() {
    strategy.acheter(this);
  }


  /**
  * Calcul du montant de la commande
  */

  public double payer() {
    return cmd.montantTot();
  }


  /**
  * Accesseurs
  */

  public Commande getCommande() {
    return cmd;
  }
  
  public double getPRachat() {
    return pRachat;
  }

  public static int getNbConsommateurs() {
    return nbConsommateurs;
  }


  /**
  * Mutateur
  */
  
  public void setStrategy(Strategy s) {
    strategy = s;
  }
}
