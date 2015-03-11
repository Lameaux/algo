package deque;

public class LinkedDequeTest extends DequeTestBase {

	@Override
	protected Deque<String> getDequeImpl() {
		return new LinkedDeque<String>();
	}

}
