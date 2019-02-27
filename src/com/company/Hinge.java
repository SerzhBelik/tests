package com.company;

import java.util.HashSet;
import java.util.LinkedList;

public class Hinge {
    private LinkedList<Integer> hingeList;
    private HashSet<Integer> adjList;
    private LinkedList<Integer> temp;
    private Object[] adjArr;
    DepthFirstPaths dfp;
    private Graph g;

    public Hinge(Graph g) {
        this.g = g;
    }


    public LinkedList<Integer> getHingeList() {
        hingeList = new LinkedList<>();
        for (int i = 0; i < g.getVertexCount(); i++) {
            adjList = g.getAdjList(i);
            adjArr = adjList.toArray();
            if (adjArr.length < 2) break;
            checkPath(i);
            restoreEdge(i);
        }

        return hingeList;
    }



    private void cutVertex(int vertex) {
        temp = new LinkedList<>();
        for (int i = 0; i < adjArr.length; i++){
            temp.add((int)adjArr[i]);
            g.removeEdge(vertex, (int)adjArr[i]);
        }
    }

    private void checkPath(int checkedVertex) {
        cutVertex(checkedVertex);
        dfp = new DepthFirstPaths(g, (int)adjArr[0]);
        for (int i = 1; i < adjArr.length; i++) {
            if (!dfp.hasPathTo((int)adjArr[i])) {
                hingeList.add(checkedVertex);
                return;
            }
        }
    }

    private void restoreEdge(int vertex) {

        for (int i = 0; i < adjArr.length; i++){
            g.addEdge(vertex, temp.get(i));

        }

    }

}
