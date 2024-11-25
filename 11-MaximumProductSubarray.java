/*Given an array arr[] that contains positive and negative integers (may contain 0 as well).
Find the maximum product that we can get in a subarray of arr.

Example

Input: arr[] = [-2, 6, -3, -10, 0, 2]
Output: 180
Explanation: The subarray with maximum product is {6, -3, -10} with product = 6 * (-3) * (-10) = 180.*/

class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        int n = arr.length;
        int minVal = arr[0];
        int maxVal = arr[0];
        int maxProduct = arr[0];
        
        for (int i = 1; i < n; i++) { 
            if (arr[i] < 0) {
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }
            
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);
            
            maxProduct = Math.max(maxProduct, maxVal);
        }
        
        return maxProduct;
    }
}
