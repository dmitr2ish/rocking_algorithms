package dmitr;

import java.util.*;

/**
 * Project name: rocking algorithms
 * Date: 10/9/2021
 * Author: dishmitov
 * Description:
 * TODO
 */

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        //  создадим дерево
        Map<String, String[]> tree = new HashMap();
        tree.put("I", new String[]{"Bob", "Clare", "Alice"});
        tree.put("Bob", new String[]{"Anuj", "Peggy", "I"});
        tree.put("Alice", new String[]{"Peggi", "Peggy", "I"});
        tree.put("Clare", new String[]{"Tom", "Jhonny", "I"});

        for (String i : tree.keySet()) {
            System.out.println("Node " + i);
            for (String j : tree.get(i)) {
                System.out.println("\tHis branch " + j);
            }
        }
        System.out.println("-------------------------------");
//        System.out.println(breadth_first_search(tree, 'q'));
        breadth_first_search(tree);
    }

    //  Реализация алгоритма
    //   - Создать очередь с именами проверяемых людей
    //   - Создать очередь с именами, которые проверены
    //   - извлечь из очереди очередного человека
    //   - проверить есть ли он в очереди из проверенных
    //      - если есть -> continue
    //      - если нет
    //      - добавить его в очередь проверенных
    //      - проверить условие для окончания, если условие не выполнено добавить всех друзей в список
    //  перейти к началу цикла
    //  если очередь пуста закончить

    //  Поиск в ширину, найти имя содержащее букву
    public static String breadth_first_search(Map<String, String[]> tree, Character symbol) {
        //  создаем очередь 1 уровня
        LinkedList<String> nodes = new LinkedList<>();
        nodes.addAll(tree.keySet());
        //  создаем очередь проверенных
        List<String> checkedNames = new ArrayList<>();
        //  пока очередь не пуста проверяем очередь по первому
        while (!nodes.isEmpty()) {
            //  берем первый элемент из очереди
            String name = nodes.getFirst();
            //  и сразу удаляем его из очереди
            nodes.remove(0);
            //  проверяем есть ли он в очереди проверенных
            if (checkedNames.contains(name)) {
                //  если есть continue
                continue;
            } else {
                //  добавляем его в очередь проверенных
                checkedNames.add(name);
                //  проверяем условие
                if (name.indexOf(symbol) != -1) {
                    //  если символ содержится элемент найден
                    return name;
                } else {
                    //  добавляем в конец очереди всех детей данной ноды
                    //  если они есть, если их нет продолжить
                    String[] child = tree.get(name);
                    if (child == null) {
                        continue;
                    } else {
                        nodes.addAll(Arrays.asList(child));
                    }
                }
            }
        }
        return "Пустенько";
    }

    //  Обход в ширину, распечатать все дерево
    public static void breadth_first_search(Map<String, String[]> tree) {
        //  создаем очередь 1 уровня
        LinkedList<String> nodes = new LinkedList<>();
        nodes.addAll(tree.keySet());
        //  создаем очередь проверенных
        List<String> checkedNodes = new ArrayList<>();
        //  пока очередь не пуста проверяем очередь по первому
        while (!nodes.isEmpty()) {
            //  берем первый элемент
            String node = nodes.getFirst();
            //  проверяем проверялся ли текущий элемент
            if (checkedNodes.contains(node)) {
                // если проверялся continue
                continue;
            } else {
                //  если нет добавляем в список проверенных
                checkedNodes.add(node);
                //  удаляем его из очереди
                nodes.remove(node);
                //  распечатываем его
                System.out.println(node);
                //  добавляем все его бранчи в очередь:
                //      - если хотим проверять сначала бранчи
                //          - добавить в начало очереди
                //      - если хотим проверять сначала ноды
                //          - добавить в конец очереди
                //  добавляем в конец очереди все бранчи
                //  если бранчи есть иначе continue
                if (tree.get(node) == null) {
                    continue;
                } else {
                    nodes.addAll(Arrays.asList(tree.get(node)));
                }
            }
        }
    }
}
