/*Длинное натуральное число. Реализовать класс «Длинное натуральное число»,
  которое может принимать значения натуральных чисел, содержащее до двухсот цифр.
  (Можно использовать для внутреннего представления числа массивы или строки).
  Определить операцию сложения двух длинных чисел.
*/

public class Main {
    public static void main(String[] args) {

        LongNaturalNumber num1 = new LongNaturalNumber("111");
        LongNaturalNumber num2 = new LongNaturalNumber("22222");
        System.out.println("1 число: " + num1.getNumber());
        System.out.println("2 число: " + num2.getNumber());
        num1.addNumber(num2);
    }
}


