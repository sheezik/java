import java.util.ArrayList;

// Класс для множества целых чисел
class IntegerSet extends Set {
    public IntegerSet() {
        numbers = new ArrayList<>();
    }
    @Override
    public void display() {
        System.out.print("Множество целых чисел: ");
        for (Number number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    // Реализация метода sum для целых чисел
    @Override
    public double sum() {
        int sum = 0;
        for (Number number : numbers) {
            sum += number.intValue(); // Использование intValue() для целых чисел
        }
        return sum;
    }
}