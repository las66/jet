package easy2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = in.nextInt();
        if (number < 2) {
            System.out.println("Число должно быть > 1");
            System.exit(0);
        }
        System.out.println("Разложение на множители:");
        while ((number & 1) == 0) {
            System.out.print("2 ");
            number >>= 1;
        }
        int i = 3;
        while (i * i <= number) {
            if (number % i == 0) {
                System.out.print(i + " ");
                number /= i;
                continue;
            }
            i += 2;
        }
        if (number != 1)
            System.out.println(number);
    }
}

/* Недостатки:
 * 1) не работает с числами за границей Integer значений
 */