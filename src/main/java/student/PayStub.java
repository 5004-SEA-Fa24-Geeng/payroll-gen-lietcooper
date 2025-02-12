package student;

/**
 * A class for pay stub that implements IPayStub.
 */
public class PayStub implements IPayStub {
    /** the name of the employee.*/
    private final String name;

    /** the final pay for the employee.*/
    private final double pay;

    /** the final taxes the employee paid.*/
    private final double taxesPaid;

    /** the final employee's YTD earnings.*/
    private final double ytdEarnings;

    /** the final employee's taxes paid YTD.*/
    private final double ytdTaxPaid;


    /**
     * Constructor for Pay Stub.
     * @param name, employee's name
     * @param pay, employee's pay
     * @param taxesPaid, employee's taxes for the pay
     * @param YTDEarnings, employee's YTD earnings
     * @param YTDTaxPaid, employee's taxes paid YTD
     */
    public PayStub(String name, double pay, double taxesPaid, double YTDEarnings, double YTDTaxPaid) {
        this.name = name;
        this.pay = pay;
        this.taxesPaid = taxesPaid;
        this.ytdEarnings = YTDEarnings;
        this.ytdTaxPaid = YTDTaxPaid;
    }

    /**
     * get the pay of the employee.
     *
     * @return pay
     */
    public double getPay() {
        return pay;
    }

    /**
     * get the paid taxes of the employee.
     *
     * @return taxesPaid
     */
    public double getTaxesPaid() {
        return taxesPaid;
    }

    /**
     * Converts the PayStub object to a CSV string.
     *
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     *
     * @return the CSV string
     */
    public String toCSV() {return String.format(
            "%s,%.2f,%.2f,%.2f,%.2f", name, pay, taxesPaid, ytdEarnings, ytdTaxPaid
    );}
}
