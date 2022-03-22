package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int result = 0;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product == null) {
                result = i;
                break;
            } else {
                result = -1;
            }
       }
        return result;
    }
}
