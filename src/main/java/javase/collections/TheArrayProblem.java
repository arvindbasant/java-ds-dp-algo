package javase.collections;

import java.util.Arrays;

public class TheArrayProblem {
    public static void main(String[] args) {
        Product door = new Product("Wooden door", 35);
        Product floorPanel = new Product("Floor Panel", 25);

        Product[] products = {door, floorPanel};
        System.out.println(Arrays.toString(products));
        // [Product{name='Wooden door', weight=35}, Product{name='Floor Panel', weight=25}]


    }
}
