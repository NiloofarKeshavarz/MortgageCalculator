import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        int principal ;
        byte years;
        float annualInterest;

      //  int paymentMade = 0;

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
            annualInterest = input.nextFloat();
            if(annualInterest > 0 && annualInterest <=30)
                break;
            System.out.println(
                    "Enter a value greater than 0 and less than 30."
            );
        }

        while(true) {
            System.out.println("Period(years): ");
            years = input.nextByte();
            if(years >=1 && years <=30)
                    break;
            System.out.println( "Enter a value between 1 and 30. ");
        }

        double mortgage = calculateMortgage(principal , annualInterest , years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE");
        System.out.println( "------------");
        System.out.println("Monthly Payment: " + mortgageFormatted);
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years
    ){
        final byte Months_In_YEAR = 12;
        final byte PERCENT = 100;
        short numberOfPayments = (short)(years * Months_In_YEAR);
        float monthlyInterest = annualInterest/PERCENT /Months_In_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }
}