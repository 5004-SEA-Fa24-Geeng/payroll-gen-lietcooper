package student;

/**
 * A time card class that implements ITimeCard.
 */
public class TimeCard implements ITimeCard{
    /** employee's id.*/
    private final String ID;

    /** employee's worked hours.*/
    private final double hoursWorked;

    /**
     * constructor for time card.
     * @param ID, employee's id
     * @param hoursWorked, employee's worked hours
     */
    public TimeCard(String ID, double hoursWorked) {
        this.ID = ID;
        this.hoursWorked = hoursWorked;
    }

    /**
     * get the id of the employee.
     *
     * @return the id of the employee
     */
    public String getEmployeeID() {return ID;}

    /**
     * get the worked hours of the employee.
     *
     * @return hoursWorked
     */
    public double getHoursWorked() {return hoursWorked;}
}
