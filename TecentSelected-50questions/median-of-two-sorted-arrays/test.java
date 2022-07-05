import java.lang.Math;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m + n)%2 == 0){
            int left = (m + n)/2;
            int right = left + 1;
            return (getKth(nums1, 0, m-1, nums2, 0, n-1, left) + getKth(nums1, 0, m-1, nums2, 0, n-1, right)) * 0.5;
        }else{
            int mid = (m + n + 1)/2;
            return getKth(nums1, 0, m-1, nums2, 0, n-1, mid);
        }
    }

    private double getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // make sure len1 is always the smaller one
        if (len2 < len1){
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0){
            return (double) nums2[start2 + k -1];
        }
        if (k==1){
            return (double) Math.min(nums1[start1], nums2[start2]);
        }
        // pick the rank k/2 number to compare
        int i = start1 + Math.min(k/2, len1) - 1;
        int j = start2 + Math.min(k/2, len2) - 1;
        if (nums1[i] < nums2[j]){
            // then the elements with index 0~i of nums1 cannot be the kth number
            return getKth(nums1, i+1, end1, nums2, start2, end2, k-Math.min(k/2, len1));
        }else{
            // else is the same for nums2
            return getKth(nums1, start1, end1, nums2, j+1, end2, k-Math.min(k/2, len2));
        }
    }
}