import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal;
        float annualInterestRate = 0;
        byte years = 0;

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Principal ($ 1k - $ 1M: ");
            principal = scanner.nextInt();
            if(principal >= 1000 && principal < 1_000_000)
                break;
            System.out.println("Enter a value between 1,000 and 1,000,000");
        }

        while (true){
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if(annualInterestRate > 0 && annualInterestRate <= 30)
                break;
            System.out.println("Enter a value greater than 0 and less than 30");
        }

        float monthlyInterest = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

        while (true){
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if(years > 0 && years <= 30)
                break;
            System.out.println("Enter a value greater than 0 and less than 30");
        }
        int noOfPeriod = years * MONTHS_IN_YEAR;

        double mortgage = principal *
                (monthlyInterest * Math.pow((1+monthlyInterest), noOfPeriod)
                        / (Math.pow((1+monthlyInterest), noOfPeriod) - 1));
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + result);
    }
}