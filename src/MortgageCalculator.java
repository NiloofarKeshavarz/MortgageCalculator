public class MortgageCalculator {
    private final static byte Months_In_YEAR = 12;
    private final  static byte PERCENT = 100;
    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest =  annualInterest;
        this.years =  years;
    }

    private int getNumberOfPayments() {
        return years * Months_In_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / Months_In_YEAR;
    }
    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];

        for (short month = 1; month <= balances.length; month++)
            balances[month -1] = calculateBalance(month);
          return balances;
    }

    public  double calculateMortgage(){
        short numberOfPayments = (short) getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }

    public  double calculateBalance(short numberOfPaymentMade) {
        short numberOfPayments = (short) getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();

        double balance = principal *
                ((Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), numberOfPaymentMade))
                        / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1));

        return balance;
    }
}
