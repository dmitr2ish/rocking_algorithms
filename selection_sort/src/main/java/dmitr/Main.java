package dmitr;

/**
 * Project name: rocking algorithms
 * Date: 10/3/2021
 * Author: dishmitov
 * Description:
 * Selection sort algorithm
 */

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        int[] intArray = {3, 2, 1, 4, 5, 7, 6, 8, 10, 9};
        int[] sortArray = selectionSort(intArray);
        for (int i : sortArray) {
            System.out.print(i + " ");
        }
    }

    private static int[] selectionSort(int[] intArray) {
        //  Для начала нужно пройти все элементы массива
        for (int i = 0; i < intArray.length; i++) {
            // возьмем за минимальный индекс начало
            int minIndex = i;
            //  Далее нужно перебрать данное число с остальными записями
            //  Начало от следующего элемента, i + 1
            //  Перебирать также по всей длине сортируемого массива
            for (int j = i + 1; j < intArray.length; j++) {
                //  если встречаем число меньше текущего
                if (intArray[j] < intArray[minIndex]) {
                    //  то меняем минимальное число
                    minIndex = j;
                }
            }
            // по окончании прохода меняем элементы местами
            int temp = intArray[i];
            intArray[i] = intArray[minIndex];
            intArray[minIndex] = temp;
        }
        return intArray;
    }
}
