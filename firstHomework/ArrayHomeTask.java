package firstHomework;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class ArrayHomeTask {
    public static void main(String[] args) {
        LinkedList<Integer> firstArray = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        revereSort(firstArray);
        System.out.printf(String.valueOf(firstArray));
        System.out.printf("%n");

        LinkedList<Integer> secondArray = new LinkedList<>(Arrays.asList(1, 2));
        revereSort(secondArray);
        System.out.printf(String.valueOf(secondArray));
        System.out.printf("%n");
    }

    public static void revereSort(LinkedList linkedList) {
        linkedList.sort(Collections.reverseOrder());
    }
}
