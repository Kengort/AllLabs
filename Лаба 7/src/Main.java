import com.example.shoes.Shoe;
import com.example.shoes.Sneakers;
import com.example.shoes.Boots;

public class Main {
    public static void main(String[] args) {
        Shoe sneakers = new Sneakers("Nike", 42.5, true);
      //  Shoe object = new Shoe ("Nike", 32, true)
       // Shoe boots = new Boots("Timberland", 43, 25);

        System.out.println("=== Демонстрация полиморфизма ===");
        wearShoe(sneakers);
        System.out.println();
       // wearShoe(boots);

        System.out.println("\n=== Прямая работа с объектами ===");
        Sneakers mySneakers = new Sneakers("Adidas", 41, false);
      //  Boots myBoots = new Boots("CAT", 44, 30);

        mySneakers.wear();
        mySneakers.run();

        System.out.println();

        //myBoots.wear();
        //myBoots.walkInMud();
    }

    public static void wearShoe(Shoe shoe) {
        shoe.putOn();
        shoe.wear();
    }
}