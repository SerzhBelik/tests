package com.company;

public class Thing {
    private int weight;
    private int cost;
    private Double unitCost;

    public Thing(int weight, int cost){
        this.weight = weight;
        this.cost = cost;
        this.unitCost = (double) cost/weight;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }
}
