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

        MortgageReport.printMortgagePayment( principal, annualInterest,years);
        MortgageReport.printPaymentSchedule(principal, annualInterest,years);
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