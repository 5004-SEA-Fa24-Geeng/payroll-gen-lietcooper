package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayStubTest {
    IPayStub payStub;

    @BeforeEach
    void setUp() {
        payStub = new PayStub("Lijun",24000,1000,100000,10000);
    }

    @Test
    void testGetPay() {
        assertEquals(24000, payStub.getPay());
    }

    @Test
    void testGetTaxesPaid() {
        assertEquals(1000, payStub.getTaxesPaid());
    }

    @Test
    void testToCSV() {
        String csvString = "Lijun,24000.00,1000.00,100000.00,10000.00";
        assertEquals(csvString, payStub.toCSV());
    }
}