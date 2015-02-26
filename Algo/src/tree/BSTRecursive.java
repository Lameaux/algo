package tree;

import objects.Objects;

public class BSTRecursive<T extends Comparable<T>> implements BST<T> {

	private TreeNode<T> top;

	public BSTRecursive() {

	}

	public BSTRecursive(TreeNode<T> top) {
		this.top = top;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		return treeSize(top);
	}

	private int treeSize(TreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		return 1 + treeSize(root.left) + treeSize(root.right);
	}

	@Override
	public void add(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Null is not supported");
		}

		TreeNode<T> newNode = new TreeNode<T>(value);
		if (isEmpty()) {
			top = newNode;
			return;
		}

		add(top, value);

	}

	private void add(TreeNode<T> root, T value) {

		if (Objects.equals(root.value, value)) {
			throw new IllegalArgumentException("Duplicate key");
		}

		if (Objects.less(value, root.value)) {
			if (root.left == null) {
				root.left = new TreeNode<T>(value);
			} else {
				add(root.left, value);
			}
		} else {
			if (root.right == null) {
				root.right = new TreeNode<T>(value);
			} else {
				add(root.right, value);
			}
		}

	}

	
	
	@Override	
	public Object[] toArray() {
		Object[] array = new Object[size()];
		
		writeTreeArray(top, array, 0);
		
		return array;
	}
	
	private int writeTreeArray(TreeNode<T> node, Object[] array, int offset) {
		if (node == null) {
			return offset;
		}
		
		if (node.left != null) {
			offset = writeTreeArray(node.left, array, offset);
		}
		
		array[offset] = node.value;
		offset++;
		
		if (node.right != null) {
			offset = writeTreeArray(node.right, array, offset);
		}
		
		
		return offset;
		
	}
	
}
