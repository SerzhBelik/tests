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

    private void checkPath(int checkedVertex) {
        cutVertex(checkedVertex);
        dfp = new DepthFirstPaths(g, (int)adjArr[0]);
        for (int i = 1; i < adjArr.length; i++) {
            // поскольку все вершины из списка adjList проверяемой вершины гарантировано имеют как миниму один путь
            // между собой (через проверяемую вершину) они находятся в одном компоненте связанности,
            // если проверяемая вершина будет вырезана вегда будет верно:
            // для любой вершины из adjList путь до одной или неслкольких других вершин из adjList
            // не будет существовать, если эти вершины окажутся в разных компонентах связанности, т.е проверяемый узел
            // будет являться шарниром
            if (!dfp.hasPathTo((int)adjArr[i])) {
                hingeList.add(checkedVertex);
                return;
            }
        }
    }

    // обрезаем все ребра узла который хотим проверить на соответсвие условию шарнира
    // и сохраняем убранные ребра для дальнейшего восстановления после проверки
    private void cutVertex(int vertex) {
        temp = new LinkedList<>();
        for (int i = 0; i < adjArr.length; i++){
            temp.add((int)adjArr[i]);
            g.removeEdge(vertex, (int)adjArr[i]);
        }
    }

    // восстановление ребер после проверки
    private void restoreEdge(int vertex) {

        for (int i = 0; i < adjArr.length; i++){
            g.addEdge(vertex, temp.get(i));

        }

    }

}
