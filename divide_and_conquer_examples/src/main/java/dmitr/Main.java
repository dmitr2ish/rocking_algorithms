package dmitr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project name: rocking algorithms
 * Date: 10/3/2021
 * Author: dishmitov
 * Description:
 * Simple example functions in divide and conquer strategy
 */

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        List<Integer> someArray = new ArrayList<Integer>();
        List<Integer> someArray_2 = new ArrayList<Integer>();
        List<Integer> someArray_3 = new ArrayList<Integer>();
        List<Integer> someArray_4 = new ArrayList<Integer>();

        int random = (int) (20 + (Math.random() * 40));
        for (int i = 0; i < random; i++) {
            System.out.print(i + " ");
            someArray.add(i);
        }

        System.out.println();
        someArray_2.addAll(someArray);
        someArray_3.addAll(someArray);
        someArray_4.addAll(someArray);
        System.out.println("ArrayList:");
        System.out.println("Sum of elements: " + sum(someArray));
        System.out.println("Count of elements: " + countElements(someArray_2));
        System.out.println("Max number is: " + findMax(someArray_3));

        int[] arr = new int[]{3, 6, 9, 10};
        System.out.println("Array:");
        System.out.println("Sum of elements: " + sum(arr));
        System.out.println("Count of elements: " + countElements(arr));
        System.out.println("Max number is: " + findMax(arr));
    }

    //  сумма элементов списка
    private static int sum(List<Integer> someArray) {
        //  определяем базовый случай
        //  если длина 0, то и сумма 0
        if (someArray.size() == 0) return 0;
        //  сохраняем первый элемент в текущем стеке
        int sum = someArray.get(0);
        //  удаляем этот элемент и передаем список дальше плюс первый элемент
        someArray.remove(0);
        return sum + sum(someArray);
    }

    //  сумма элементов массива
    private static int sum(int[] someArray) {
        //  определяем базовый случай
        //  если длина 0, то и сумма 0
        if (someArray.length == 0) return 0;
        //  сохраняем первый элемент в текущем стеке
        int sum = someArray[0];
        // сокращаем решение и передаем дальше по стеку
        int[] temp = new int[someArray.length - 1];
        System.arraycopy(someArray, 1, temp, 0, temp.length);
        return sum + sum(temp);
    }

    //  количество элементов в списке
    private static int countElements(List<Integer> someArray) {
        //  определяем базовый случай
        if (someArray.size() == 0) return 0;
        //  сокращаем решение
        someArray.remove(0);
        //  сохраняем значение в текущем стеке и передаем вызов дальше
        return 1 + countElements(someArray);
    }

    //  количество элементов в массиве
    private static int countElements(int[] someArray) {
        //  определяем базовый случай
        if (someArray.length == 0) return 0;
        //  сокращаем решение
        int[] temp = new int[someArray.length - 1];
        System.arraycopy(someArray, 1, temp, 0, temp.length);
        //  передаем дальше по стеку + 1 за стек
        return 1 + countElements(temp);
    }

    //  поиск максимума в списке
    private static int findMax(List<Integer> someArray) {
        //  определяем базовый случай
        if (someArray.size() == 2) return (someArray.get(0) > someArray.get(1)) ? someArray.get(0) : someArray.get(1);
        //  сохраняем текущий принятый за max, в стеке
        int max = someArray.get(0);
        //  сокращаем решение
        someArray.remove(0);
        //  сравниваем с текущим и опускаемся дальше по стеку
        return (max > findMax(someArray)) ? max : findMax(someArray);
    }

    //  поиск максимума в массиве
    private static int findMax(int[] someArray) {
        //  определяем базовый случай
        if (someArray.length == 2) return (someArray[0] > someArray[1]) ? someArray[0] : someArray[1];
        //  сохраняем текущий принятый за max, в стеке
        int max = someArray[0];
        //  сокращаем решение
        int[] tempArr = new int[someArray.length - 1];
        System.arraycopy(someArray, 1, tempArr, 0, tempArr.length);
        //  сравниваем с текущим и опускаемся дальше по стеку
        return (max > findMax(tempArr)) ? max : findMax(tempArr);
    }
}
