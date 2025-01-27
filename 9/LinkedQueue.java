public class LinkedQueue<T> {
    //внутренний класс, который представляет узел очереди.
    private class Node {
        T data;//данные
        Node next;//указатель на следующий узел в очереди
        //конструктор узла
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node head;//начало очереди
    private Node tail;//конец очереди
    private int size;//размер очереди
    //конструктор
    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    //метод возвращает размер очереди
    public int size() {
        return size;
    }
    //метод проверяет пуста ли очередь.
    public boolean isEmpty() {
        return size == 0;
    }
    //метод добавляет элемент в конец очереди
    public void offer(T data) {
        Node newNode = new Node(data);//создание узла
        if (isEmpty()) {//проверка на пустоту
            head = newNode;//добавляем первый элемент
        } else {
            tail.next = newNode;//добавляем следующий элемент
        }
        tail = newNode;//конец очереди - добавленный элемент
        size++;//увеличение размера очереди
    }
    //метод удаляет и возвращает элемент из начала очереди.
    public T poll() {
        //если пустая очередь, возвращает null
        if (isEmpty()) {
            return null;
        }
        T data = head.data;//первый элемент
        head = head.next;//первый элемент заменяется следующим
        size--;//уменьшаем размер
        //если очередь пуста, последний элемент null
        if (isEmpty()) {
            tail = null;
        }
        return data;//возврат удалённого элемента очереди
    }
    public void printQueue() {
        Node newNode = head;//новый узел
        //проход по заданной очереди
        for (int i = 0; i < size; i++) {
            //вывод символа
            System.out.print(newNode.data + "\n");
            //переход к следующему символу
            newNode = newNode.next;
        }
        System.out.println("\n");
    }
}