package org.learn.dsa.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class ShortestPathGraph {

  private Vertex vertexList[];

  private int nVertices;

  private int MAX_VERT = 20;

  private int adjMatrix[][];

  private int startVertex;

  private int nTree;

  private int INFINITY = 100000;

  private int startToCurrent = 0;

  PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(10,new VertexComparator());
  ArrayList<Vertex> alPath = new ArrayList<Vertex>();

  public ShortestPathGraph() {
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
    v.matrixRowNum = nVertices;
    vertexList[nVertices] = v;
    nVertices++;
  }

  public void addEdge(int src, int dest, int weight) {
    // Edge e = new Edge(src,dest,weight);
    adjMatrix[src][dest] = weight;
 //   adjMatrix[dest][src] = weight;
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

  public void recomputePaths() {
    Vertex currentVertex = pq.peek();
    currentVertex.isInTree = true;
    int cRowNum = currentVertex.matrixRowNum;
    Vertex v;
    int fringePath = 0;
    pq.clear();

    for (int i = 0; i < nVertices; i++) {
      v = vertexList[i];

      if (v.isInTree) {
        pq.add(v);
        continue;
      }

      if (adjMatrix[cRowNum][i] != INFINITY) {
        fringePath = currentVertex.parentDistance + adjMatrix[currentVertex.matrixRowNum][i];

        if (fringePath < v.parentDistance) {
          v.parentDistance = fringePath;
          v.parentVertex = currentVertex;
        }

        pq.add(v);
      }
    }
   
  }

  /*
   * Goal : To construct the shortest path using Djikstra algorithm 1. Add
   * current start vertex to Tree 2. Add all vertex DistPar object to spath
   * Priority Queue 3. Get the vertex with shortest path from start and not in
   * the tree 4. get the nearest neighbor (one with less weight) of this vertex.
   * distance is sdist 5. recompute spath values in queue by adding the new
   * distance sdist to existing vertices not in tree
   * 
   */
  public void computeShortestPath() {
    startVertex = 0;
    int distance = 0;
    vertexList[startVertex].isInTree = true;
    vertexList[startVertex].parentVertex = vertexList[startVertex];
    alPath.add(vertexList[startVertex]);
    nTree = 1;

    for (int i = 1; i < nVertices; i++) {
      distance = adjMatrix[startVertex][i];
      // DistParent distParent = new DistParent(distance,
      // vertexList[startVertex], vertexList[i]);
      if (distance != INFINITY) {
        vertexList[i].parentDistance = distance;
        vertexList[i].parentVertex = vertexList[startVertex];
        pq.add(vertexList[i]);
      }

    }

    while (nTree <= (nVertices - 1)) {
      Vertex minVertex = pq.poll();
      int mindistance = minVertex.parentDistance;

      startToCurrent = startToCurrent + mindistance;
      pq.add(minVertex);
      nTree++;
      alPath.add(minVertex);
      recomputePaths();
    
    }

    displayPaths();

    for (int i = 0; i < nVertices; i++) {
      vertexList[i].isInTree = false;
    }
  }

  public void displayPaths() {
    Iterator<Vertex> pqIterator = alPath.iterator();
    Vertex v;
    while (pqIterator.hasNext()) {
      v = pqIterator.next();
      System.out.println(" vertex " + v.parentVertex.label + " to " + v.label + " distance " + v.parentDistance);
    }
  }

}
