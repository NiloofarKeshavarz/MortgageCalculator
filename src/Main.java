import java.text.NumberFormat;
import java.util.Scanner;
public class Main {
    final static byte Months_In_YEAR = 12;
    final  static byte PERCENT = 100;
    public static void main(String[] args) {
        int principal ;
        byte years ;
        float annualInterest;

        principal = (int)readNumber("Principal" , 1000 , 1000000);
        annualInterest = (float)readNumber("Annual Interest Rate: " , 1 , 30);
        years = (byte)readNumber("Years: " , 1 , 30);

        double mortgage = calculateMortgage(principal , annualInterest , years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly Payment: " + mortgageFormatted);
    }
    public static double readNumber(String prompt , double min , double max){
        double value;
        while(true) {
            System.out.println(prompt);
            Scanner input = new Scanner(System.in);
            value = input.nextFloat();
            if(value > min && value <= max)
                break;
            System.out.println("Enter a value  between" + min  + " and" + max);
        }
        return value;
    }
    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years
    ){
        short numberOfPayments = (short)(years * Months_In_YEAR);
        float monthlyInterest = annualInterest/PERCENT /Months_In_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }

    public static double calculateBalance(
            int principal ,
            float annualInterest,
            byte years,
            byte  numberOfPaymentMade

    ){
        short numberOfPayments = (short)(years * Months_In_YEAR);
        float monthlyInterest = annualInterest/PERCENT /Months_In_YEAR;

        double balance = principal *
                ((Math.pow((1 + monthlyInterest) , numberOfPayments) - Math.pow((1 + monthlyInterest),numberOfPaymentMade))
                        /(Math.pow((1 + monthlyInterest) , numberOfPayments) - 1));

        return balance;
    }
}