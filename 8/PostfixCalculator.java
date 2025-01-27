/*
Обратная польская запись. Дана текстовая строка, содержащая арифметическое вещественное выражение в обратной польской записи (ОПЗ). Реализовать вычислитель
выражения в ОПЗ; использовать стек.ПОСТФИКСНАЯ
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PostfixCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите постфиксное выражение: ");
        String expression = scanner.nextLine();

        try {
            double result = evaluatePostfix(expression);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static double evaluatePostfix(String expression) {
        Deque<Double> stack = new ArrayDeque<>();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = applyOperator(token, operand1, operand2);
                stack.push(result);
            } else {
                stack.push(Double.parseDouble(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static double applyOperator(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return operand1 / operand2;
        }
        throw new IllegalArgumentException("Неизвестный оператор: " + operator);
    }
}