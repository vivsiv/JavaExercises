/**
 * @author Vivek Sivakumar
*/

package dataStructures;

import java.util.*;

public class HashTable<E extends Comparable<E>> {
	//private ArrayList<E> buckets;
	private int size;
	private Object[] buckets;
	private static final int DEFAULT_TABLE_SIZE = 10;
	private static final boolean DEBUG = true;
	
	public HashTable(int sizeEstimate){
		buckets = new Object[sizeEstimate];
	}
	
	public HashTable(){
		buckets = new Object[DEFAULT_TABLE_SIZE];
	}
	
	public Object[] getBuckets(){
		if (DEBUG) return buckets;
		else return null;
	}
	
	public boolean contains(Object o){
		int index = hash(o);
		if (buckets[index] == null) return false;
		else {
			if (buckets[index] instanceof ArrayList<?>){
				ArrayList<Object> chain = (ArrayList<Object>)buckets[index];
				for (Object e : chain){
					if (e.equals(o)) return true;
				}
				return false;
			}
			else {
				//Throw exception?
				return false;
			}
		}
	}
	
	public boolean add(E e){
		if (contains(e)) return false;
		else {
			int index = hash(e);
			if (buckets[index] == null){
				buckets[index] = new ArrayList<Object>();
			}
			if (buckets[index] instanceof ArrayList<?>){
				ArrayList<Object> chain = (ArrayList<Object>)buckets[index];
				chain.add(e);
				size++;
				if (loadFactor() > 0.9) rehash();
				return true;
			}
			else {
				//Throw exception?
				return false;
			}
		}
		
	}
	
	public boolean remove(Object o){
		int index = hash(o);
		if (buckets[index] instanceof ArrayList<?>){
			ArrayList<Object> chain = (ArrayList<Object>)buckets[index];
			int removeIdx = -1;
			for (int i = 0; i < chain.size(); i++){
				if ((chain.get(i)).equals(o)) {
					removeIdx = i;
					break;
				}
			}
			if (removeIdx != -1){
				chain.remove(removeIdx);
				if (chain.isEmpty()) buckets[index] = null;
				size--;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			//Throw Exception?
			return false;
		}
	}
	
	public int size(){
		return size;
	}
	
	//Helpers
	private int hash(Object o){
		return o.hashCode() % buckets.length;
	}
	
	private void rehash(){
		System.out.println("Before Rehashing: " + arrayString(buckets));
		Object[] newBuckets = new Object[2 * size];
		for (Object bucket : buckets){
			if (bucket instanceof ArrayList<?>){
				ArrayList<Object> chain = (ArrayList<Object>)bucket;
				if (chain != null){
					Object firstObj = chain.get(0);
					int newIndex = firstObj.hashCode() % newBuckets.length;
					if (newBuckets[newIndex] == null){
						newBuckets[newIndex] = chain;
					}
					else if (newBuckets[newIndex] instanceof ArrayList<?>) {
						ArrayList<Object> prevChain = (ArrayList<Object>)(newBuckets[newIndex]);
						prevChain.addAll(chain);
					}
				}
			}
		}
		buckets = newBuckets;
		System.out.println("After Rehashing: " + arrayString(buckets));
	}
	
	private double loadFactor(){
		return size / buckets.length;
	}
	
	public String arrayString(Object[] in){
		//System.out.println("Creating string for array: " + in.toString());
		String arr = "[";
		for (int i = 0; i < in.length; i++){
			if (in[i] == null) arr += "null ";
			else arr += (in[i].toString() + " ");
		}
		return arr.trim() + "]";
	 }
}
