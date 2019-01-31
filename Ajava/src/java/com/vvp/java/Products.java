/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;

import java.util.HashMap;

/**
 *
 * @author Mishil
 */
public class Products {
    int pid,stock;
    double price;
    String ProductName,Description,images;

    public Products(int pid, int stock, double price, String ProductName) {
        this.pid = pid;
        this.stock = stock;
        this.price = price;
        this.ProductName = ProductName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static HashMap<Integer, Products> getProducts() {
        return products;
    }

    public static void setProducts(HashMap<Integer, Products> products) {
        Products.products = products;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    static HashMap<Integer,Products> products = new HashMap<Integer, Products>();
    
    public static void initData(){
        Products p1 = new Products(1,5,800.00,"Book");
        Products p2 = new Products(2,5,10.00,"Pen");
        
        products.put(new Integer(1), p1);
        products.put(new Integer(2), p2);
    }

}
