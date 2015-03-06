package tree;

import objects.Objects;
import stack.ArrayStack;
import stack.Stack;

public class BSTIterative<T extends Comparable<T>> implements BST<T> {

	private TreeNode<T> top;

	public BSTIterative() {

	}

	public BSTIterative(TreeNode<T> top) {
		this.top = top;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		int size = 0;
		Stack<TreeNode<T>> s = new ArrayStack<TreeNode<T>>();
		s.push(top);
		while (!s.empty()) {
			TreeNode<T> node = s.pop();
			size++;
			if (node.left != null) {
				s.push(node.left);
			}
			if (node.right != null) {
				s.push(node.right);
			}
		}
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size()];
		
		// TODO
		
		return array;
	}

	@Override
	public boolean add(T value) {
		if (isEmpty()) {
			top = new TreeNode<T>(value);
			return true;
		}

		TreeNode<T> current = top;
		while (current != null) {
			if (Objects.equals(value, current.value)) {
				return false;
			} else if (Objects.less(value, current.value)) {
				if (current.left == null) {
					current.left = new TreeNode<T>(value);
					return true;
				} else {
					current = current.left;
					continue;
				}

			} else {
				if (current.right == null) {
					current.right = new TreeNode<T>(value);
					return true;
				} else {
					current = current.right;
					continue;
				}
			}
		}
		return false;

	}

	@Override
	public boolean delete(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(T value) {
		if (isEmpty()) {
			return false;
		}

		TreeNode<T> current = top;
		while (current != null) {
			if (Objects.equals(value, current.value)) {
				return true;
			} else if (Objects.less(value, current.value)) {
				if (current.left == null) {
					return false;
				} else {
					current = current.left;
					continue;
				}

			} else {
				if (current.right == null) {
					return false;
				} else {
					current = current.right;
					continue;
				}
			}
		}
		return false;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

}
