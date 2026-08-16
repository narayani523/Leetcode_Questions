class Solution {
    public int pivotIndex(int[] nums) {
        int left=0;
        int sum=0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int r=sum-left-nums[0];
        if(left==r){
            return 0;
        }
        for(int i=1;i<nums.length;i++){
            left+=nums[i-1];
            int right=sum-nums[i]-left;
            if(left==right){
                return i;
            }
        }
        return -1;
    }
}