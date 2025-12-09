package assignment6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AcrobaticTestStudent {

    @Test
    public void testConstructorAndInheritedGetters() {
        Acrobatic acrobatic = new Acrobatic("name1", 30, 8, "job1");

        assertEquals("name1", acrobatic.getName());
        assertEquals(30, acrobatic.getAge());
        assertEquals(8, acrobatic.getYearsWorked());
        assertEquals("job1", acrobatic.getJob());
    }

    @Test
    public void testToString() {
        Acrobatic acrobatic = new Acrobatic("name2", 35, 12, "job2");
        String expected = "Name: name2\nAge: 35\nYears Worked: 12\nJob: job2";
        assertEquals(expected, acrobatic.toString());
    }
}
