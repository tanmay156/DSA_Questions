/*
You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

Note: Positive number starts from 1. The array can have negative integers too.

Example:

Input: arr[] = [2, -3, 4, 1, 1, 7]
Output: 3
Explanation: Smallest positive missing number is 3.
*/

class Solution {
  public:
    int missingNumber(vector<int> &arr) {
        int n=arr.size();
        for(int i=0;i<n;i++){
            while(arr[i]>=1 && arr[i]<=n && arr[i]!=arr[arr[i]-1]){
                swap(arr[i],arr[arr[i]-1]);
            }
        }
        for(int i=1;i<=n;i++){
            if(i!=arr[i-1]) return i;
        }
        return n+1;
    }
};
