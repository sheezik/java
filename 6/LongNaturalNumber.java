import java.util.Arrays;

public class LongNaturalNumber {
    private String number;
    public LongNaturalNumber(String number) {
        this.number = number;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    private int[] strToInt(String[] num) {
        int[] intNum = Arrays.stream(num)
                .mapToInt(Integer::parseInt)
                .toArray();
        return intNum;
    }
    static int[] reverse(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[array.length - 1 - i] = array[i];
        }
        return newArray;
    }
    public LongNaturalNumber addNumber(LongNaturalNumber naturalNumber) {
        //разбиваем стрки на символы (цифры)
        String[] num1 = this.number.split("");
        String[] num2 = naturalNumber.getNumber().split("");
        //переворачиваем числа
        int[] intNum1 = reverse(strToInt(num1));
        int[] intNum2 = reverse(strToInt(num2));
        String sum = "";
        int unitsInMind = 0;//кол-во единиц в уме
        //цикл с кол-ом итераций = максимальной длине числа
        for (int i = 0; i < Math.max(intNum1.length, intNum2.length); i++) {
            //На каждой итерации суммируем соответствующие цифры из массивов, добавляем единицу в уме
            int a = (i < intNum1.length ? intNum1[i] : 0) + (i < intNum2.length ? intNum2[i] : 0) + unitsInMind;
            unitsInMind = a / 10;
            a %= 10;
            sum += a;
        }
        System.out.print("Сумма: " + new StringBuilder(sum).reverse().toString());
        return null;
    }
}