package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {
    
    private Builder() {
    }


     /**
     * Builds an employee object from a CSV string.
     * 
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     * 
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        String[] employee = csv.split(",");
        try {
            if (employee.length != 7) {
                throw new IllegalArgumentException("Items unmatched in employee.csv!");
            }
        } catch (IllegalArgumentException e) {
            return null;
        }
        if (employee[0].equals("HOURLY")) {
            return new HourlyEmployee(employee[1], employee[2], strToDouble(employee[3]),
                    strToDouble(employee[5]), strToDouble(employee[6]), strToDouble(employee[4]));
        } else if (employee[0].equals("SALARY")) {
            return new SalaryEmployee(employee[1], employee[2], strToDouble(employee[3]),
                    strToDouble(employee[5]), strToDouble(employee[6]), strToDouble(employee[4]));
        } else {
            return null;
        }
    }

   /**
     * Converts a TimeCard from a CSV String.
     * 
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] timeCard = csv.split(",");
        try {
            if (timeCard.length != 2) {
                throw new IllegalArgumentException("Items unmatched in time card!");
            }
        } catch (IllegalArgumentException e) {
            return null;
        }
        return new TimeCard(timeCard[0], strToDouble(timeCard[1]));
    }

    /**
     * convert string into double.
     * if the str is not a double, return -1.0
     * @param str, the string
     * @return double from the string.
     */
    public static double strToDouble(String str) {
        try {
            Double.parseDouble(str);
        } catch(NumberFormatException e) {
            System.err.println("The value is not a double!");
            return -1.0;
        }
        BigDecimal bd = new BigDecimal(str).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
