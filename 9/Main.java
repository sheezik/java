/*LinkedQueue.
  Создать реализацию generic-класса LinkedQueue, представляющую собой очередь,
  основанную на односвязном динамическом списке. Необходимые операции:
  создание очереди; размер очереди; проверка на пустоту; offer(); pool().
  Использовать стандартные коллекции нельзя, можно использовать динамический список
 */


public class Main {
    public static void main(String[] args) {
        LinkedQueue<Integer> queueInt = new LinkedQueue<>();
        queueInt.offer(1);
        queueInt.offer(2);
        queueInt.offer(3);
        queueInt.offer(4);
        queueInt.offer(5);
        queueInt.offer(6);
        LinkedQueue<String> queueString = new LinkedQueue<>();
        queueString.offer("Это");
        queueString.offer("строка");
        LinkedQueue<Character> queueChar = new LinkedQueue<>();
        queueChar.offer('a');
        queueChar.offer('b');
        queueChar.offer('c');
        queueChar.offer('d');
        queueChar.offer('e');
        System.out.println("\n" + "Размер очереди чисел: " + queueInt.size());
        System.out.println("Удаление и вывод первого числа: \n" + queueInt.poll());
        queueInt.printQueue();
        System.out.println("Размер очереди строк: " + queueString.size());
        System.out.println("Удаление и вывод первого слова: \n" + queueString.poll());
        queueString.printQueue();
        System.out.println("Размер очереди символов: " + queueChar.size() );
        System.out.println("Удаление и вывод первого символа: \n" + queueChar.poll());
        queueChar.printQueue();
    }
}

