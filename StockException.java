/**
* Definition d'un nouveau type d'exception
* Vise a empecher l'acces a un consommable indisponible
* Peut egalement servir a empecher un trop plein
*/

public class StockException extends Exception {

  /**
  * Constructeur a un parametre
  *
  * @param message : message specifique destine a l'utilisateur
  */

  public StockException (String message) {
    super(message);
  }


  /**
  * Constructeur standard sans parametre
  */

  public StockException () {
    this("Erreur liee au stock disponible");
  }
}
