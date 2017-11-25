
/**
 * A unit test for OrderedMap<K,V> that has tests for get, put, and containsKey.
 * One @Test demonstrates how to map an nGram to a List<Character>
 * 
 * @author Rick Mercer and Brian Loi
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class OrderedMapTest {

	@Test
	public void showAllFourMethods() {
		OrderedMap<Integer, String> ranking = new OrderedMap<Integer, String>();
		assertEquals(0, ranking.size());

		assertNull(ranking.put(1, "Kim"));
		ranking.put(2, "Chris");
		ranking.put(3, "Devon");
		assertEquals("Devon", ranking.put(3, "Dakota"));
		assertEquals(3, ranking.size());
		assertNull(ranking.get(99));

		assertEquals("Kim", ranking.get(1));
		assertEquals("Chris", ranking.get(2));
		assertNotNull("Dakota", ranking.get(3));

		assertFalse(ranking.containsKey(-99));
		assertTrue(ranking.containsKey(1));
	}

	@Test
	public void showNGramAsTheKeyAndListAsTheValue() {
		String nGram = "the";

		ArrayList<Character> followers = new ArrayList<Character>();
		followers.add('m');
		followers.add(' ');
		followers.add('n');

		OrderedMap<String, ArrayList<Character>> map = new OrderedMap<>();
		map.put(nGram, followers);
		assertEquals(3, map.get(nGram).size());
		assertEquals('m', (char) map.get(nGram).get(0));
		assertEquals('n', (char) map.get(nGram).get(2));
		map.get(nGram).add('r');
		assertEquals('r', (char) map.get(nGram).get(3));
	}
}