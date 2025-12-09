package assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketingTestStudent {

    private TicketingOffice office;

    @BeforeEach
    void setUp() {
        office = new TicketingOffice("White", 50.0, 30.0);
    }

    @Test
    void testConstructor() {
        assertEquals("White", office.getColor());
        assertEquals(50.0, office.getLength(), 0.001);
        assertEquals(30.0, office.getWidth(), 0.001);
        assertEquals("Ticketing Office", office.getBuildingType());
    }

    @Test
    void testSetSize() {
        office.setSize(60.0, 40.0);
        assertEquals(60.0, office.getLength(), 0.001);
        assertEquals(40.0, office.getWidth(), 0.001);
    }

    @Test
    void testSetColor() {
        office.setColor("Blue");
        assertEquals("Blue", office.getColor());
    }

    @Test
    void testSetBuildingType() {
        office.setBuildingType("Box Office");
        assertEquals("Box Office", office.getBuildingType());
    }

    @Test
    void testToString() {
        String expected = "TicketingOffice [Color: White, Length: 50.00, Width: 30.00, Type: Ticketing Office]";
        assertEquals(expected, office.toString());
    }
}
