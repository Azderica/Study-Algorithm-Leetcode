package com.myepark;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i, l_ind = 0, r_ind = 0;
        int[] newArray;

        if (n == 0)
            newArray = nums2;
        else if (m == 0)
            newArray = nums1;
        else {
            newArray = new int[n + m];

            for (i = 0; l_ind < n && r_ind < m; i++) {
                if (nums1[l_ind] <= nums2[r_ind])
                    newArray[i] = nums1[l_ind++];
                else
                    newArray[i] = nums2[r_ind++];
            }
            while (l_ind < n) {
                newArray[i++] = nums1[l_ind++];
            }
            while (r_ind < m) {
                newArray[i++] = nums2[r_ind++];
            }
        }

        int mid = (n + m) / 2;
        if ((n + m) % 2 == 1)
            return newArray[mid] / 1.0;
        return (newArray[mid - 1] + newArray[mid]) / 2.0;
    }
}
