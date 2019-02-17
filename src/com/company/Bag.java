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

    private boolean stow(TreeSet<Thing> things){
        Iterator<Thing> iterator = things.iterator();
        while (iterator.hasNext()){
            Thing thing = iterator.next();
            if(capacity >= thing.getWeight()){
                add(thing);
                iterator.remove();
                return true;
            } else iterator.remove();
        }
        return false;

    }

    public void fillBag(TreeSet<Thing> things){
        while (stow(things)) stow(things);

    }

    public ArrayList<Thing> getThings() {
        return things;
    }
}
