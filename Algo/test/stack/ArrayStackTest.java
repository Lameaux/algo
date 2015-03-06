package stack;

public class ArrayStackTest extends StackTestBase {

	@Override
	protected Stack<String> getStackImpl() {
		return new ArrayStack<String>();
	}

}
