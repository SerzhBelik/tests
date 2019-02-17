package com.company;


import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        // task №1
        long a = exponentiate(0, 0);
        System.out.println(a);

        // task №2
        TreeSet<Thing> things = new TreeSet<Thing>((o1, o2) -> o2.getUnitCost().compareTo(o1.getUnitCost()));
        setThings(things);
        Iterator<Thing> i = things.iterator();
        while (i.hasNext()){
            System.out.println(i.next().getWeight());
        }
        Bag bag = new Bag(99);
        bag.fillBag(things);
        Iterator<Thing> iterator = bag.getThings().iterator();
        System.out.println("There are things in the bag:");
        while (iterator.hasNext()){
            System.out.println(iterator.next().getWeight());
        }
    }

    private static void setThings(TreeSet things) {

        things.add(new Thing(10, 7));
        things.add(new Thing(8, 12));
        things.add(new Thing(14, 45));
        things.add(new Thing(100, 800));
        things.add(new Thing(50, 399));
        things.add(new Thing(50, 399));
    }

    private static long exponentiate(int base, int exponent){
        if (exponent == 0) return 1;
        if (exponent < 2){
            return base;
        }

        return base * exponentiate(base, exponent-1);
    }


}


