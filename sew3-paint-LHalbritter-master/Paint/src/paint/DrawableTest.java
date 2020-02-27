/**
 * 
 */
package paint;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Test.*;

/**
 * @author user
 *
 */
public class DrawableTest {

	
	private Color c;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c = Color.YELLOW;
	}

	
	@Test
	public void KlassennameTest(){
		Klassenname k = new Klassenname();
		int expected = 2;
		assertEquals(expected, k.getInt());
	}
	
	@Test
	public void getColorTest(){
		
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
