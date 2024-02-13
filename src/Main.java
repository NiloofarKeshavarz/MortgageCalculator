import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final byte Months_In_YEAR = 12;
        final byte PERCENT = 100;
        int principal ;
        float monthlyInterest;
        int numberOfPayments;


        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Principal(1K -1M):");
            principal =input.nextInt();
            if(principal >= 1000 && principal <= 1000000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        while(true) {
            System.out.println("Annual Interest Rate: ");
            float annualInterest = input.nextFloat();
            if(annualInterest > 0 && annualInterest <=30) {
                monthlyInterest = annualInterest/PERCENT /Months_In_YEAR;
                break;
            }
            System.out.println(
                    "Enter a value greater than 0 and less than 30."
            );
        }

        while(true) {
            System.out.println("Period(years): ");
            byte years = input.nextByte();
            if(years >=1 && years <=30){
                numberOfPayments = years * Months_In_YEAR;
                    break;
            }
            System.out.println(
                    "Enter a value between 1 and 30. "
            );
        }


        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);


    }
}