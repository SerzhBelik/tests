package com.company;

import java.util.LinkedList;

public class BreadthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private int source;
    private final int INFINITY = Integer.MAX_VALUE;

    public BreadthFirstPath(Graph g, int source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
        distTo = new int[g.getVertexCount()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = INFINITY;
        }
        bfs(g, source);
    }

    private void bfs(Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;
        distTo[source] = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : g.getAdjList(vertex)) {
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    distTo[w] = distTo[vertex] + 1;
                    queue.addLast(w);
                }
            }
        }
    }

    public boolean hasPathTo(int dist){
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist){
        if(!hasPathTo(dist)){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while(vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

    public int distTo(int dist){
        return distTo[dist];
    }
}

