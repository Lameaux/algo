package stack;

public class LinkedStackTest extends StackTestBase {

	@Override
	protected Stack<String> getStackImpl() {
		return new LinkedStack<String>();
	}

}
