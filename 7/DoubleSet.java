import java.util.ArrayList;

// Класс для множества вещественных чисел
class DoubleSet extends Set {
    public DoubleSet() {
        numbers = new ArrayList<>();
    }
    @Override
    public void display() {
        System.out.print("Множество вещественных чисел: ");
        for (Number number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    // Реализация метода sum для вещественных чисел
    @Override
    public double sum() {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}