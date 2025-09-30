/**
 * 
 */
package lab3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class GradebookTester {
	private GradeBook g1; 
	private GradeBook g2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		g1 = new GradeBook(5); 
		g2 = new GradeBook(5);
		g1.addScore(100);
		g1.addScore(75);
		g2.addScore(55.5);
		g2.addScore(60);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		g1 = null; 
		g2 = null; 
	}
	/**
	 * Test method for {@link test.GradeBook#addScore(double)}.
	 */
	@Test
	public void testAddScore() {
		 assertTrue(g1.toString().equals("100.0 75.0 0.0 0.0 0.0 "));
		 assertTrue(g2.toString().equals("55.5 60.0 0.0 0.0 0.0 "));
		 
		 assertEquals(2,g1.getScoreSize());
		 assertEquals(2,g2.getScoreSize());
	}

	/**
	 * Test method for {@link test.GradeBook#sum()}.
	 */
	@Test
	public void testSum() {
		assertEquals(175, g1.sum(),.0001);
		assertEquals(115.5, g2.sum(),.0001);
	}

	/**
	 * Test method for {@link test.GradeBook#minimum()}.
	 */
	@Test
	public void testMinimum() {
		assertEquals(75,g1.minimum(),0001);
		assertEquals(55.5,g2.minimum(),.0001);
	}

	/**
	 * Test method for {@link test.GradeBook#finalScore()}.
	 */
	@Test
	public void testFinalScore() {
		assertEquals(100,g1.finalScore(),0.0001);
		assertEquals(60,g2.finalScore(),0.0001);
	}
}
