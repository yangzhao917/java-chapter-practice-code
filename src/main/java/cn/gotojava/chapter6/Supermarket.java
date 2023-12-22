package cn.gotojava.chapter6;

import java.util.ArrayList;
import java.util.List;

/**
 * description：超市类
 *
 * @author yangzhao
 * @createBy 2023/12/22
 */
public class Supermarket {

    /**
     * 使用面向对象的概念表示出下面的生活场景：
     * 小明去超市买东西，所有买到的东西都放在了购物车之中，最后到收银台一起结账
     * @param args
     */
    public static void main(String[] args) {
        // 创建商品
        Product apple = new Product("苹果", 20.0);
        Product orange = new Product("橘子", 20.0);
        Product banana = new Product("香蕉", 20.0);
        Product mango = new Product("芒果", 20.0);

        // 创建购物车，添加商品到购物车
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(apple);
        shoppingCart.addItem(orange);
        shoppingCart.addItem(banana);
        shoppingCart.addItem(mango);

        // 结账
        double totalAmount = shoppingCart.calculateTotal();
        System.out.println(String.format("购买商品%s种，总金额：%s", shoppingCart.getItems().size(), totalAmount));
    }

}

/**
 * 购物车类
 */
class ShoppingCart {

    private List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    /**
     * 添加商品到购物车
     * @param product 商品实例
     */
    public void addItem(Product product) {
        items.add(product);
    }

    public List<Product> getItems(){
        return items;
    }

    /**
     * 计算总金额
     * @return
     */
    public double calculateTotal(){
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
}


/**
 * 商品类
 */
class Product {
    // 商品名称
    private String name;
    // 商品价格
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }
}
