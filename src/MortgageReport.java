import java.text.NumberFormat;

public class MortgageReport {
    public static void printMortgage(byte years, int principal, float annualInterestRate) {
        double mortgage = Main.calculateMortgage(principal, annualInterestRate, years);
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage: " + result);
    }

    public static void printPaymentSchedule(byte years, int principal, float annualInterestRate) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (int month = 1; month <= years * Main.MONTHS_IN_YEAR; month++){
            double balance = Main.calculateBalance(principal, annualInterestRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
