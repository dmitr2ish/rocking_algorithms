package dmitr;

import java.util.*;

/**
 * Project name: rocking algorithms
 * Date: 10/10/2021
 * Author: dishmitov
 * Description:
 * Рекурсивный обход бинарного дерева в глубину
 */

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        //  Синициализируем бинарное дерево sum = 153
        //          left  5  right
        //             /    \
        //           10      11
        //          /  \     /  \
        //        1    12   13   7
        //      /      /           \
        //     89     1             14
        Tree root = new Tree(5,
                new Tree(10,
                        new Tree(1,
                                new Tree(89), null),
                        new Tree(12,
                                new Tree(1), null)),
                new Tree(11,
                        new Tree(13),
                        new Tree(7, null, new Tree(14)))
        );
        System.out.println(root.sum());
        Map<String, String> map = new TreeMap<>();
        map.put(null, "a");
        System.out.println(map.get(null));
    }

    //  Класс бинарного дерева
    //  бинарное дерево - это такое дерево
    //  ноды которого могут содержать:
    //  0 детей - листы
    //  1, 2 детей - ноды
    //  корень дерева это нода без предков
    public static class Tree {
        //  значение ноды
        int value;
        //  левый ребенок
        Tree left;
        //  правый ребенок
        Tree right;

        //  конструктор для ноды
        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        //  конструктор для листа
        public Tree(int value) {
            this.value = value;
        }

        //  рекурсивная функция обхода дерева в глубь и сумирования всех элементов
        public int sum() {
            int sum = value;
            if (left != null) sum += left.sum();

            if (right != null) sum += right.sum();
            return sum;
        }
    }
}
