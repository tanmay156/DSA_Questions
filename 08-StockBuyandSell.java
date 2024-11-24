/*
Given an array prices[] of length n, representing the prices of the stocks on different days.
The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. 
Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.

Note: Stock must be bought before being sold.

Example:

Input: prices[] = [7, 10, 1, 3, 6, 9, 2]
Output: 8
Explanation: You can buy the stock on day 2 at price = 1 and sell it on day 5 at price = 9. Hence, the profit is 8.
*/

class Solution {
    public int maximumProfit (int prices[]) {
        // Code here
        int start = prices[0];
        int maxProfit = 0;
        
        for(int i=0;i<prices.length; i++)
        {
            maxProfit = Math.max(maxProfit, prices[i] - start);
            
            start = Math.min(start, prices[i]);
            

        }
        return maxProfit;
    }
}
