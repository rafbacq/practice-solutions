/*
1800. Maximum Ascending Subarray Sum
Given an array of positive integers nums, return the maximum possible sum of an strictly increasing subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

Complexity: 100% | Memory: 47.72%
  */
class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        if(nums.size()==1)
            return nums[0];
        int currentSum=nums[0];
        int bestSum=0;
        for(int i=0; i<nums.size()-1; i++){
            if(nums[i+1]>nums[i]){
                currentSum+=nums[i+1];
            }
            else{
                bestSum=max(bestSum, currentSum);
                currentSum=nums[i+1];
            }
        }
        bestSum=max(bestSum, currentSum);
        return bestSum;
    }
};
