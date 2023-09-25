package br.com.heinzenberg.heinzenberg.entities;

public class Brand {
    private int brand_id;
    private String name_brand;

    public Brand(int brand_id, String name_brand) {
        this.brand_id = brand_id;
        this.name_brand = name_brand;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public String getName_brand() {
        return name_brand;
    }
}
