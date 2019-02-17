package com.company;


import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        long a = exponentiate(0, 0);
        System.out.println(a);


        TreeSet<Thing> things = new TreeSet<Thing>((o1, o2) -> o2.getUnitCost().compareTo(o1.getUnitCost()));



        things.add(new Thing(10, 7));
        things.add(new Thing(8, 12));
        things.add(new Thing(14, 45));

        Bag bag = new Bag(25);
        bag.fillBag(things);

//
        Iterator<Thing> iterator = bag.getThings().iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next().getWeight());
        }


    }
    private static long exponentiate(int base, int exponent){
        if (exponent == 0) return 1;
        if (exponent < 2){
            return base;
        }

        return base * exponentiate(base, exponent-1);
    }


}


