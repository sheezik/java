/*
Множество чисел. Множество может содержать неповторяющиеся числа. Каждое
множество имеет мощность - количество содержащихся в нём чисел. Зададим множества двух типов:
множество целых чисел и множество вещественных чисел. Создать
набор (массив) множеств чисел. Найти в нём самое мощное множество и вывести его
на экран.

 */


public class Main {
    public static void main(String[] args) {
        // Создание массива множеств
        Set[] sets = new Set[] {
                new IntegerSet(),
                new DoubleSet(),
                new IntegerSet()
        };

        // Добавление чисел в множества
        sets[0].add(1);
        sets[0].add(2);
        sets[0].add(3);

        sets[1].add(1.1);
        sets[1].add(2.2);
        sets[1].add(3.3);

        sets[2].add(4);
        sets[2].add(5);
        sets[2].add(6);
        sets[2].add(7);

        // Нахождение самого мощного множества
        Set mostPowerfulSet = sets[0];
        int num = 0; ;
        for (int i = 1; i < sets.length; i++) {
            if (sets[i].getPower() > mostPowerfulSet.getPower()) {
                mostPowerfulSet = sets[i];
                num = i;
            }
        }

        // Вывод самого мощного множества
        System.out.println("Самое мощное множество номер " + (num+1) );
        mostPowerfulSet.display();

        // Вывод сумм элементов для каждого множества
        for (int i = 0; i< sets.length ;i++) {

            System.out.println("Сумма элементов множества "+ (i+1) + " : " + sets[i].sum());

        }
    }
}