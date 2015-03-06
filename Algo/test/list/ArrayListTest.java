package list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;

import org.junit.Test;

public class ArrayListTest extends ListTestBase {

	@Override
	protected List getListImpl() {
		return new ArrayList();
	}

	@Test
	public void testTrimToSize() {
		String value1 = "value1";
		list.add(value1);
		assertEquals("Size = 1", 1, list.size());
		((ArrayList) list).trimToSize();
		assertEquals("Size = 1", 1, list.size());

		try {
			Field f = list.getClass().getDeclaredField("array");
			f.setAccessible(true);
			Object[] array = (Object[]) f.get(list);
			assertEquals("Size = 1", 1, array.length);
		} catch (Exception e) {
			fail("Unable to check the size");
		}
	}

}
