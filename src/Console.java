import java.util.Scanner;

public class Console {
    private static Scanner input = new Scanner(System.in);
    public  static double readNumber(String prompt){
        return  input.nextDouble();
    }
    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.println(prompt);
            value = input.nextDouble();
            if (value > min && value <= max)
                break;
            System.out.println("Enter a value  between" + min + " and" + max);
        }
        return value;
    }
}
