package com.example.demo.utils;

/**
 * author MaoYu
 * 2021/10/18
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int []array = {1,2,4,5,6,8,8,8,9,9};
        int index = main.find(array,5);
        System.out.println(index);

    }
    int find(int [] array, int target) {
        int res = -1;
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right)/2;
            if (target > array[mid]) {
                left = mid + 1;
            }
            else if (target < array[mid]) {
                right = mid - 1;
            }
            else {
                res = mid;
                left = mid + 1;
            }
        }
        return  res;
    }
}
