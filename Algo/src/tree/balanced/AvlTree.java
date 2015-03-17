package tree.balanced;

import objects.Objects;

public class AvlTree<K extends Comparable<K>, V> implements BalancedBST<K, V> {

	private AvlTreeNode<K, V> root;

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		return rSize(root);
	}

	private int rSize(AvlTreeNode<K, V> node) {
		if (node == null) {
			return 0;
		}
		return rSize(node.left) + rSize(node.right) + 1;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size()];
		rToArray(root, array, 0);
		return array;
	}

	private int rToArray(AvlTreeNode<K,V> node, Object[] array, int offset) {
		if (node == null) {
			return offset;
		}
		if (node.left != null) {
			offset = rToArray(node.left, array, offset);
		}
		array[offset] = node.key;
		offset++;
		if (node.right != null) {
			offset = rToArray(node.right, array, offset);
		}
		return offset;

	}

	@Override
	public V put(K key, V value) {
		V oldValue = get(key);
		root = rPut(root, key, value);
		return oldValue;
	}

	private AvlTreeNode<K,V> rPut(AvlTreeNode<K,V> node, K key, V value) {
		if (node == null) {
			return new AvlTreeNode<K,V>(key, value);
		}		
		if (Objects.equals(node.key, key)) {
			node.value = value;
			return node;
		} 
		if (Objects.less(key, node.key)) {
			node.left = rPut(node.left, key, value);
		} else {
			node.right = rPut(node.right, key, value);		
		}
		// Update height
		node.height = Math.max(nodeHeight(node.left), nodeHeight(node.right)) + 1;
		// Check balance and do rotation(s) if required
		return balanceNodeAfterInsert(node, key);
	}

	private int nodeHeight(AvlTreeNode<K,V> node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	private int nodeBalance(AvlTreeNode<K,V> node) {
		if (node == null) {
			return 0;
		}
		return nodeHeight(node.left) - nodeHeight(node.right);
	}

	private AvlTreeNode<K,V> rotateRight(AvlTreeNode<K,V> n) {

	//	    n                               nl
	//	   / \     Right Rotation          /  \
	//	 nl   nr   – – – – – – – >        a    n 
	//	 / \                                  / \
	//	a   nlr                             nlr  nr
		
		
		AvlTreeNode<K,V> nl = n.left;
		AvlTreeNode<K,V> nlr = nl.right;
		
		// rotation
		nl.right = n;
		n.left = nlr;
		
		// update heights
		n.height = Math.max(nodeHeight(n.left), nodeHeight(n.right)) + 1;
		nl.height = Math.max(nodeHeight(nl.left), nodeHeight(nl.right)) + 1;	
		
		return nl;
	}

	private AvlTreeNode<K,V> rotateLeft(AvlTreeNode<K,V> n) {

		//	    nr                               n
		//	   / \      Left Rotation           / \
		//	  n   nrr  < – – – – – – –        a    nr 
		//	 / \                                  / \
		//	a   nrl                             nrl  nrr		

		AvlTreeNode<K,V> nr = n.right;
		AvlTreeNode<K,V> nrl = nr.left;
		
		// rotation
		nr.left = n;
		n.right = nrl;
		
		// update heights
		n.height = Math.max(nodeHeight(n.left), nodeHeight(n.right)) + 1;
		nr.height = Math.max(nodeHeight(nr.left), nodeHeight(nr.right)) + 1;
		
		return nr;
	}	
	
	private AvlTreeNode<K,V> balanceNodeAfterInsert(AvlTreeNode<K,V> node, K key) {
		// Get balance
		int balance = nodeBalance(node);

		// http://www.geeksforgeeks.org/avl-tree-set-1-insertion/	
		// http://www.geeksforgeeks.org/avl-tree-set-2-deletion/
		//	    y                                x
		//	   / \     Right Rotation          /  \
		//	  x   T3   – – – – – – – >        T1   y 
		//	 / \       < - - - - - - -            / \
		//	T1  T2     Left Rotation            T2  T3		
		
		// Left Left - key was inserted into left left subtree, x ~ node.left.left
		if (balance > 1 && Objects.less(key, node.left.key)) {
			return rotateRight(node);
		}

		// Right Right - key was inserted into right right subtree, x ~ node.right.right
		if (balance < -1 && Objects.greater(key, node.right.key)) {
			return rotateLeft(node);
		}		
		// Left Right - double rotation - key was inserted into left right subtree, x ~ node.left.right
		if (balance > 1 && Objects.greater(key, node.left.key)) {
			node.left = rotateLeft(node.left); // left rotate right part
			return rotateRight(node);
		}

		// Right Left - double rotation - key was inserted into right left subtree, x ~ node.right.left		
		if (balance < -1 && Objects.less(key, node.right.key)) {
			node.right = rotateRight(node.right); // right rotate right part
			return rotateLeft(node);
		}
		
		// no rotation performed
		return node;		
	}
	
	@Override
	public V get(K key) {
		if (isEmpty()) {
			return null;
		}
		return rGet(root, key);
	}

	private V rGet(AvlTreeNode<K,V> node, K key) {
		if (node == null) {
			return null;
		}
		if (Objects.equals(node.key, key)) {
			return node.value;
		}
		if (Objects.less(key, node.key)) {
			return rGet(node.left, key);
		} else {
			return rGet(node.right, key);
		}
	}

	@Override
	public boolean delete(K key) {
		if (isEmpty()) {
			return false;
		}
		try {
			root = rDelete(root, key);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}		

	}

	
	private AvlTreeNode<K,V> rDelete(AvlTreeNode<K,V> node, K key) throws IllegalArgumentException {
		
		if (Objects.less(key, node.key)) {
			if (node.left == null) {
				throw new IllegalArgumentException(key + " not found");
			} 
			node.left = rDelete(node.left, key);
		} else if (Objects.greater(key, node.key)) {
			if (node.right == null) {
				throw new IllegalArgumentException(key + " not found");
			}
			node.right = rDelete(node.right, key);
		} else {
			
			if (node.left == null && node.right == null) {
				// GC
				node.key = null;
				node.value = null;
				return null;
			} else if (node.left != null && node.right == null) {
				AvlTreeNode<K,V> newNode = node.left;
				node.left = null;
				// GC
				node.key = null;
				node.value = null;
				node = newNode;
			} else if (node.left == null && node.right != null) {
				AvlTreeNode<K,V> newNode = node.right;
				node.right = null;
				// GC
				node.key = null;
				node.value = null;
				node = newNode;
			} else { // has both leaves
				AvlTreeNode<K,V> minimalRight = minNode(node.right);
				// copy minimal value to root
				node.key = minimalRight.key;
				node.value = minimalRight.value;
				node.right = rDelete(node.right, minimalRight.key);
			}
		} 

		
		// Update height
		node.height = Math.max(nodeHeight(node.left), nodeHeight(node.right)) + 1;
		// Check balance and do rotation(s) if required
		return balanceNodeAfterDelete(node);		
	}
	
	
	private AvlTreeNode<K,V> minNode(AvlTreeNode<K,V> node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}	

	private AvlTreeNode<K,V> balanceNodeAfterDelete(AvlTreeNode<K,V> node) {
		// Get balance
		int balance = nodeBalance(node);

		// http://www.geeksforgeeks.org/avl-tree-set-1-insertion/	
		// http://www.geeksforgeeks.org/avl-tree-set-2-deletion/
		//	    y                                x
		//	   / \     Right Rotation          /  \
		//	  x   T3   – – – – – – – >        T1   y 
		//	 / \       < - - - - - - -            / \
		//	T1  T2     Left Rotation            T2  T3		
		
		// Left Left
		if (balance > 1 && nodeBalance(node.left) >= 0) {
			return rotateRight(node);
		}

		// Right Right
		if (balance < -1 && nodeBalance(node.right) <= 0) {
			return rotateLeft(node);
		}		

		// Left Right - double rotation
		if (balance > 1 && nodeBalance(node.left) < 0) {
			node.left = rotateLeft(node.left); // left rotate right part
			return rotateRight(node);
		}

		// Right Left - double rotation	
		if (balance < -1 && nodeBalance(node.right) > 0) {
			node.right = rotateRight(node.right); // right rotate right part
			return rotateLeft(node);
		}
		
		// no rotation performed
		return node;		
	}	
	
	@Override
	public boolean contains(K key) {
		if (isEmpty()) {
			return false;
		}
		return rContains(root, key);
	}

	private boolean rContains(AvlTreeNode<K,V> node, K key) {

		if (node == null) {
			return false;
		}

		if (Objects.equals(node.key, key)) {
			return true;
		}

		if (Objects.less(key, node.key)) {
			return rContains(node.left, key);
		} else {
			return rContains(node.right, key);
		}
	}

	@Override
	public int height() {
		return nodeHeight(root);
	}

	@Override
	public int balance() {
		return nodeBalance(root);
	}
	
}

class AvlTreeNode<K extends Comparable<K>, V> {

	public AvlTreeNode<K,V> left;
	public AvlTreeNode<K,V> right;
	public K key;
	public V value;	
	public int height = 1;
	
	public AvlTreeNode() {
		
	}
	
	public AvlTreeNode(K key) {
		this.key = key;
	}
	
	public AvlTreeNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public AvlTreeNode(K key, V value, int height) {
		this.key = key;
		this.value = value;
		this.height = height;
	}	
	
}


