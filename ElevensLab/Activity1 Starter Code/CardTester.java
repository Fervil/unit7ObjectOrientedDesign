/**
 * This is a class that tests the Card class.
 */
public class CardTester {

    /**
     * The main method in this class checks the Card operations for consistency.
     *  @param args is not used.
     */
    public static void main(String[] args) {
        Card c = new Card("yeah","idk",4);
        Card cd = new Card("yeah","idk",4);
        Card cddd = new Card("yeahddd","dddidk",4);
        System.out.println(c.matches(cd));
        System.out.println(cd.matches(cddd));
    }
}
