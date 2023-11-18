import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

//2 VARIANT
public class lab1 {
    public static void main(String[] args) {
        int n = 0;
        while (true)
        {
            System.out.println("Введіть число рядків");
            Scanner sc1 = new Scanner(System.in);
            try {
                n = sc1.nextInt();
                break;
            } catch (InputMismatchException fg) {
                System.out.print("Ви запровадили не число. ");
            }
        }

        String[] str = new String[n];
        Scanner sc2 = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.printf(" Введіть рядок № %1$s%n", i + 1);
                    str[i] = sc2.nextLine();
        }
        System.out.println(Arrays.toString(str));

        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].length() < str[j].length()) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        int maxlength = str[0].length();
        System.out.println("Рядки в порядку спадання:");
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
            for (int j = 0; j < maxlength - str[i].length(); j++)
                System.out.print(" ");
            System.out.println(" її довжина = " + str[i].length());
        }
    }
}