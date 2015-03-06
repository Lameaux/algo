package tree;

import static org.junit.Assert.fail;

import org.junit.Test;

public class BSTArrayTest extends BSTTestBase {

	private static int MAX_TREE_HEIGHT = 5;

	@Override
	protected BST<String> getTreeImpl() {
		return new BSTArray<String>(MAX_TREE_HEIGHT);
	}

	@Test
	public void testBigN() {
		int N = 2 * MAX_TREE_HEIGHT;
		try {
			for (int i = 0; i < N; i++) {
				tree.add(String.valueOf(i));
			}

		} catch (ArrayIndexOutOfBoundsException ex) {
			fail("Should not throw Exception");
		}
	}

}
