package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCardTest {
    ITimeCard timeCard;

    @BeforeEach
    void setUp() {
        timeCard = new TimeCard("w333", 30);
    }

    @Test
    void testGetEmployeeID() {
        assertEquals("w333", timeCard.getEmployeeID());
    }

    @Test
    void testGetHoursWorked() {
        assertEquals(30, timeCard.getHoursWorked());
    }
}