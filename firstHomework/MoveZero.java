package firstHomework;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        ArrayList<Integer> result = moveZeroes(nums);
        System.out.println(result);

        nums = new int[]{0};
        result = moveZeroes(nums);
        System.out.println(result);
    }

    public static ArrayList<Integer> moveZeroes(int[] nums) {
        ArrayList<Integer> arr_new = new ArrayList<>();
        ArrayList<Integer> arr_zero = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                arr_new.add(num);
            } else {
                arr_zero.add(num);
            }
        }

        arr_new.addAll(arr_zero);

        return arr_new;
    }
}
