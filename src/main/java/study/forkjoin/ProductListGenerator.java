package study.forkjoin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaolb on 2018/1/19.
 */
public class ProductListGenerator {
    public List<Product> generate(int size){
        List<Product> ret = new ArrayList<Product>();
        for (int i = 0; i < size; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
