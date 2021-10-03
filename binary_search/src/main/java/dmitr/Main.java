package dmitr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Project name: rocking algorithms
 * Date: 10/3/2021
 * Author: dishmitov
 * Description:
 * Binary search algorithm
 */
@SuppressWarnings("all")
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        while (true) {
            System.out.println("Введите число для поиска:");
            Scanner scanner = new Scanner(System.in);
            int userNumber = scanner.nextInt();
            int indexNumberOfUser = binarySearch(userNumber, intArray);
            System.out.println("Данное число находится на позиции " +
                    ((indexNumberOfUser == -1) ? "отсутствует" : indexNumberOfUser));
        }
    }

    private static int binarySearch(int userNumber, int[] intArray) {
        //  сохраняем начальный индекс массива
        int low = 0;
        //  конечный
        int max = intArray.length - 1;
        //  обьявим середину
        int middle;
        //  запускаем цикл
        //  конец цикла, пока массив не сократится до одного элемента
        while (low <= max) {
            //  проверка среднего элемента
            middle = (low + max) / 2;
            //  если число равно, конец цикла
            if (userNumber == intArray[middle]) return middle;
            //  если число больше текущего обновляем
            //  минимум становится серединой шаг право
            if (userNumber > intArray[middle]) {
                low = middle + 1;
                //  если число меньше текущего максимум становится середина шаг влево
            } else {
                max = middle - 1;
            }
        }
        //
        return -1;
    }
}
