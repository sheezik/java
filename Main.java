/*Даны два массива - список фамилий абитуриентов и список соответствующих
        * им оценок по ЭГЭ. Отсортировать список абитуриентов по убыванию оценок,
        * в случае совпадения оценки сравнивать абитуриентов по фамилии.
        *
        *Лаба 3 вариант 15
        *
        *
        *
        * */


import java.lang.reflect.Array;
import java.util.*;


public class Main {

    public static void main(String[] args) {


        String[] abiturients = new String[]{"Marina","Amir","Aarseniy", "Maria"};
        Integer[] grades = new Integer[]{2,3,3,2} ;
        for (int i = 0; i < abiturients.length; i++) {
            System.out.println(abiturients[i] + " - " + grades[i]);

        };
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < grades.length ; ++i) {
                if ((grades[i - 1] < grades[i])||(grades[i-1]==grades[i]) &&(abiturients[i].compareTo(abiturients[i-1]) < 0 )) {
                    isSorted = false;

                    int tmp = grades[i - 1];
                    grades[i - 1] = grades[i];
                    grades[i] = tmp;
                    String tpm = abiturients[i - 1];
                    abiturients[i - 1] = abiturients[i];
                    abiturients[i] = tpm;
                }
            }
        }
        System.out.println("Отсортированный порядок :");
        for (int i = 0; i < abiturients.length; i++) {
            System.out.println(abiturients[i] + " - " + grades[i]);

        };




    }
}