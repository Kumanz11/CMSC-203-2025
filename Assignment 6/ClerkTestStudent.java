package assignment6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClerkTestStudent {

    @Test
    public void testConstructorAndInheritedGetters() {
        Clerk clerk = new Clerk("name1", 35, 10, "job1");

        assertEquals("name1", clerk.getName());
        assertEquals(35, clerk.getAge());
        assertEquals(10, clerk.getYearsWorked());
        assertEquals("job1", clerk.getJob());
    }

    @Test
    public void testToString() {
        Clerk clerk = new Clerk("name2", 40, 12, "job2");
        String expected = "Name: name2\nAge: 40\nYears Worked: 12\nJob: job2";
        assertEquals(expected, clerk.toString());
    }
}
