package tree.balanced;


public class AvlTreeTest extends BalancedBSTTestBase {

	@Override
	protected BalancedBST<String, String> getTreeImpl() {
		return new AvlTree<String,String>();
	}

}
