package com.company;

import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    private int vertexCount;
    private int edgeCount = 0;
    private HashSet<Integer>[] adjList;

    public Graph(int vertexCount) {
        if (vertexCount < 0) {
            throw new IllegalArgumentException(" Количество вершин не может быть отрицательным");
        }
        this.vertexCount = vertexCount;
        adjList = new HashSet[vertexCount];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new HashSet<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public HashSet<Integer> getAdjList(int vertex) {
        return (HashSet<Integer>) adjList[vertex].clone();
    }

    public void addEdge(int v1, int v2){
        if(v1<0 || v2<0 || v1>=vertexCount || v2>=vertexCount){
            throw new IllegalArgumentException();
        }
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }

    public void removeEdge(int v1, int v2){
        if(v1<0 || v2<0 || v1>=vertexCount || v2>=vertexCount){
            throw new IllegalArgumentException();
        }
        adjList[v1].remove(v2);
        adjList[v2].remove(v1);

    }
}
