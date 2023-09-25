package br.com.heinzenberg.heinzenberg.entities;

public class Product {
    private int sku;
    private String name;
    private int brandId;

    public Product(int sku, String name, int brandId) {
        this.sku = sku;
        this.name = name;
        this.brandId = brandId;
    }

    public Product(){

    }

    public int getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public int getBrandId() {
        return brandId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku=" + sku +
                ", name='" + name + '\'' +
                ", brandId=" + brandId +
                '}';
    }
}
