package student;

/**
 * An abstract class of Employee that implements IEmployee.
 */
public abstract class Employee implements IEmployee {
    /** employee's name.*/
    protected String name;

    /** employee's ID.*/
    protected String ID;

    /** the pay rate of the employee's type.*/
    protected double payRate;

    /** employee's type.*/
    protected String employeeType;

    /** employee's year to date earnings.*/
    protected double YTDEarnings;

    /** employee's taxes paid YTD.*/
    protected double YTDTaxPaid;

    /** employee's pre-tax deductions*/
    protected double pretaxDeductions;

    protected final static double taxRate = 0.2265;


    /**
     * A protected constructor for its subclass to inherit.
     * @param name, employee's name
     * @param id, employee's id
     * @param payRate, employee's pay rate
     * @param ytdEarnings, employee's ytd earnings
     * @param ytdTaxesPaid, employee's taxes paid ytd
     * @param pretaxDeductions, employee's pretax deductions
     */
    protected Employee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        this.name = name;
        this.ID = id;
        this.payRate = payRate;
        this.YTDEarnings = ytdEarnings;
        this.YTDTaxPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    /**
     * Get the name of the employee.
     *
     * @return the name of the employee
     */
    public String getName() {return name;}

    /**
     * Get the ID of the employee.
     *
     * @return the ID of the employee
     */
    public String getID() {return ID;}

    /**
     * Gets the employee's pay rate.
     *
     * @return the pay rate of the employee
     */
    public double getPayRate() {return payRate;}


    /**
     * Gets the employee's Type as a string.
     *
     * Either "HOURLY" or "SALARY" depending on the type of employee.
     *
     * You may want to consider using an enum to store
     * the type, and using .name() to get the string representation.
     *
     * @return the type of the employee as a string
     */
    public String getEmployeeType() {return employeeType;}

    /**
     * Gets the YTD earnings of the employee.
     *
     * @return the YTD earnings of the employee
     */
    public double getYTDEarnings() {return YTDEarnings;}

    /**
     * Gets the YTD taxes paid by the employee.
     *
     * @return the YTD taxes paid by the employee
     */
    public double getYTDTaxesPaid() {return YTDTaxPaid;}

    /**
     * Gets pretax deductions for the employee. Yes, on a normal paycheck this varies as either set
     * amounts or percents, and often more than one type of deduction.
     *
     * For now, you can just assume a single pretax deduction as a whole dollar amount.
     *
     * @return the pretax deductions for the employee
     */
    public double getPretaxDeductions() {return pretaxDeductions;}

    /**
     * generate pay stub for employees.
     * @param hoursWorked the hours worked for the pay period
     *
     * @return the pay stub, or return null if hoursWorked < 0
     */
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) return null;

        double grossPay = Builder.strToDouble(Double.toString(calculateGrossPay(hoursWorked)));
        double tax = Builder.strToDouble(Double.toString((grossPay - getPretaxDeductions()) * taxRate));
        double netPay = Builder.strToDouble(Double.toString(grossPay - tax - getPretaxDeductions()));

        return new PayStub(getName(),netPay, tax,getYTDEarnings() + netPay, getYTDTaxesPaid() + tax);
    }

    /**
     * calculate the gross pay for employees.
     * @param hoursWorked, hours worked
     * @return the gross pay
     */
    protected abstract double calculateGrossPay(double hoursWorked);

    /**
     * Converts the employee to a CSV string.
     *
     * Format of the String s as follows:
     *
     * employee_type,name,ID,payRate,pretaxDeductions,YTDEarnings,YTDTaxesPaid
     *
     * employee_type has the options for HOURLY or SALARY.
     *
     * You do not have to worry about commas in the name or any other field.
     *
     * @return the employee as a CSV string
     */
    public String toCSV() {return String.format(
            "%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
            getEmployeeType(), getName(), getID(), getPayRate(), getPretaxDeductions(), getYTDEarnings(), getYTDTaxesPaid()
        );}
}
