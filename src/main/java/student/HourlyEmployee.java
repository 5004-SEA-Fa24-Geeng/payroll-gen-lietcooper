package student;

/**
 * A class for hourly employees.
 */
public class HourlyEmployee extends Employee{
    /** set the employee type to HOURLY.*/
    private String employeeType = "HOURLY";

    /** the start hours of overtime.*/
    protected static double OVERTIME = 40;

    /** the coefficient in calculating the pay for hourly employee*/
    protected static double PAYCOEFFICIENT = 1.5;


    /**
     * constructor for hourly employee.
     * @param name employee's name
     * @param id employee's id
     * @param payRate employee's pay rate
     * @param ytdEarnings employee's ytd earnings
     * @param ytdTaxesPaid employee's taxes paid ytd
     * @param pretaxDeductions employee's pretax deductions
     */
    public HourlyEmployee(String name, String id, double payRate,double ytdEarnings,
                          double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    /**
     * get the employee type.
     * @return employeeType
     */
    public String getEmployeeType() {
        return employeeType;
    }

    /**
     * Calculate the gross pay for hourly employee.
     * For hourly employees, the pay is calculated as payRate * hoursWorked for the first 40 hours,
     * then payRate * 1.5 * (hoursWorked - 40) for overtime.
     * @param hoursWorked the hours worked
     * @return the gross pay
     */
    protected double calculateGrossPay(double hoursWorked) {
        return (hoursWorked <= OVERTIME ?
                getPayRate() * hoursWorked : getPayRate() * (PAYCOEFFICIENT * hoursWorked - 0.5 * OVERTIME));
    }
}
