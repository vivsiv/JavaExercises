package dataStructures;

import java.util.*;

public class UGraph<E extends Comparable<E>> {
	public class Vertex<E>{
		private E element;
		
		public Vertex(E elem){
			element = elem;
		}
		
	}
	
	public class Edge {
		private Vertex v1;
		private Vertex v2;
		
		public Edge(Vertex vert1, Vertex vert2){
			v1 = vert1;
			v2 = vert2;
		}
	}
	
	public class Adjacency {
		private Vertex v;
		private Set<Edge> edges;
	}
	
	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;
	
	private ArrayList<Adjacency> adjacencyList;
	
	public UGraph(){
		
	}
	
	public void addElement(E elem){
		
	}
	
	public void connectElements(E e1, E e2){
		
	}
	
	public void disconnectElements(E e1, E e2){
		
	}
	
	public void removeElement(E elem){
		
	}
	
	public E BFS(E elem){
		return null;
	}
	
	public E DFS(E elem){
		return null;
	}
	
	
}
