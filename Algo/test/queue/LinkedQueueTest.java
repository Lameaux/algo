package queue;

public class LinkedQueueTest extends QueueTestBase {

	@Override
	protected Queue<String> getQueueImpl() {
		return new LinkedQueue<String>();
	}

}
