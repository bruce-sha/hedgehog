package java8.lambda;

/**
 * Created by bruce-sha on 2016/2/28
 */
public class Item {
    String code;

    public Item() {
    }

    public Item(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
