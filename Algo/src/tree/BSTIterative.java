package tree;


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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}



}
