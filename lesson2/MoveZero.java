package lesson2;

import java.util.ArrayList;

public class MoveZero {
    public static void main(String[] args) {
        System.out.println();
        int[] nums = {0, 1, 0, 3, 12};
        ArrayList<Integer> result = moveZeroes(nums);
        System.out.println(result);

        nums = new int[]{0};
        result = moveZeroes(nums);
        System.out.println(result);
    }

    public static ArrayList<Integer> moveZeroes(int[] nums) {
        ArrayList<Integer> valueList = new ArrayList<>();
        ArrayList<Integer> zeroValueList = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                valueList.add(num);
            } else {
                zeroValueList.add(num);
            }
        }

        valueList.addAll(zeroValueList);

        return valueList;
    }
}
