import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        var line = scanner.nextLine();
        var numbers = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt);
        System.out.println(numbers.sum());
    }
}
