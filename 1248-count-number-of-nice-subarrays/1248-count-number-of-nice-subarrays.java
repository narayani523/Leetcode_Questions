class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans=oddsub(nums,k)-oddsub(nums,k-1);
        return ans;
    }
    public int oddsub(int[] nums,int k){
        if(k<0) return 0;
        int l=0;
        int r=0;
        int odd=0;
        int c=0;
        while(r<nums.length){
            if(nums[r]%2!=0){
                odd++;
            }
            while(odd>k){
                if(nums[l]%2!=0){
                    odd--;
                }
                l++;
            }
            c=c+(r-l+1);
            r++;
        }
        return c;
    }
}