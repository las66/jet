package easy3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String string = in.nextLine();
        if (string.length() < 2) {
            System.out.println("Строка является палиндромом");
            return;
        }
        for (int i = 0; i < string.length() / 2; i++)
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                System.out.println("Строка не является палиндромом");
                return;
            }

        System.out.println("Строка является палиндромом");
    }
}
