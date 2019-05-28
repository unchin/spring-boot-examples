package com.steven.demo.algorithm;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

     static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String args[]){
        int[] nums = {1,1,12,2,3,4,5,5};
        RemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        String str = Arrays.toString(nums);
        System.out.println(str);
    }

}
