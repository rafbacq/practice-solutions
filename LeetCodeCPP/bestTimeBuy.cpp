/*
121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
Best Result: Time Complexity: 100 % | Memory: 99.11 %
*/
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buyAt =0;
        int sellAt=0; //indexes 
        int bestProfit=0;
        for(int i=0; i<prices.size(); i++)
        {
            if(prices[i]<prices[buyAt])
            {
                buyAt=i;
            }
            if(prices[sellAt]-prices[buyAt] < 0 )
            {
                buyAt++;
            }
            else
            {
                bestProfit = max(bestProfit, prices[sellAt]-prices[buyAt]);
                sellAt++;
            }
        }
        return bestProfit;
    }
};
