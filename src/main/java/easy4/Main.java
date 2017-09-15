package easy4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите сумму: ");
        int sum = in.nextInt();
        List<int[]> set = new ArrayList<>();
        for (int i = 0; i <= sum / 7; i++) {
            for (int j = 0; j <= (sum - i * 7) / 5; j++) {
                int rem = sum - i * 7 - j * 5;
                if (rem % 3 == 0) {
                    set.add(new int[]{i, j, rem / 3});
                }
            }
        }
        if ((set.size() == 0) || (set.get(0)[0] != 0))
            System.out.println("Нет разменов на монеты 3 и 5");
        else
            System.out.println("Размен на монеты 3 и 5:");
        if (set.size() == 0) {
            System.out.println("Нет разменов на монеты 3, 5 и 7");
            return;
        }
        for (int i = 0; (i < set.size()) && (set.get(i)[0] == 0); i++) {
            System.out.println((i + 1) + ") " + set.get(i)[1] + " по 5к и " + set.get(i)[2] + " по 3к");
        }

        System.out.println("\nРазмен на монеты 3, 5 и 7:");
        for (int i = 0; i < set.size(); i++) {
            System.out.println((i + 1) + ") " + set.get(i)[0] + " по 7к, " + set.get(i)[1] + " по 5к и " + set.get(i)[2] + " по 3к");
        }
    }
}

/* недостатки:
 * 1) если при размене не используются монеты номиналом X, то выводиться "0 по Xк"
 */
