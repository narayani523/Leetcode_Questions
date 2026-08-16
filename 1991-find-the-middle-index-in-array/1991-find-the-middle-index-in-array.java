class Solution {
    public int findMiddleIndex(int[] nums) {
        int l=0;
        int sum=0;
    
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int r=0;
        for(int i=0;i<nums.length;i++){
            r=sum-nums[i]-l;
           
            if(l==r){
                return i;
            }
            l=l+nums[i];
            

        }
        return -1;
    }
}