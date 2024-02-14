public class MortgageCalculator {
    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;

    private int principal;
    private float annualInterestRate;
    private byte years;

    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }
    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();

        int noOfPeriod = getNoOfPeriod();

        return principal *
                (monthlyInterest * Math.pow((1 + monthlyInterest), noOfPeriod)
                        / (Math.pow((1 + monthlyInterest), noOfPeriod) - 1));
    }

    public double calculateBalance(int noOfPaymentMade) {
        float monthlyInterest = getMonthlyInterest();
        int noOfPeriod = getNoOfPeriod();
        return (principal
                * (Math.pow(1 + monthlyInterest, noOfPeriod) - Math.pow(1 + monthlyInterest, noOfPaymentMade))
                / (Math.pow(1 + monthlyInterest, noOfPeriod) - 1));
    }

    private float getMonthlyInterest() {
        return annualInterestRate / MONTHS_IN_YEAR / PERCENT;
    }
    private int getNoOfPeriod() {
        return years * MONTHS_IN_YEAR;
    }
    public byte getYears() {
        return years;
    }
}
