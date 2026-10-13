class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] sqrtArr = new long[n];
        for(int i=0;i<n;i++){
            sqrtArr[i] = nums[i] * nums[i];
        }
        long sum=0;
        Arrays.sort(sqrtArr);
        for(int i=0;i<n;i++){
            long sqr = sqrtArr[i];
            if(i<(n/2)){
                sum -= sqrtArr[i];
            } else{
                sum+=sqrtArr[i];
            }
        }
        return sum;
    }
}