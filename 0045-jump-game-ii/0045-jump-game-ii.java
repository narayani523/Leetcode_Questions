class Solution {
    public int jump(int[] nums) {
        int jump=0;
        int r=0;
        int n=nums.length;
        int farthest=0;
        for(int i=0;i<n-1;i++){
             farthest=Math.max(farthest,nums[i]+i);
             if(i==r){
                jump++;
                r=farthest;
             }
             if(r>=n-1){
                break;
             }
        }
        return jump;
    }
}