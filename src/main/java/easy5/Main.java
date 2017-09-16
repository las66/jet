package easy5;

import java.util.Scanner;

public class Main {
    // выдаёт позицию первого вхождения подстроки или -1, если таковых нет
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String string = in.nextLine();
        System.out.println("Введите подстроку: ");
        String substring = in.nextLine();
        label:
        for (int i = 0; i <= string.length() - substring.length(); i++) {
            for (int j = 0; j < substring.length(); j++) {
                if (substring.charAt(j) != string.charAt(i + j))
                    continue label;
            }
            System.out.println(i + 1);
            return;
        }
        System.out.println(-1);
    }
}

/* недостатки:
 * 1) требует много времени в "плохих" случаях
 */
