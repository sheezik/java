/*
*Вводить с клавиатуры последовательность вещественных чисел до 0
* (сам 0 не входит в последовательность). Найти длину самой длинной
*  неубывающей подпоследовательности подряд идущих чисел.
*
*
* */


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = 0;
        System.out.println("Вводите числа до 0");
        int maxLength = 1;
        int length = 1;
        a = scan.nextDouble();
        while (true) {
            double x = scan.nextDouble();
            if (x == 0)
                break;
            if (x>=a)
                length+=1;
            else length=1;
            if (maxLength<length)
            {
                maxLength=length;
            }
            a = x;
        }

        System.out.println("Максимальная длина неубывающей последовательности = "+maxLength);
        scan.close();
    }
}