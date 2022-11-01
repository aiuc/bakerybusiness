import java.util.ArrayList;

/**
* Classe permettant de stocker les articles d'un consommateur
* Les articles sont des objets {@link Consommable}
*/

public class Commande {

  /**
  * Tableau dynamique des consommables
  */

  private ArrayList<Consommable> cmd;



  /**
  * Constructeur sans parametre
  */

  public Commande () {
    cmd = new ArrayList<Consommable> ();
  }



  /**
  * Redefinition de la methode standard toString() 
  * pour afficher le contenu de la commande
  *
  * @return le contenu (textuel) de la commande
  */

  @Override
  public String toString() {
    String s = "[";
    for (int i = 0; i < cmd.size(); i++) {
      if (i == cmd.size() - 1) {
        s += cmd.get(i).toString();
      }
      else {
        s += cmd.get(i).toString() + "; ";
      }
    }
    return s + "]";
  }


  /**
  * Redefinition de la methode standard equals()
  *
  * @return l'egalite structurelle de deux commandes
  */

  @Override
  public boolean equals(Object obj) {
    if ((this != null) && (this.getClass() == obj.getClass())) {
      Commande cm = (Commande) obj;
      if (cmd.size() == cm.cmd.size()) {
        for (int i = 0; i < cmd.size(); i++) {
          if (!(cmd.get(i).equals(cm.cmd.get(i)))) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }


  /**
  * Ajout d'un consommable dans la commande
  *
  * @param c : consommable a ajouter
  */

  public void ajouterConsommable(Consommable c) {
    if (c != null) {
      cmd.add(c);
    }
  }


  /**
  * Calcul du montant total des articles dans la commande
  *
  * @return : la somme des prix de chaque article
  */

  public double montantTot() {
    double montant = 0;
    for (int i = 0; i < cmd.size(); i++) {
        montant += cmd.get(i).getPrix();
    }
    return montant;
  }
}
