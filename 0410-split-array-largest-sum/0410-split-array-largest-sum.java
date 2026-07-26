class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Arrays.stream(nums).max().getAsInt();
        int high=0;
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            high=high+nums[i];
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(isSplit(nums,mid,k)==true){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean isSplit(int[] nums,int cap,int k){
        int sum=0;
        int arrc=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>cap){
                return false;
            }
            if(sum+nums[i]>cap){
                arrc++;
                sum=nums[i];
            }
            else{
                sum+=nums[i];
            }
        }
        if(arrc<=k) return true;
        else return false;
    }
}