package medium1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите числа через пробел: ");
        List<Integer> numbers = getNumbers(in);

        System.out.println("Введите n: ");
        int n = getN(in, numbers.size());

        System.out.println("n-й по величине элемент: " + numbers.get(n - 1));
    }

    private static List<Integer> getNumbers(Scanner in) {
        List<Integer> numbers = null;
        String strNumbers = in.nextLine();
        try {
            numbers = strToArr(strNumbers);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        numbers = reverseSort(numbers);
        return numbers;
    }

    private static int getN(Scanner in, int max) {
        int n = 0;
        try {
            n = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода");
            System.exit(0);
        }
        if (n < 1) {
            System.out.println("Ошибка ввода");
            System.exit(0);
        }
        if (n > max) {
            System.out.println("Чисел меньше, чем " + n);
            System.exit(0);
        }
        return n;
    }

    public static List<Integer> strToArr(String strNumbers) throws NumberFormatException {
        if ((strNumbers.length() == 0) || (strNumbers.charAt(strNumbers.length() - 1) == '-'))
            throw new NumberFormatException("Ошибка ввода");
        List<Integer> numbers = new ArrayList<>();
        boolean negative = false;
        int number = 0;
        boolean numberExist = false;
        for (int i = 0; i < strNumbers.length(); i++) {
            if (strNumbers.charAt(i) == '-') {
                if (negative || numberExist)
                    throw new NumberFormatException("Ошибка ввода");
                negative = true;
                continue;
            }
            if ((strNumbers.charAt(i) >= '0') && (strNumbers.charAt(i) <= '9')) {
                numberExist = true;
                number = number * 10 + (strNumbers.charAt(i) - '0');
                if (i + 1 != strNumbers.length()) continue;
            }
            if ((strNumbers.charAt(i) == ' ') || ((i + 1 == strNumbers.length()) && numberExist)) {
                if (negative) {
                    if (!numberExist)
                        throw new NumberFormatException("Ошибка ввода");
                    number = -number;
                    negative = false;
                }
                if (!numberExist)
                    continue;
                numbers.add(number);
                numberExist = false;
                number = 0;
                continue;
            }
            throw new NumberFormatException("Ошибка ввода");
        }
        return numbers;
    }

    private static List<Integer> reverseSort(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) < numbers.get(j)) {
                    int k = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, k);
                }
            }
        }
        return numbers;
    }
}

/* недостатки:
 * 1) некорректно работает с числами за пределом Integer
 */