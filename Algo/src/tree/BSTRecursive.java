package tree;

import objects.Objects;

/**
 * Implementation of BST using recursion
 * @author sergii.sizov
 *
 * @param <T>
 */
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
		return rSize(top);
	}

	private int rSize(TreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		return 1 + rSize(root.left) + rSize(root.right);
	}

	@Override
	public boolean add(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Null is not supported");
		}

		if (isEmpty()) {
			top = new TreeNode<T>(value);
			return true;
		}

		return rAdd(top, value);

	}

	private boolean rAdd(TreeNode<T> root, T value) {

		if (Objects.equals(root.value, value)) {
			return false;
		}

		if (Objects.less(value, root.value)) {
			if (root.left == null) {
				root.left = new TreeNode<T>(value);
				return true;
			} else {
				return rAdd(root.left, value);
			}
		} else {
			if (root.right == null) {
				root.right = new TreeNode<T>(value);
				return true;
			} else {
				return rAdd(root.right, value);
			}
		}

	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size()];

		rToArray(top, array, 0);

		return array;
	}

	private int rToArray(TreeNode<T> node, Object[] array, int offset) {
		if (node == null) {
			return offset;
		}

		if (node.left != null) {
			offset = rToArray(node.left, array, offset);
		}

		array[offset] = node.value;
		offset++;

		if (node.right != null) {
			offset = rToArray(node.right, array, offset);
		}

		return offset;

	}

	@Override
	public int height() {
		return rHeight(top);
	}

	private int rHeight(TreeNode<T> node) {
		if (node == null) {
			return 0;
		}

		return Math.max(rHeight(node.left), rHeight(node.right)) + 1;

	}

	@Override
	public boolean contains(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Null is not supported");
		}

		if (isEmpty()) {
			return false;
		}

		return rContains(top, value);
	}

	private boolean rContains(TreeNode<T> root, T value) {

		if (root == null) {
			return false;
		}

		if (Objects.equals(root.value, value)) {
			return true;
		}

		if (Objects.less(value, root.value)) {
			return rContains(root.left, value);
		} else {
			return rContains(root.right, value);
		}
	}

	@Override
	public boolean delete(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Null is not supported");
		}
		if (isEmpty()) {
			return false;
		}
		try {
			top = rDelete(top, value);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	private TreeNode<T> minNode(TreeNode<T> node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	private TreeNode<T> rDelete(TreeNode<T> root, T value) throws IllegalArgumentException {
		if (Objects.equals(root.value, value)) {
			if (root.left == null && root.right == null) {
				// GC
				root.value = null;
				return null;
			} else if (root.left != null && root.right == null) {
				TreeNode<T> newRoot = root.left;
				root.left = null;
				// GC
				root.value = null;
				return newRoot;
			} else if (root.left == null && root.right != null) {
				TreeNode<T> newRoot = root.right;
				root.right = null;
				// GC
				root.value = null;
				return newRoot;
			} else { // has both leaves
				TreeNode<T> minimalRight = minNode(root.right);
				// copy minimal value to root
				root.value = minimalRight.value;
				root.right = rDelete(root.right, minimalRight.value);
			}
		} else if (Objects.less(value, root.value)) {
			if (root.left == null) {
				throw new IllegalArgumentException(value + " not found");
			} 
			root.left = rDelete(root.left, value);
		} else {
			if (root.right == null) {
				throw new IllegalArgumentException(value + " not found");
			}
			root.right = rDelete(root.right, value);
		}

		return root;

	}

}
