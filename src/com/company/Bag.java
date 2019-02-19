package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Bag {

    private int capacity;
    ArrayList<Thing> things = new ArrayList<>();

    public Bag(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Thing thing){
        capacity = capacity - thing.getWeight();
        this.things.add(thing);
    }

    public void fillBag(TreeSet<Thing> things){
        Iterator<Thing> iterator = things.iterator();
        if (!iterator.hasNext()){
            return;
        }
        Thing thing = iterator.next();
        if(capacity >= thing.getWeight()){
            add(thing);
            iterator.remove();
        } else iterator.remove();

        fillBag(things);
    }

    public ArrayList<Thing> getThings() {
        return things;
    }

}
