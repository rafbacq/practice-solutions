//#include<bits/stdc++.h>
/*1. Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/
//Complexity: 72.26 % | Memory: 50.59% 
#include<vector>
#include <iostream>
#include<unordered_map>
#include<sstream>
#include<string>
using namespace std;
class Solution {
public:
  Solution(){}; 
  vector<int> twoSum(const vector<int>& nums, int target) {
    unordered_map<int, int> hm;
    for(int i=0; i<nums.size(); i++){
        if(hm.contains(target-nums[i]))
        {
            return {hm[target-nums[i]], i};
        }
        else{
            hm.insert(std::pair<int, int>(nums[i], i));
        }
    }
    return {0,0};
  }
};
int main(){
    Solution s;
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    vector<int> nums;
    int target; 
    cin >>target;
    cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    string line;
    std::getline(std::cin, line);
    std::istringstream ss(line);
    int number;

    // Tokenize and parse integers
    while (ss >> number) {
        nums.push_back(number);
    }
    auto ans = s.twoSum(nums, target);
    cout << ans[0] << ' ' << ans[1] << "\n";
    return 0;
}
