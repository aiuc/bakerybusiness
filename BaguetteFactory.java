/**
  * Factory permettant la creation simplifiee d'un pain
*/

public class BaguetteFactory extends Pain {

  private BaguetteFactory () {
    super("Baguette", 1.15, 0, 0, "Traditionnelle");
  }

  public static Pain make() {
    return new BaguetteFactory();
  }

}
  