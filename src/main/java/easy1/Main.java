package easy1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите числа через пробел: ");
        String numbers = in.nextLine();
        int max = Integer.MIN_VALUE;
        int premax = Integer.MIN_VALUE;
        int amount = 0;
        int number = 0;
        boolean negative = false;
        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == '-') {
                negative = true;
                continue;
            }
            if ((numbers.charAt(i) >= '0') && (numbers.charAt(i) <= '9')) {
                number = number * 10 + (numbers.charAt(i) - '0');
                if (i + 1 != numbers.length()) continue;
            }
            if ((numbers.charAt(i) == ' ') || (i + 1 == numbers.length())) {
                if (negative) {
                    number = -number;
                    negative = false;
                }
                if (number >= max) {
                    premax = max;
                    max = number;
                } else if (number > premax)
                    premax = number;
                number = 0;
                amount++;
                continue;
            }

            System.out.println("Недопустимый символ: " + numbers.charAt(i));
            System.exit(0);
        }
        if (amount < 2)
            System.out.println("Введено меньше двух чисел.");
        else
            System.out.println("Значение 2ое по величине: " + premax);
    }
}

/* Недостатки:
 * 1) при наличии лишних пробелов возникает лишнее число: 0
 * 2) можно вводить несколько минусов подряд
 * 3) некорректно работает с числами > Integer.MAX_VALUE и < Integer.MIN_VALUE
 * 4) число вида "nnn-kkk-ggg" воспринимается как -nnnkkkggg
 */