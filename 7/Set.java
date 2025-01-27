import java.util.ArrayList;
import java.util.List;
// Базовый класс для множества
abstract class Set {
    protected List<Number> numbers;

    public Set() {
        numbers = new ArrayList<>();
    }

    public void add(Number number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    public int getPower() {
        return numbers.size();
    }

    // Абстрактный метод для вычисления суммы элементов
    public abstract double sum();

    // Виртуальный метод для вывода множества на экран
    public abstract void display();
}
