/*53. Maximum Subarray
Given an integer array nums, find the subarray with the largest sum, and return its sum.
  */
//Complexity: 100% | Memory: 80.78%
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxSum=-pow(10,4);
        int currentSum=-pow(10,4);
        int currentNum=0;
        if(nums.size()==1)
            return nums[0];
        for(int i=0; i<nums.size(); i++){
            //record the greatest negative number until a positive appears.
            //start from positive number, and just keep on adding until you meet 
            //positive number. If current sum negative, then skip over to having
            //the next positive number as the first in the subarray. Else, then
            //just keep on adding.
            currentNum = nums[i];
            if(maxSum<0 && currentNum<0)//search for greatest negative number if no positive numbers currently
                currentSum= max(currentSum, currentNum);
            else if(currentSum<0 && currentNum>=0)//search for beginning of positive number in front sequence
                currentSum = currentNum;
            else if(maxSum>=0)//keep adding if there has already encountered positive number and adding new number is best decision
                currentSum+=currentNum;
           
            maxSum = max(maxSum, currentSum);
        }
        return maxSum;
    }
};
