/*
    Дана целочисленная прямоугольная матрица размера 𝑚 × 𝑛, заполненная случайными числами. Дано натуральное число 𝑘 ≤ 𝑛.
    Выполнить циклический сдвиг элементов матрицы на k позиций «по змейке», которая начинается с левого верхнего угла
    и проходит по строкам слева направо. Часть элементов каждой строки, «выходящих» за пределы матрицы вправо,
    переходит на следующую строку, элементы последней строки сдвигаются в верхнюю строчку
    Кондаков А.А ПИ-2Э 14.04.24
 */
import java.util.*;

public class Main {

    private static final Random rand = new Random();

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int k = 3;

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        System.out.println("Исходная матрица:");
        printMatrix(matrix);
        move(matrix, k);
        System.out.println("Матрица после сдвига:");
        printMatrix(matrix);
    }

    private static void move(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] temp = new int[m * n];
        int index = 0;
        // Копируем элементы матрицы в массив
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[index++] = matrix[i][j];
            }
        }
        //Сдвигаем на к (с учетом перебора)
        k = k % (m * n);
        int[] shifted = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            shifted[(i + k) % (m * n)] = temp[i];
        }
        // Копируем обратно в матрицу
        index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = shifted[index++];
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%5d ", element);
            }
            System.out.println();
        }
        System.out.println();
    }
}