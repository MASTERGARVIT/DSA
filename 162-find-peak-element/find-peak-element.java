class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int m = 0;
        if(nums.length ==1){
            return 0;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        if(nums[n-1]>nums[n-2]){
            return n-1;
        }
        int a = 1;
        int b = nums.length-2;
        while(a<=b){
            if(nums[a]>nums[a-1]&&nums[a]>nums[a+1]){
                return a;
            }
            if(nums[b]>nums[b-1]&&nums[b]>nums[b+1]){
                return b;
            }
            a++;
            b--;
        }
        return -1;
    }
}