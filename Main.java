import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

/*
 Classe Main servant a la demonstration
 et a l'utilisation des diverses fonctionnalites
*/

public class Main {

  public static void main(String[] args) throws InterruptedException, IOException {
    
    /**
    * Parametres initiaux : 305, 6.05, 0.76, 0.99, 2.15
    * Boulangerie : 7, 12, 50, 100, 20
    */


    /**
    * Preparation de l'ecriture dans le fichier "LivreComptes.txt"
    */

    double[] ag = new double[6];
    int index = 0;
    String s;

    File file = new File("LivreComptes.txt");

    if (!file.exists()) {
      file.createNewFile();
    }

    BufferedWriter bw = new BufferedWriter(new FileWriter(file));


    /**
    * Saisie des parametres initiaux
    */
    
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    System.out.println("Nombre de simulations ?");
    ag[index++] = scanner.nextDouble();

    System.out.println("Nombre de consommateurs ?");
    ag[index++] = scanner.nextDouble();

    System.out.println("Cout moyen d'un gateau ?");
    ag[index++] = scanner.nextDouble();

    System.out.println("Cout moyen d'un pain ?");
    ag[index++] = scanner.nextDouble();

    System.out.println("Cout moyen d'une sucrerie ?");
    ag[index++] = scanner.nextDouble();

    System.out.println("Cout moyen d'une viennoiserie ?");
    ag[index++] = scanner.nextDouble();
    
    scanner.close();
    

    /**
    * Initialisation du contexte
    */
    
    Boulangerie b = Boulangerie.getBoulangerie(7, 12, 50, 100, 20);
    b.setParametres(ag[2], ag[3], ag[4], ag[5]);
    double cA = b.getChiffreAffaires();
    double gain;


    /**
    * Simulations (boucles imbriquees)
    */

    for (int cpt = 1; cpt <= ag[0]; cpt++) {
      // Positionnement des consommables
      b.reinitialiser(3, 2, 3, 1, 5, 0, 3, 6);

      s = "=== SIMULATION NO " + cpt + " ===\n\n";
      bw.write(s);

      for (int nbConsommateur = 1; nbConsommateur <= ag[1]; nbConsommateur++) {
        b.simuler();

        Consommateur c = b.getConsommateur();
        Commande cmd = c.getCommande();
        double montantTot = c.payer();

        s = nbConsommateur + "\t" + cmd + "\t" + String.format("%.2f euros\n\n", montantTot);
        bw.write(s);

        System.out.print("\n");
        
        Thread.sleep(250);
      }

      if (cpt % 30 == 0) {
        b.payerEmployes();
      }
      
      gain = Math.abs(Math.abs(b.getChiffreAffaires()) - Math.abs(cA));
      cA = b.getChiffreAffaires();

      s = String.format("\n---\nCA (continu) : %.2f euros\n\n\n\n\n", cA) + "";
      bw.write(s);

      System.out.println(String.format("\nChiffre d'affaires total a l'issue de la simulation %d : %.2f euros", cpt, cA));

      System.out.println(String.format("Gain : %.2f euros\n\n", gain));

      Thread.sleep(500);
    }
    bw.close();
  } 
}