package tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BSTRecursiveTest extends BSTTestBase {

	@Override
	protected BST<String> getTreeImpl() {
		return new BSTRecursive<String>();
	}

	@Test
	public void testBigN() {
		int N = 100000;
		for (int i = 0; i < N; i++) {
			tree.add(String.valueOf(i));
		}
		assertEquals(N, tree.size());
	}

}
