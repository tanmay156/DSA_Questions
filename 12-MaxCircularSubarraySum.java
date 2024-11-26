/*Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.

Examples:

Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
Output: 22
Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.*/

class Solution {

    public int circularSubarraySum(int a[]) {
        int n = a.length;
        int count = 0;
        int maxx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
        
            if (a[i] > maxx) maxx = a[i];
          
            if (a[i] < 0) count++;
        }
        if (count == n) return maxx;

     
        int max_kadane = kadane(a);

        int max_wrap = 0;
        for (int i = 0; i < n; i++) {
            max_wrap += a[i];
            a[i] = -a[i];
        }

        max_wrap = max_wrap + kadane(a);

        return (max_wrap > max_kadane) ? max_wrap : max_kadane;
    }

    public int kadane(int a[]) {
        int n = a.length;
        int max_so_far = 0, max_ending_here = 0;
        for (int i = 0; i < n; i++) {
            max_ending_here = max_ending_here + a[i];

            if (max_ending_here < 0) max_ending_here = 0;

            if (max_so_far < max_ending_here) max_so_far = max_ending_here;
        }
        return max_so_far;
    }
}
