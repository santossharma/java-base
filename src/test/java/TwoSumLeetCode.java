import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=cWUmrgMw220

// https://leetcode.com/problems/two-sum/

public class TwoSumLeetCode {
    public static void main(String[] args) {

        int[] nums = new int[] {7, 2, 11, 15};

        int[] result = twoSum(nums, 9);

        for (int i = 0; i < result.length; i++) {
            System.out.print(" " + result[i]);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int tmp = target - nums[i];

            if(map.keySet().contains(tmp)) {
                return new int[] {map.get(tmp), i};
            }

            map.put(nums[i], i);
            //System.out.println(map);
        }
        return new int[0];
    }
}
