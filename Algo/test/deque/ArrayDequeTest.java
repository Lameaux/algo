package deque;

public class ArrayDequeTest extends DequeTestBase {

	@Override
	protected Deque<String> getDequeImpl() {
		return new ArrayDeque<String>();
	}

}
