package DP.strategy;

public class CatComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return o2.weight - o1.weight;
    }
}
