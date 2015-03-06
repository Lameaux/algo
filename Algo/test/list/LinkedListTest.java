package list;

public class LinkedListTest extends ListTestBase {

	@Override
	protected List<String> getListImpl() {
		return new LinkedList<String>();
	}

}
