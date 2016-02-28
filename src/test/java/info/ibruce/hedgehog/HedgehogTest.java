package info.ibruce.hedgehog;

/**
 * Created by bruce-sha on 2016/2/28
 */
public class HedgehogTest {

    public static void main(String[] args) throws Exception {

        final Hedgehog<String> hedgehog = new Hedgehog<String>() {
            @Override
            public String run() {
                return "hello";
            }
        };

        System.out.println(hedgehog.execute());
        System.out.println(hedgehog.async().get());

    }

}
