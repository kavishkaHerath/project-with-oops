public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal ($ 1k - $ 1M: ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        MortgageReport.printMortgage(years, principal, annualInterestRate);
        MortgageReport.printPaymentSchedule(years, principal, annualInterestRate);
    }

    public static double calculateMortgage(int principal, float annualInterestRate, byte years){
        float monthlyInterest = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

        int noOfPeriod = years * MONTHS_IN_YEAR;

        return principal *
                (monthlyInterest * Math.pow((1+monthlyInterest), noOfPeriod)
                        / (Math.pow((1+monthlyInterest), noOfPeriod) - 1));
    }
    public static double calculateBalance(int principal, float annualInterestRate, byte years, int noOfPaymentMade){
        float monthlyInterest = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
        int noOfPeriod = years * MONTHS_IN_YEAR;
        return (principal
                * (Math.pow(1 + monthlyInterest, noOfPeriod) - Math.pow(1 + monthlyInterest, noOfPaymentMade))
                / (Math.pow(1 + monthlyInterest, noOfPeriod) - 1));
    }
}