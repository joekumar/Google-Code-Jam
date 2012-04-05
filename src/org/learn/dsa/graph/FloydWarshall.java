package org.learn.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
public class FloydWarshall {

   int[][] D;
   Node[][] P;

   public void calcShortestPaths(Node[] nodes, Edge[] edges) {
       D = initializeWeight(nodes, edges);
       P = new Node[nodes.length][nodes.length];

       for(int k=0; k<nodes.length; k++){
           for(int i=0; i<nodes.length; i++){
               for(int j=0; j<nodes.length; j++){
                   if(D[i][k] != Integer.MAX_VALUE && D[k][j] != Integer.MAX_VALUE && D[i][k]+D[k][j] < D[i][j]){
                       D[i][j] = D[i][k]+D[k][j];
                       P[i][j] = nodes[k];
                   }
               }
           }
       }
       
       Node temp;
       for(int i=0; i<nodes.length; i++){
         for(int j=0; j<nodes.length; j++){
                 temp = P[i][j];
                 System.out.println("node at i "+i+ " j "+j + " is "+temp);
             }
         }
       
       for(int i=0; i<nodes.length; i++){
         for(int j=0; j<nodes.length; j++){
                 System.out.println("dist  at i "+i+ " j "+j + " is "+D[i][j]);
             }
         }
       
 
   }

   public int getShortestDistance(Node source, Node target){
       return D[source.name][target.name];
   }

   public ArrayList<Node> getShortestPath(Node source, Node target){
       if(D[source.name][target.name] == Integer.MAX_VALUE){
           return new ArrayList<Node>();
       }
       ArrayList<Node> path = getIntermediatePath(source, target);
       path.add(0, source);
       path.add(target);
       return path;
   }

   private ArrayList<Node> getIntermediatePath(Node source, Node target){
       if(D == null){
           throw new IllegalArgumentException("Must call calcShortestPaths(...) before attempting to obtain a path.");
       }
       if(P[source.name][target.name] == null){
           return new ArrayList<Node>();
       }
       ArrayList<Node> path = new ArrayList<Node>();
       path.addAll(getIntermediatePath(source, P[source.name][target.name]));
       path.add(P[source.name][target.name]);
       path.addAll(getIntermediatePath(P[source.name][target.name], target));
       return path;
   }

   private int[][] initializeWeight(Node[] nodes, Edge[] edges){
       int[][] Weight = new int[nodes.length][nodes.length];
       for(int i=0; i<nodes.length; i++){
           Arrays.fill(Weight[i], Integer.MAX_VALUE);
       }
       for(Edge e : edges){
           Weight[e.from.name][e.to.name] = e.weight;
       }
       return Weight;
   }
}

