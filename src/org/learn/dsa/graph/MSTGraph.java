package org.learn.dsa.graph;

import java.util.PriorityQueue;

public class MSTGraph {
  private Vertex vertexList[];
  protected Vertex root;

  private int nVertices;

  private int MAX_VERT = 20;

  private int adjMatrix[][];

  private int currentVertex;

  private int nTree;

  private int INFINITY = 100000;

  PriorityQueue<Edge> pq = new PriorityQueue<Edge>(10);

  public MSTGraph() {
    vertexList = new Vertex[MAX_VERT];
    adjMatrix = new int[MAX_VERT][MAX_VERT];
    nVertices = 0;

    for (int i = 0; i < MAX_VERT; i++) {
      for (int j = 0; j < MAX_VERT; j++) {
        adjMatrix[i][j] = INFINITY;
      }
    }
  }

  public void addVertex(char c) {
    Vertex v = new Vertex(c);
    vertexList[nVertices] = v;
    nVertices++;
  }

  public void addEdge(int src, int dest, int weight) {
    // Edge e = new Edge(src,dest,weight);
    adjMatrix[src][dest] = weight;
  //  adjMatrix[dest][src] = weight;
  }

  public void displayVertex(int vertexId) {
    System.out.println(" Vertex is " + vertexList[vertexId].label);
  }

  public void displayGraphMatrix() {
    for (int i = 0; i < nVertices; i++) {
      for (int j = 0; j < nVertices; j++) {
        System.out.print(adjMatrix[i][j] + "\t");
      }
      System.out.print("\n");
    }
  }

  /*
   * Goal : To construct minimum spanning tree - Kruskal algorithm ? 1. Current
   * vertex is placed in the tree 2. All adjacent edges with their weights are
   * added to the Priority Queue 3. The dest vertex of the edge with min weight
   * (ie the first entry in the priority queue) will be added to the tree 4. Now
   * start with this dest vertex as the current vertex
   * 
   */
  public void mstw() {
    currentVertex = 0;
    int distance = 0;
    boolean blMinEdge = false;
    root = vertexList[currentVertex];

    while (nTree < (nVertices - 1)) {
      vertexList[currentVertex].isInTree = true;
      nTree++;
      blMinEdge = false;
     
      for (int i = 0; i < nVertices; i++) {
        distance = adjMatrix[currentVertex][i];
        if (i == currentVertex) {
          continue;
        }
        if (vertexList[i].isInTree == true) {
          continue;
        }

        if (distance == INFINITY) {
          continue;
        }

        Edge edge = new Edge(currentVertex, i, distance);
        pq.add(edge);
      }

      while (!blMinEdge) {
        Edge minEdge = pq.peek();
        if (vertexList[minEdge.destVertex].isInTree == false || vertexList[minEdge.srcVertex].isInTree == false) {
          blMinEdge = true;
          pq.remove(minEdge);
          currentVertex = minEdge.destVertex;
          vertexList[currentVertex].parentVertex = vertexList[minEdge.srcVertex]; 
          vertexList[minEdge.srcVertex].childNodes.add(vertexList[currentVertex]);
          System.out.print(vertexList[minEdge.srcVertex].label);
          System.out.print(vertexList[minEdge.destVertex].label);
          System.out.print(" ");
        }
        else{
          pq.remove(minEdge);
        }
      }

    }

    for (int i = 0; i < nVertices; i++) {
      vertexList[i].isInTree = false;
      vertexList[i].wasVisited = false;
    }
  }

}
