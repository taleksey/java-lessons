package org.aleksey.lesson2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class ArrayHomeTask {
    @SuppressWarnings("checkstyle:MagicNumber")
    public static void main(String[] args) {
        LinkedList<Integer> firstList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        revereSort(firstList);
        System.out.printf(String.valueOf(firstList));
        System.out.printf("%n");

        LinkedList<Integer> secondList = new LinkedList<>(Arrays.asList(1, 2));
        revereSort(secondList);
        System.out.printf(String.valueOf(secondList));
        System.out.printf("%n");
    }

    public static void revereSort(LinkedList linkedList) {
        linkedList.sort(Collections.reverseOrder());
    }
}
