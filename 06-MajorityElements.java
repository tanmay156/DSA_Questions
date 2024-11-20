/*You are given an array of integer arr[] where each number represents a vote to a candidate. 
Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

Note: The answer should be returned in an increasing format.

Example:

Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
Output: [5, 6]
Explanation: 5 and 6 occur more n/3 times.*/

class Solution {
    public List<Integer> findMajority(int[] nums) {
        int n = nums.length;
        int num1 = 0, num2 = 0, c1 = 0, c2 = 0;
        for (int x : nums) {
            if (x == num1) {
                c1++;
            } else if (x == num2) {
                c2++;
            } else if (c1 == 0) {
                num1 = x;
                c1++;
            } else if (c2 == 0) {
                num2 = x;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for (int x : nums) {
            if (x == num1) {
                c1++;
            } else if (x == num2) {
                c2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (c1 > n / 3) result.add(num1);
        if (c2 > n / 3) result.add(num2);

        Collections.sort(result);

        return result;
    }
}
