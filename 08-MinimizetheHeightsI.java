/*
Given a positive integer k and an array arr[] denoting heights of towers, you have to modify the height of each tower either by increasing or decreasing them by k only once.
Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.

Example:

Input: k = 2, arr[] = [1, 5, 8, 10]
Output: 5
Explanation: The array can be modified as [3, 3, 6, 8]. The difference between the largest and the smallest is 8 - 3 = 5.
*/

class Solution {
    public int getMinDiff(int k, int[] arr) {
        int n = arr.length;
        if (n == 1) return 0; 
        
        Arrays.sort(arr);

        int minDiff = arr[n - 1] - arr[0];

        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        if (smallest > largest) {
            int temp = smallest;
            smallest = largest;
            largest = temp;
        }
        for (int i = 0; i < n - 1; i++) {
            int minHeight = Math.min(smallest, arr[i + 1] - k);
            int maxHeight = Math.max(largest, arr[i] + k);
            minDiff = Math.min(minDiff, maxHeight - minHeight);
        }

        return minDiff;
    }
}
