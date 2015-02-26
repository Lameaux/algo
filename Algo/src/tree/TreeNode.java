package tree;

public class TreeNode<T extends Comparable<T>> {
	
	public TreeNode<T> left;
	public TreeNode<T> right;
	public T value;
	
	public TreeNode() {
		
	}
	
	public TreeNode(T value) {
		this.value = value;
	}
	

}
