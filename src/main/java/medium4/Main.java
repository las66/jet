package medium4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static medium1.Main.strToArr;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите сумму: ");
        int sum = in.nextInt();
        in.nextLine(); //для прочтения Enter

        System.out.println("Введите разменочные монеты: ");
        List<Integer> coins = getCoins(in);

        exchange(sum, coins, 0, new ArrayList<Integer>());
        print(coins, answers);
    }

    private static List<Integer> getCoins(Scanner in) {
        String strCoins = in.nextLine();
        List<Integer> coins = null;
        try {
            coins = strToArr(strCoins);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        for (int coin : coins)
            if (coin < 1) {
                System.out.println("Неверный номинал монеты");
                System.exit(0);
            }
        return coins;
    }

    private static void print(List<Integer> coins, List<List<Integer>> answers) {
        if (answers.size() == 0) {
            System.out.println("Разменов нет");
            return;
        }
        for (int i = 0; i < answers.size(); i++) {
            System.out.print((i + 1) + ") ");
            for (int j = 0; j < coins.size(); j++) {
                System.out.print(answers.get(i).get(j) + " по " + coins.get(j) + "к");
                if (j != coins.size() - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> answers = new ArrayList<>();

    private static void exchange(int sum, List<Integer> coins, int level, List<Integer> answer) {
        if (level == coins.size() - 1) {
            if (sum % coins.get(level) == 0) {
                answer.add(sum / coins.get(level));
                answers.add(answer);
            }
            return;
        }
        for (int i = 0; i <= sum / coins.get(level); i++) {
            List<Integer> preAnswer = new ArrayList<>(answer);
            preAnswer.add(i);
            exchange(sum - (coins.get(level) * i), coins, level + 1, preAnswer);
        }
    }
}

/* недостатки:
 * 1) из-за
 * in.nextLine(); //для прочтения Enter
 * могут произойти ситуации непроверенного неверного ввода данных
 */