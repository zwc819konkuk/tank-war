package DP.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog(1), new Dog(9), new Dog(2)};
        Cat[] cats = {new Cat(1,1),new Cat(3,3),new Cat(2,2)};
        Sorter<Dog> dogSorter = new Sorter<>();
        Sorter<Cat> catSorter = new Sorter();
        dogSorter.sort(dogs,new DogComparator());
        catSorter.sort(cats,new CatComparator());
        System.out.println(Arrays.toString(dogs));
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }
}
