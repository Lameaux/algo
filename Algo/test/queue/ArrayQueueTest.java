package queue;


public class ArrayQueueTest extends QueueTestBase {

	@Override
	protected Queue<String> getQueueImpl() {
		return new ArrayQueue<String>();
	}

}
