import java.util.ArrayList;

/**
* Classe principale faisant le lien avec les autres classes
* Cette classe ne possede qu'une seule instance : un singleton
* Permet la simulation de vente au sein de ce singleton
*/

public class Boulangerie {

  /**
  * Attributs et singleton de la classe
  */

  private Object[][] terrain;

  private int nbEmploye, taille, nbMaxGateaux, nbGateaux, nbMaxPains, nbPains, nbMaxSucreries, nbSucreries, nbMaxViennoiseries, nbViennoiseries;

  private double chiffreAffaires, coutMoyGateaux, coutMoyPains, coutMoySucreries, coutMoyViennoiseries;

  private Gateau[] gtab;
  private Pain[] ptab;
  private Sucrerie[] stab;
  private Viennoiserie[] vtab;
  private ArrayList<Employe> etab;
  private Consommateur conso;

  private static Boulangerie singletonBoulangerie = null;
  


  /**
  * Constructeur
  *
  * @param n : taille de la boulangerie
  * @param g : nombre maximum de {@link Gateau}
  * @param p : nombre maximum de {@link Pain}
  * @param s : nombre maximum de {@link Sucrerie}
  * @param v : nombre maximum de {@link Viennoiserie}
  */

  private Boulangerie (int n, int g, int p, int s, int v) {
    taille = n; chiffreAffaires = 0; nbEmploye = 1;
    
    terrain = new Object[taille][taille];

    etab = new ArrayList<Employe> ();
    etab.add(new Employe("Employe"));

    nbMaxGateaux = g; nbGateaux = 0;
    gtab = new Gateau[nbMaxGateaux];

    nbMaxPains = p; nbPains = 0;
    ptab = new Pain[nbMaxPains];

    nbMaxSucreries = s; nbSucreries = 0;
    stab = new Sucrerie[nbMaxSucreries];

    nbMaxViennoiseries = v; nbViennoiseries = 0;
    vtab = new Viennoiserie[nbMaxViennoiseries];
  }



  /**
  * Redefinition de la methode standard toString()
  *
  * @return une chaine de caracteres representant la boulangerie
  */

  @Override
  public String toString() {
    String s = "+";

    for (int k = 0; k < terrain[0].length; k++) {
      s += "-";
    }

    s += "+\n";

    for (int i = 0; i < terrain.length; i++) {
      s += "|";

      for (int j = 0; j < terrain[0].length; j++) {
        if (terrain[i][j] != null) {
          s += (terrain[i][j].toString()).charAt(0);
        }
        else {
          if (i <= taille / 3) {
            s += "*";
          }
          else {
            s += " ";
          }
        }
      }

      s += "|\n";
    }

    s += "+";

    for (int k = 0; k < terrain[0].length; k++) {
      s += " ";
    }
    
    return s + "+";
  }


  /**
  * Remplissage de l'attribut terrain de la boulangerie
  * Selon les tableaux de {@link Consommable}
  */

  public void prepTerrain() {
    for (int i = 0; i < terrain.length; i++) {
      for (int j = 0; j < terrain[0].length; j++) {
        terrain[i][j] = null;
      }
    }

    for (Employe e : etab) {
      if (e != null) {
        terrain[e.getX()][e.getY()] = e;
      }
    }

    if (gtab[0] != null) {
      int xG = gtab[0].getX();
      int yG = gtab[0].getY();
      terrain[xG][yG] = gtab[0];
    }

    if (ptab[0] != null) {
      int xP = ptab[0].getX();
      int yP = ptab[0].getY();
      terrain[xP][yP] = ptab[0];
    }

    if (stab[0] != null) {
      int xS = stab[0].getX();
      int yS = stab[0].getY();
      terrain[xS][yS] = stab[0];
    }

    if (vtab[0] != null) {
      int xV = vtab[0].getX();
      int yV = vtab[0].getY();
      terrain[xV][yV] = vtab[0];
    }
  }


  /**
  * Paiement des employes
  */

  public void payerEmployes() {
    double montant = 0;

    for (Employe e : etab) {
      if (e != null) {
        montant += e.getSalaire();
      }
    }

    chiffreAffaires -= montant;
  }
  

  /**
  * Reinitialisation de l'etat de la boulangerie entre deux "jours"
  *
  * @param xG : abscisse des {@link Gateau}
  * @param yG : ordonnee des {@link Gateau}
  * @param xP : abscisse des {@link Pain}
  * @param yP : ordonnee des {@link Pain}
  * @param xS : abscisse des {@link Sucrerie}
  * @param yS : ordonnee des {@link Sucrerie}
  * @param xV : abscisse des {@link Viennoiserie}
  * @param yV : ordonnee des {@link Viennoiserie}
  */

