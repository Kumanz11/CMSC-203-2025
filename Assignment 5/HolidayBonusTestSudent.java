package assignment5;

import static org.junit.Assert.*;
import org.junit.Test;

public class HolidayBonusTestSudent {

	double[][] data = {
			{ 1.0, 2.0, 3.0 },
			{ 4.0, 5.0 },
			{ -1.0, 10.0, 2.0, 1.0 }
	};

	@Test
	public void testCalculateHolidayBonus() {
		double[] bonus = HolidayBonus.calculateHolidayBonus(data);

		assertEquals(3, bonus.length);

		// These values depend on your constants
		// If your constants are:
		// HIGH = 5000, LOW = 1000, OTHER = 2000,
		// these checks will pass automatically once your code is correct.

		assertTrue(bonus[0] >= 0);
		assertTrue(bonus[1] >= 0);
		assertTrue(bonus[2] >= 0);
	}

	@Test
	public void testCalculateTotalHolidayBonus() {
		double total = HolidayBonus.calculateTotalHolidayBonus(data);
		assertTrue(total > 0);
	}
}
