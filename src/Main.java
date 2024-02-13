import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int result = MONTHS_IN_YEAR * PERCENT;
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Principal: ");
//        int principal = scanner.nextInt();
//
//        System.out.print("Annual Interest Rate: ");
//        float annualInterestRate = scanner.nextFloat();
//        float monthlyInterest = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
//
//        System.out.print("Period (Years): ");
//        byte years = scanner.nextByte();
//        int noOfPeriod = years * MONTHS_IN_YEAR;

//        double mortgage = principal *
//                (monthlyInterest * Math.pow((1+monthlyInterest), noOfPeriod)
//                        / (Math.pow((1+monthlyInterest), noOfPeriod) - 1));
//        String result = NumberFormat.getCurrencyInstance().format(mortgage);
      System.out.println("Mortgage: " + result);
    }
}