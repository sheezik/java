/*
*Дано натуральное число a. Определить, можно ли его представить в виде сумм квадратов натуральных чисел
так, чтобы слагаемые этой суммы не
повторялись; порядок слагаемых не важен. Выдать найденную сумму.
*
*
*
*
* */


import java.util.*;

public class SumOfSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное число: ");
        int a = scanner.nextInt();

        List<Integer> squares = new ArrayList<>();
        int n = 1;


        while (n * n <= a) {
            squares.add(n * n);
            n++;
        }


        boolean found = false;
        for (int i = 0; i < (1 << squares.size()); i++) {
            int sum = 0;
            List<Integer> selectedSquares = new ArrayList<>();
            for (int j = 0; j < squares.size(); j++) {
                if ((i & (1 << j)) > 0) {
                    sum += squares.get(j);
                    selectedSquares.add(squares.get(j));
                }
            }
            if (sum == a) {
                found = true;
                System.out.println("Сумма квадратов числа  " + a + "  : " + selectedSquares);
                break;
            }
        }

        if (!found) {
            System.out.println("Не существует суммы квадратов для  " + a);
        }
        System.out.println(squares.size());
    }
}