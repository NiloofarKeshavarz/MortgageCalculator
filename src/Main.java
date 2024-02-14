import java.text.NumberFormat;

public class Main {
    final static byte Months_In_YEAR = 12;
    final  static byte PERCENT = 100;
    public static void main(String[] args) {
        int principal ;
        byte years ;
        float annualInterest;

        principal = (int) Console.readNumber("Principal(1K - 1M): " , 1000 , 1000000);
        annualInterest = (float) Console.readNumber("Annual Interest Rate: " , 1 , 30);
        years = (byte) Console.readNumber("Years: " , 1 , 30);

        double mortgage = calculateMortgage(principal , annualInterest , years);

        printMortgagePayment(mortgage);
        printPaymentSchedule(years, principal, annualInterest);
    }

    private static void printMortgagePayment(double mortgage) {
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("-----------");
        System.out.println("Monthly Payment: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(byte years, int principal, float annualInterest) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------");

        for(byte month = 1; month <= years * Months_In_YEAR ; month ++){
            double balance = calculateBalance(principal, annualInterest, years,month);
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(balanceFormatted);
        }
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