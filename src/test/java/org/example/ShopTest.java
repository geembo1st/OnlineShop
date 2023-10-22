package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ShopTest extends TestCase {

    public ShopTest(String name) { super(name);}

    @NotNull
    @Contract(" -> new")
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testAddProduct() {
        Shop shop = new Shop();
        String name = "Apple";
        double price = 10;
        Product apple = new Product(name, price);
        shop.addProduct(apple);
        assertTrue("We added the same product", shop.getProduts().contains(apple));
        Product product = shop.getProduts().first();
        assertEquals("Added product has the same price", price, product.getPrice());
        assertEquals("Added product has the same name", name, product.getName());
    }

    public void testSales() {
        Shop shop = new Shop();
        Saler saler = new Saler(product -> product.getName().contains("футболка"), 10);
        shop.addSale(saler);
        double cupPrice = 300;
        Product cup = new Product("кружка", cupPrice);
        shop.addProduct(cup);
        assertEquals(cupPrice, shop.getPrice());
        double shirtPrice = 1000;
        Product tshirt = new Product("красная футболка", shirtPrice);
        shop.addProduct(tshirt);
        assertEquals(cupPrice + (shirtPrice * 0.9),shop.getPrice());
    }
}
