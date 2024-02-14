import java.text.NumberFormat;

public class MortgageReport {

    private  MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public  void printMortgagePayment() {
        double mortgage = calculator.calculateMortgage();

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("-----------");
        System.out.println("Monthly Payment: " + mortgageFormatted);
    }

    public  void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-----------");

        for (short month = 1; month <= calculator.getYears() * MortgageCalculator.Months_In_YEAR; month++) {
            double balance = calculator.calculateBalance(month);
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(balanceFormatted);
        }
    }
}
