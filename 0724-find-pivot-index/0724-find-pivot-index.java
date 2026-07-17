class Solution {
    public int pivotIndex(int[] nums) {
        int tot=0;
        //int right=0;
        int left=0;
        for(int i=0;i<nums.length;i++){
            tot=tot+nums[i];
        }
        for(int i =0;i<nums.length;i++){
           int right=tot-left-nums[i];
           if(right==left){
            return i;
           }
           left=left+nums[i];
        }
        return -1;
    }
}