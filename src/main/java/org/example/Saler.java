package org.example;

interface SaleCondition {
    boolean execute(Product product);
}

public class Saler {
    SaleCondition saleCondition;
    int saleAmount;

    public Saler(SaleCondition condition, int saleAmount) {
        this.saleCondition = condition;
        this.saleAmount = saleAmount;
    }

    public double getPriceWithSale(Product product) {
        if (this.saleCondition.execute(product)) {
            return product.getPrice() * (1 - ((double)saleAmount / 100));
        }
        return product.getPrice();
    }
}
