package medium2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String string = in.nextLine();
        if (string.length() == 0)
            return;
        System.out.println("Закодированая строка: ");
        char c = string.charAt(0);
        int amount = 1;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == c)
                amount++;
            else {
                System.out.print(amount + "" + c);
                c = string.charAt(i);
                amount = 1;
            }
        }
        System.out.print(amount + "" + c);
    }
}
