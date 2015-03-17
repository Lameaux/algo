package tree;

/**
 * Node of the tree containing value and pointers to the left and right children
 * @author sergii.sizov
 *
 * @param <T>
 */
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