  public void reinitialiser(int xG, int yG, int xP, int yP, int xS, int yS, int xV, int yV) {
    this.remplirTout();
    Boulangerie.setAllXY(gtab, xG, yG);
    Boulangerie.setAllXY(ptab, xP, yP);
    Boulangerie.setAllXY(stab, xS, yS);
    Boulangerie.setAllXY(vtab, xV, yV);
  }


  /**
  * Methode permettant de simuler
  * la venue d'un consommateur
  */

  public void simuler() {
    int x = (int) (Math.random() * (taille - taille / 2) + taille / 2);
    int y = (int) (Math.random() * taille);

    while (terrain[x][y] != null) {
      x = (int) (Math.random() * (taille - taille / 2) + taille / 2);
      y = (int) (Math.random() * taille);
    }

    conso = new Consommateur("Individu", x, y);
    Strategy s;
    double p = Math.random();

    if (p < 0.6) {
      s = new StrategyDefault();
    }
    else {
      s = new StrategyEnfant();
    }

    this.prepTerrain();
    conso.setStrategy(s);
    terrain[conso.getX()][conso.getY()] = conso;

    System.out.println(this);
    
    conso.acheter();
    chiffreAffaires += conso.payer();
  }



  /**
  * Accesseurs
  */
  
  public static Boulangerie getBoulangerie(int n, int g, int s, int p, int v) {
    if (singletonBoulangerie == null) {
      singletonBoulangerie = new Boulangerie(n,g,s,p,v);
      return singletonBoulangerie;
    }
    return singletonBoulangerie;
  }

  public int getNbGateaux() {
    return nbGateaux;
  }

  public int getNbPains() {
    return nbPains;
  }

  public int getNbSucreries() {
    return nbSucreries;
  }

  public int getNbViennoiseries() {
    return nbViennoiseries;
  }

  public double getChiffreAffaires() {
    return chiffreAffaires;
  }

  public Gateau[] getGTab() {
    return gtab;
  }

  public Pain[] getPTab() {
    return ptab;
  }

  public Sucrerie[] getSTab() {
    return stab;
  }

  public Viennoiserie[] getVTab() {
    return vtab;
  }

  public int getTaille() {
    return taille;
  }

  public Consommateur getConsommateur() {
    return conso;
  }



  /**
  * Mutateurs
  */
  
  public void addEmploye(Employe e) {
    etab.add(new Employe("Employe"));
    nbEmploye++;
  }

  public void decrNbG() {
    nbGateaux--;
  }

  public void decrNbP() {
    nbPains--;
  }

  public void decrNbS() {
    nbSucreries--;
  }

  public void decrNbV() {
    nbViennoiseries--;
  }

  public static void setAllXY(Consommable[] tab, int x, int y) {
    for (Consommable c : tab) {
      if (c != null) {
        c.setXY(x, y);
      }
    }
  }

  public void setParametres(double moyG, double moyP, double moyS, double moyV) {
    coutMoyGateaux = moyG;
    coutMoyPains = moyP;
    coutMoySucreries = moyS;
    coutMoyViennoiseries = moyV;
  }

  public void remplirGateaux() {
    for (int i = nbGateaux; i < gtab.length; i++) {
      gtab[i] = Gateau.make();
      chiffreAffaires -= coutMoyGateaux;
    }
    nbGateaux = gtab.length;
  }
  
  public void remplirPains() {
    for (int i = nbPains; i < ptab.length; i++) {
      ptab[i] = BaguetteFactory.make();
      chiffreAffaires -= coutMoyPains;
    }
    nbPains = ptab.length;
  }
    
  public void remplirSucreries() {
    for (int i = nbSucreries; i < stab.length; i++) {
      stab[i] = Sucrerie.make();
      chiffreAffaires -= coutMoySucreries;
    }
    nbSucreries = stab.length;
  }
  
  public void remplirViennoiseries() {
    for (int i = nbViennoiseries; i < vtab.length; i++) {
      vtab[i] = Viennoiserie.make();
      chiffreAffaires -= coutMoyViennoiseries;
    }
    nbViennoiseries = vtab.length;
  }

  public void remplirTout() {
    this.remplirGateaux();
    this.remplirPains();
    this.remplirSucreries();
    this.remplirViennoiseries();
  }
}
