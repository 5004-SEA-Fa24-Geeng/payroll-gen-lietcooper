package student;


/**
 * A class for salary employees.
 */
public class SalaryEmployee extends Employee{
    /** set the employee type to SALARY.*/
    private String employeeType = "SALARY";

    /** division for the pay of the salary employees.*/
    protected final static double PAYDIVIDE = 24;


    /**
     * constructor for salary employee.
     * @param name, employee's name
     * @param id, employee's id
     * @param payRate, employee's pay rate
     * @param ytdEarnings, employee's ytd earnings
     * @param ytdTaxesPaid, employee's taxes paid ytd
     * @param pretaxDeductions, employee's pretax deductions
     */
    public SalaryEmployee(String name, String id, double payRate,double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    /**
     * get the employee type
     * @return employeeType
     */
    public String getEmployeeType() {return employeeType;}

    /**
     * calculate the gross pay for salary employee.
     * For salary employees, it is pay rate divided by 24 for two payments every month.
     * @param hoursWorked, the hours worked
     * @return the gross pay
     */
    protected double calculateGrossPay(double hoursWorked) {
        return getPayRate() / PAYDIVIDE;
    }
}
