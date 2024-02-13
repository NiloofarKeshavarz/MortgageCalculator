import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final byte Months_In_YEAR = 12;
        final byte PERCENT = 100;


        Scanner input = new Scanner(System.in);
        System.out.println("Principal:");
        int principal =input.nextInt();

        System.out.println("Annual Intrest Rate: ");
        float annualInterest = input.nextFloat();
        float monthlyInterest = annualInterest/PERCENT /Months_In_YEAR;

        System.out.println("Period(years): ");
        byte years = input.nextByte();
        int numberOfPayments = years *Months_In_YEAR;


        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);


    }
}