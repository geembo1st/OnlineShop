package org.example;

import java.util.ArrayList;
import java.util.TreeSet;

public class Shop {
    private TreeSet<Product> productTreeSet;

    private ArrayList<Saler> activeSales;
    public Shop() {
        productTreeSet = new TreeSet<>();
        activeSales = new ArrayList<>();
    }
    public void addProduct(Product product) {
        productTreeSet.add(product);
    }
    public TreeSet<Product> getProduts() {
        return this.productTreeSet;
    }

    public void addSale(Saler sale) {
        this.activeSales.add(sale);
    }

    public void printProduct() {
        System.out.println(productTreeSet);
    }
    public double getPrice() {
        int price=0;
        for(Product product:productTreeSet){
            double minPrice = product.getPrice();
            for (Saler sale:activeSales) {
                double priceWithSale = sale.getPriceWithSale(product);
                if (minPrice > priceWithSale) {
                    minPrice = priceWithSale;
                }
            }
            price += minPrice;
        }
        return price;
    }
}
