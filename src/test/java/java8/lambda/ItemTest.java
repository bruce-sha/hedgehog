package java8.lambda;

/**
 * Created by bruce-sha on 2016/2/28
 */
public class ItemTest {
    public static void main(String[] args) {

        ItemFactory factory = Item::new;
        Item a = factory.create("a");

        System.out.println(a);

        someWork(Item::new);
    }


    static void someWork(ItemFactory factory) {
        Item b = factory.create("b");
        System.out.println(b);

    }
}
