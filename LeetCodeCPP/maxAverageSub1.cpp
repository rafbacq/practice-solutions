/*643. Maximum Average Subarray I
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Personal Note: This solution kinda bleh but i did this really quick cuz i had to go somewhere
Complexity: 100 % | Memory: 94 %
  */
class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        double maxVal = -pow(10,4);
        double currentVal = 0;
        int n=0;
        if(nums.size()==1)
            return nums[0];
        for(int i=0; i<k; i++)
            currentVal += nums[i];
        for(int i=k; i<nums.size(); i++)
        {
                maxVal = max(currentVal/k, maxVal);
                currentVal -= nums[n];
                currentVal += nums[i];
                n++;
                
        }
        maxVal = max(currentVal/k, maxVal);
        return maxVal;
    }
};
