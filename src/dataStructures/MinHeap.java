package dataStructures;

import java.util.*;

public class MinHeap<E extends Comparable<E>> {
	private ArrayList<E> heap;
	private static final boolean DEBUG = false;
	
	public MinHeap(E[] in){
		heap = new ArrayList<E>();
		buildHeap(in);
	}

	//Public Interface
	public E peek(){
		return heap.get(0);
	}
	
	public E poll(){
		if (size() > 0){
			int lastIdx = size() - 1;
			E polled = heap.get(0);
			heap.set(0, heap.get(lastIdx));
			heap.remove(lastIdx);
			heapify(0);
			return polled;
		}
		else return null;
	}
	
	public void add(E e){
		heap.add(e);
		int currIdx = heap.indexOf(e);
		int parentIdx = parentOf(currIdx);
		while (currIdx != 0 && heap.get(currIdx).compareTo(heap.get(parentIdx)) < 0){
			heapify(parentIdx);
			currIdx = parentIdx;
			parentIdx = parentOf(currIdx);
		}
		//TODO
	}
	
	public int size(){
		return heap.size();
	}
	
	//Private Methods
	private void buildHeap(E[] in){
		for (int i = 0; i < in.length; i++){
			add(in[i]);
			if (DEBUG) System.out.println("Added: " + in[i] + " heap: " + heapString());
		}
	}
	
	private void heapify(int i){
		E left = null, right = null;
		if (leftChildOf(i) < size()) left = heap.get(leftChildOf(i)); 
		if (rightChildOf(i) < size()) right = heap.get(rightChildOf(i));
		
		if (left != null && right == null && left.compareTo(heap.get(i)) < 0){
			switchElements(leftChildOf(i), i);
			heapify(leftChildOf(i));
		}
		else if (right != null && left == null && right.compareTo(heap.get(i)) < 0){
			switchElements(rightChildOf(i), i);
			heapify(rightChildOf(i));
		}
		else if (left != null && right != null) {
			if (left.compareTo(right) <= 0 && left.compareTo(heap.get(i)) < 0){
				switchElements(leftChildOf(i), i);
				heapify(leftChildOf(i));
			}
			else if (right.compareTo(left) < 0 && right.compareTo(heap.get(i)) < 0) {
				switchElements(rightChildOf(i), i);
				heapify(rightChildOf(i));
			}
		}
		
	}
	
	private void switchElements(int idx1, int idx2){
		E tmp = heap.get(idx2);
		heap.set(idx2, heap.get(idx1));
		heap.set(idx1, tmp);
	}
	
	private int leftChildOf(int parentIdx){
		return (2 * (parentIdx + 1)) - 1;
	}
	
	private int rightChildOf(int parentIdx){
		return ((2 * (parentIdx + 1)) + 1) - 1;
	}
	
	private int parentOf(int childIdx){
		return ((childIdx + 1) / 2) - 1;
	}
	
	public String heapString(){
		   String arr = "{";
		   for (int i = 0; i < size(); i++){
			   arr += (heap.get(i) + " ");
		   }
		   return arr.trim() + "}";
	   }
	
	public static void main(String[] args){
		Integer[] in = {3,2,6,1,7,8};
		MinHeap<Integer> testHeap = new MinHeap<Integer>(in);
		System.out.println("Built heap, heap should be 1 2 6 3 7 8... " + testHeap.heapString());
		System.out.println("Peek() should be 1... " + testHeap.peek());
		testHeap.poll();
		System.out.println("Polled 1, heap should be 2 3 6 8 7... " + testHeap.heapString());
	}
}
