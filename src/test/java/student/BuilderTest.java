package student;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    @Test
    void buildEmployeeFromCSV() {
        String employeeCSV = "HOURLY,Lijun,w333,24000,100000,10000,1000";
        assertNotNull(Builder.buildEmployeeFromCSV(employeeCSV), "Failed to create Hourly Employee Lijun");
    }

    @Test
    void testNullBuildEmployeeFromCSV() {
        String errEmployeeCSV1 = "Hourly,Lijun,w333,24000,100000,10000,1000";  // type unmatched
        String errEmployeeCSV2 = "SALARY,Wan,w333,24000,100000,10000";  // items number unmatched
        String errEmployeeCSV3 = "SALARY,Lijun,w333,24000,100000,10000,-1000";  // illegal double value

        assertNull(Builder.buildEmployeeFromCSV(errEmployeeCSV1), "employee1 should not be created due to unmatched employee type!");
        assertNull(Builder.buildEmployeeFromCSV(errEmployeeCSV2), "employee2 should not be created due to unmatched items!");
        assertNull(Builder.buildEmployeeFromCSV(errEmployeeCSV3), "employee3 should not be created due to negative double value!");
    }


    @Test
    void buildTimeCardFromCSV() {
        ITimeCard timeCard1 = Builder.buildTimeCardFromCSV("w333,-30");
        ITimeCard timeCard2 = Builder.buildTimeCardFromCSV("l123,0");
        ITimeCard timeCard3 = Builder.buildTimeCardFromCSV("j012,50");

        assertNotNull(timeCard1, "Fail to create timeCard1.");
        assertNotNull(timeCard2, "Fail to create timeCard2.");
        assertNotNull(timeCard3, "Fail to create timeCard3.");

    }

    @Test
    void strToDouble() {
        String str = "100.00";
        assertEquals(100.0, Builder.strToDouble(str));
    }

    @Test
    void testStrToDoubleNotThrowException() {
        String str = "1w1";
        assertDoesNotThrow(() -> Builder.strToDouble(str), "strToDouble should not throw exception!");
        assertEquals(-1.0, Builder.strToDouble(str));
    }
}