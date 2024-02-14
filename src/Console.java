import java.util.Scanner;

public class Console {
    public static double readNumber(String prompt, double min, double max) {
        Scanner input = new Scanner(System.in);
        double value;
        while (true) {
            System.out.println(prompt);
            value = input.nextFloat();
            if (value > min && value <= max)
                break;
            System.out.println("Enter a value  between" + min + " and" + max);
        }
        return value;
    }
}
