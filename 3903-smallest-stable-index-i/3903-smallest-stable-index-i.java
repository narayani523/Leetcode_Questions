class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int score=0;
        for(int i=0;i<nums.length;i++){
            max=(int)(Math.max(nums[i],max));
            int min=Integer.MAX_VALUE;
            for(int l=i;l<nums.length;l++){
                min=(int)Math.min(nums[l],min);
            }
            score=max-min;
            if(score<=k){
                return i;
            }
        }
        return -1;
    }
}