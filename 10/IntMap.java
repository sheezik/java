/*
Создать реализацию generic-класса IntMap, представляющего собой ассоциативный массив (словарь) элементов с целочисленным ключом и произвольного типа
значением. Необходимые операции: создание пустого словаря; добавление элемента
в словарь; поиск по ключу; удаление по ключу; вывод на консоль. Использовать стандартные коллекции, реализующие Set или Map нельзя.
 */
public class IntMap<V> {

    private static class Entry<V> {
        int key;
        V value;
        Entry<V> next; // Для цепочки

        public Entry(int key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry<V>[] entries;
    private int size;

    @SuppressWarnings("unchecked")
    public IntMap() {
        entries = new Entry[16]; // Начальный размер массива
        size = 0;
    }

    // Добавление элемента
    public void put(int key, V value) {
        int index = key % entries.length; // Хеширование ключа
        if (entries[index] == null) {
            entries[index] = new Entry<>(key, value);
            size++;
        } else {
            // Проверка на наличие ключа и перезапись значения
            Entry<V> current = entries[index];
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            // Добавление нового элемента в цепочку
            current = entries[index];
            entries[index] = new Entry<>(key, value);
            entries[index].next = current;
            size++;
        }
    }

    // Поиск по ключу
    public V get(int key) {
        int index = key % entries.length;
        Entry<V> current = entries[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Ключ не найден
    }

    // Удаление по ключу
    public V remove(int key) {
        int index = key % entries.length;
        Entry<V> current = entries[index];
        Entry<V> previous = null;
        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    entries[index] = current.next; // Удаление первого элемента в цепочке
                } else {
                    previous.next = current.next; // Удаление элемента из середины цепочки
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null; // Ключ не найден
    }

    // Вывод на консоль
    public void print() {
        System.out.println("IntMap:");
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null) {
                Entry<V> current = entries[i];
                while (current != null) {
                    System.out.println("Ключ: " + current.key + ", Значение: " + current.value);
                    current = current.next;
                }
            }
        }
    }

    // Размер словаря
    public int size() {
        return size;
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        IntMap<String> map = new IntMap<>();
        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Три");

        System.out.println("Размер: " + map.size()); // Вывод: 3
        System.out.println("Значение по ключу 2: " + map.get(2)); // Вывод: Два
        map.print(); // Вывод: IntMap:
        //           Ключ: 1, Значение: Один
        //           Ключ: 2, Значение: Два
        //           Ключ: 3, Значение: Три

        map.remove(2);
        System.out.println("Размер: " + map.size()); // Вывод: 2

        map.put(2, "Два-бис"); // Перезапись значения по ключу
        map.print();
    }
}