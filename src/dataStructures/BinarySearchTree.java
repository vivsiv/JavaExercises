/**
 * Some Data Structures in Java
 * @author - Vivek Sivakumar
 */
package dataStructures;

public class BinarySearchTree<Key extends Comparable<Key>> {
	private Node root;
	
	public BinarySearchTree(Key[] in){
		for (int i = 0; i < in.length; i++){
			bstAdd(in[i]);
		}
	}
	
	public class Node {
		private Key key;
		private Node left;
		private Node right;
		
		public Node(Key k){
			key = k;
		}
		
		public Node(Key k, Node lt, Node rt){
			key = k;
			left = lt;
			right = rt;
		}
	}
	
	private Node search(Node n, Key k){
		if (n == null) return null;
		
		int cmp = k.compareTo(n.key);
		if (cmp == 0) return n;
		else if (cmp < 0) return search(n.left,k);
		else if (cmp > 0) return search(n.right,k);
		
		return null;
	}
	
	//AVG O(log(n)) Worst O(n)
	public Key bstSearch(Key k){
		Node n = search(root, k);
		if (n == null) return null;
		else return n.key;
	}
	
	private Node add(Node n, Key k){
		if (n == null) return new Node(k);
		
		int cmp = k.compareTo(n.key);
		if (cmp < 0) n.left = add(n.left, k);
		else if (cmp > 0) n.right = add(n.right, k);
		
		return n;
	}
	
	//O(log(n)) Worst O(n)
	public void bstAdd(Key k){
		root = add(root, k);
	}
	
	private Node max(Node n){
		if (n == null) return null;
		if (n.right != null){
			max(n.right);
		}
		return n;
	}
	
	//O(log(n)) Worst O(n)
	private Node delete(Node n, Key k){
		if (n == null) return null;
		
		int cmp = k.compareTo(n.key);
		if (cmp == 0){
			if (n.left == null && n.right == null){
				n = null;
			}
			else if (n.left != null && n.right == null){
				n = n.left;
			}
			else if (n.left == null && n.right != null){
				n = n.right;
			}
			else if (n.left != null && n.right != null){
				
				Node maxLeft = max(n.left);
				maxLeft.left = delete(n.left, maxLeft.key);
				maxLeft.right = n.right;
				n = maxLeft;
			}
		}
		else if (cmp < 0) n.left = delete(n.left,k);
		else if (cmp > 0) n.right = delete(n.right,k);
		
		return n;
	}
	
	
	public void bstDelete(Key k){
		root = delete(root,k);
	}
	
	private void preOrder(Node n, StringBuilder in){
		if (n == null) return;
		in.append(n.key + " ");
		preOrder(n.left, in);
		preOrder(n.right, in);
	}
	
	private void inOrder(Node n, StringBuilder in){
		if (n == null) return;
		inOrder(n.left, in);
		in.append(n.key + " ");
		inOrder(n.right, in);
	}
	
	public void postOrder(Node n, StringBuilder in){
		if (n == null) return;
		postOrder(n.left, in);
		postOrder(n.right, in);
		in.append(n.key + " ");
	}
	
	//O(n)
	public String treeTraversal(String traversalType){
		StringBuilder traversal = new StringBuilder();
		if (traversalType == "preOrder"){
			preOrder(root, traversal);
		}
		else if (traversalType == "inOrder"){
			inOrder(root, traversal);
		}
		else if (traversalType == "postOrder"){
			postOrder(root, traversal);
		}
		return traversal.toString().trim();
	}
	
	//Not really useful
	public boolean isBst(Node n, Key min, Key max){
		if (n == null) return true;
		if (min.compareTo(n.key) > 0 || max.compareTo(n.key) < 0) return false;
	    return isBst(n.left, min, n.key) && isBst (n.right, n.key, max);
	}
		
	public static void main(String[] args) {
		Integer[] initArray = {2,1,3};
		BinarySearchTree<Integer> testBst = new BinarySearchTree<Integer>(initArray);
		System.out.println("Root: " + testBst.root.key);
		System.out.println("Root.left: " + testBst.root.left.key);
		System.out.println("Root.right: " + testBst.root.right.key);
		System.out.println("Searching for: 2..." + testBst.bstSearch(2));
		System.out.println("Searching for: 3..." + testBst.bstSearch(1));
		System.out.println("Searching for: 1..." + testBst.bstSearch(1));
		testBst.bstDelete(2);
		System.out.println("Deleted 2.. Root should now be 1.." + testBst.root.key);
		System.out.println("Deleted 2.. Root.left should be null.." + testBst.root.left);
		System.out.println("Deleted 3.. Root.right should be 3.." + testBst.root.right.key);
		
		
	}

}
