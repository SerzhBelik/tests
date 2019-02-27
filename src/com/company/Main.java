package com.company;


public class Main {
    private static long timeStart;
    private static long timeResult;

    public static void main(String[] args) {

        // плотный граф
        Graph graph1 = new Graph(10);
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(1,3);
        graph1.addEdge(1,4);
        graph1.addEdge(2,5);
        graph1.addEdge(5,3);
        graph1.addEdge(5,4);
        graph1.addEdge(6,4);
        graph1.addEdge(6,3);
        graph1.addEdge(6,5);
        graph1.addEdge(6,7);
        graph1.addEdge(6,8);
        graph1.addEdge(8,7);
        graph1.addEdge(9,7);

        DepthFirstPaths dfp1 = new  DepthFirstPaths(graph1, 0);
        BreadthFirstPath bfp1 = new BreadthFirstPath(graph1,0);
        System.out.println("Плотный граф");
        breadthTrial(bfp1, 9);
        depthTrial(dfp1, 9);

        // разряженный граф
        Graph graph2 = new Graph(10);
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(1,4);
        graph1.addEdge(5,3);
        graph1.addEdge(6,4);
        graph1.addEdge(6,5);
        graph1.addEdge(6,7);
        graph1.addEdge(6,8);
        graph1.addEdge(9,7);

        System.out.println("Разряженный граф");
        DepthFirstPaths dfp2 = new  DepthFirstPaths(graph2, 0);
        BreadthFirstPath bfp2 = new BreadthFirstPath(graph2,0);

        breadthTrial(bfp2, 9);
        depthTrial(dfp2, 9);
    }

    public static void breadthTrial(BreadthFirstPath bfp, int dist){
        timeStart = System.nanoTime();
        bfp.hasPathTo(dist);
        timeResult = System.nanoTime() - timeStart;
        System.out.println("поиск в ширину : " + timeResult);
    }

    public static void depthTrial(DepthFirstPaths dfp, int dist){
        timeStart = System.nanoTime();
        dfp.hasPathTo(dist);
        timeResult = System.nanoTime() - timeStart;
        System.out.println("поиск в глубину : " + timeResult);
    }
}


