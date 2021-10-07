package dmitr;

/**
 * Project name: rocking algorithms
 * Date: 10/3/2021
 * Author: dishmitov
 * Description:
 * Quick sorting
 */

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[random(0,100)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random(0,100);
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    //  основной метод быстрой сортировки
    public static void quickSort(int[] array, int from, int to) {
        //  определяем базовый случай
        if (from < to) {
            //  получаем индекс опоры и сортировку относительно опоры
            int pivotIndex = partition(array, from, to);
            //  продолжаем сортировку рекурсивно поделив по опоре
            quickSort(array, from, pivotIndex - 1);
            quickSort(array, pivotIndex + 1 , to);
        }
    }

    //  вспомогательный метод деления и сортировки
    private static int partition(int[] array, int from, int to) {
        //  определяем маркеры
        int leftIndex = from;
        int rightIndex = to;

        //  определяем середину
        int middle = from + (to - from) / 2;
        //  берем опору
        int pivot = array[middle];
        //  проходим по массиву циклом пока маркеры не встретились
        while (leftIndex <= rightIndex) {
            //  если левый маркер меньше опоры иди дальше
            //  иначе маркер остается на числе
            while (array[leftIndex] < pivot) {
                leftIndex++;
            }
            //  если правый маркер больше pivot иди дальше
            //  иначе маркер остается на числе
            while (array[rightIndex] > pivot) {
                rightIndex--;
            }
            //  если маркеры не встретились зайти в условие и выполнить свап
            if (leftIndex <= rightIndex) {
                swap(array, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        //  вернуть до куда дошёл левый маркер
        return leftIndex;
    }

    //  метод свапа переменных
    private static void swap(int[] array, int right, int left) {
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;
    }

    //  генерация рандомного числа
    private static int random(int from, int to) {
        return (int) (Math.random() * (to - from)+from);
    }
}