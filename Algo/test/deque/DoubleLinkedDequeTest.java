package deque;

public class DoubleLinkedDequeTest extends DequeTestBase {

	@Override
	protected Deque<String> getDequeImpl() {
		return new DoubleLinkedDeque<String>();
	}

}
