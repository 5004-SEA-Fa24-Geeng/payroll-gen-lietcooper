package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class EmployeeTest {
    Employee salaryEmployee;
    Employee hourlyEmployee;
    @BeforeEach
    void setUp() {
        salaryEmployee = new SalaryEmployee("Lijun", "w333", 10000, 100000, 2000, 1000);
        hourlyEmployee = new HourlyEmployee("Wan", "l123", 50, 100000, 2000, 1000);
    }

    @Test
    void getName() {
        assertEquals("Lijun", salaryEmployee.getName());
        assertEquals("Wan", hourlyEmployee.getName());
    }

    @Test
    void getID() {
        assertEquals("w333", salaryEmployee.getID());
        assertEquals("l123", hourlyEmployee.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(50, hourlyEmployee.getPayRate());
        assertEquals(10000, salaryEmployee.getPayRate());
    }

    @Test
    void getEmployeeType() {
        assertEquals("SALARY", salaryEmployee.getEmployeeType());
        assertEquals("HOURLY", hourlyEmployee.getEmployeeType());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(100000, hourlyEmployee.getYTDEarnings());
        assertEquals(100000, salaryEmployee.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(2000, hourlyEmployee.getYTDTaxesPaid());
        assertEquals(2000, salaryEmployee.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(1000, hourlyEmployee.getPretaxDeductions());
        assertEquals(1000, salaryEmployee.getPretaxDeductions());
    }

    @Test
    void runPayroll() {
        assertNotNull(salaryEmployee.runPayroll(10), "It should generate pay stub.");
        assertNotNull(hourlyEmployee.runPayroll(0), "It should generator pay stub.");
    }

    @Test
    void testNullRunPayroll() {
        assertNull(salaryEmployee.runPayroll(-10), "It should not work due to negative work hours!");
        assertNull(hourlyEmployee.runPayroll(-20), "It should not work due to negative work hours!");
    }

    @Test
    void calculateGrossPay() {
        double hours = 40;
        double expectedHourlyGrossPay = hours * hourlyEmployee.getPayRate();
        double expectedSalaryGrossPay = salaryEmployee.getPayRate() / SalaryEmployee.PAYDIVIDE;
        assertEquals(Builder.strToDouble(Double.toString(expectedHourlyGrossPay)),
                Builder.strToDouble(Double.toString(hourlyEmployee.calculateGrossPay(40))));
        assertEquals(Builder.strToDouble(Double.toString(expectedSalaryGrossPay)),
                Builder.strToDouble(Double.toString(salaryEmployee.calculateGrossPay(50))));
    }

    @Test
    void toCSV() {
        String salaryString = "SALARY,Lijun,w333,10000.00,1000.00,100000.00,2000.00";
        String hourlyString = "HOURLY,Wan,l123,50.00,1000.00,100000.00,2000.00";
        assertEquals(salaryString, salaryEmployee.toCSV());
        assertEquals(hourlyString, hourlyEmployee.toCSV());
    }
}