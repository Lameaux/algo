package tree;

import objects.Objects;
import queue.ArrayQueue;
import queue.Queue;
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

	/**
	 * In-order iterative traversal
	 */
	@Override
	public Object[] toArray() {
		Object[] array = new Object[size()];

		Stack<TreeNode<T>> s = new ArrayStack<TreeNode<T>>();

		TreeNode<T> current = top;
		int index = 0;
		while (current != null || !s.empty()) {
			if (current != null) { 
				s.push(current); // pushing left nodes to the stack
				current = current.left;
			} else { // no more left nodes, pop from stack and check for right
				TreeNode<T> n = s.pop();
				array[index++] = n.value;
				current = n.right;
			}
		}

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
		if (isEmpty()) {
			return false;
		}

		// traverse
		TreeNode<T> parent = null;
		TreeNode<T> current = top;
		while (current != null) {
			if (Objects.equals(value, current.value)) {

				// GC
				current.value = null;				
				
				if (current.left == null && current.right == null) { // no children
					replaceCurrentInParent(parent, current, null);
				} else if (current.left == null) {
					replaceCurrentInParent(parent, current, current.right);					
				} else if (current.right == null) {
					replaceCurrentInParent(parent, current, current.left);					
				} else { // has both
					TreeNode<T>[] lowestWithParent = findLowestWithParent(current.right, current); // find lowest in right part
					TreeNode<T> lowestNode = lowestWithParent[0];
					TreeNode<T> lowestParent = lowestWithParent[1];
					current.value = lowestNode.value;
					// GC
					lowestNode.value = null;
					if (lowestParent.left == current) {
						lowestParent.left = null;
					} else {
						lowestParent.right = null;
					}
				}
				return true;
				
			} else if (Objects.less(value, current.value)) {
				if (current.left == null) {
					return false;
				} else {
					parent = current;
					current = current.left;
					continue;
				}

			} else {
				if (current.right == null) {
					return false;
				} else {
					parent = current;
					current = current.right;
					continue;
				}
			}
		}
		return false;
	}

	private void replaceCurrentInParent(TreeNode<T> parent, TreeNode<T> current, TreeNode<T> node) {
		if (parent == null) {
			top = node;
		} else if (parent.left == current) {
			parent.left = node;
		} else {
			parent.right = node;
		}		
	}	
	
	@SuppressWarnings("unchecked")
	private TreeNode<T>[] findLowestWithParent(TreeNode<T> node, TreeNode<T> parent) {
		while (node.left != null) {
			parent = node;
			node = node.left;
		}
		return (TreeNode<T>[])new TreeNode[]{node, parent};
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

		if (top == null) {
			return 0;
		}

		Queue<TreeNode<T>> q = new ArrayQueue<TreeNode<T>>();
		q.offer(top);

		int height = 0;

		while (true) {
			if (q.empty()) {
				return height;
			}
			height++;
			int count = q.size(); // counts the number of nodes on each level
			// pop all nodes on the same level and push the next level
			while (count > 0) {
				TreeNode<T> n = q.pop();
				count--;
				if (n.left != null) {
					q.offer(n.left);
				}
				if (n.right != null) {
					q.offer(n.right);
				}
			}
		}

	}

}
