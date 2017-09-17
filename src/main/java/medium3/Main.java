package medium3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String string = in.nextLine();
        if (string.length() == 0)
            return;
        String answer = "";
        int number = 0;
        boolean numberExist = false;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if ((c >= '0') && (c <= '9')) {
                numberExist = true;
                number = number * 10 + (c - '0');
            } else {
                if (numberExist) {
                    for (int j = 0; j < number; j++) {
                        answer += c;
                    }
                    number = 0;
                    numberExist = false;
                } else {
                    System.out.println("Неверный ввод");
                    System.exit(0);
                }
            }
        }
        if (numberExist) {
            System.out.println("Неверный ввод");
            System.exit(0);
        }
        System.out.println("Раскодированная строка:\n" + answer);
    }
}
