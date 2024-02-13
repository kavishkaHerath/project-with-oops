import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($ 1k - $ 1M: ", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterestRate, years);

        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage: " + result);
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (int month = 1; month <= years * MONTHS_IN_YEAR; month++){
            double balance = calculateBalance(principal, annualInterestRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true){
            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
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