package com.steven.demo.algorithm;

public class RemoveElement {

    // 未删除后缀写法
    public int removeElement0(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != val) {
                i++;
            } else {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    //删除后缀，但是效率不高
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    //高效率写法
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}
