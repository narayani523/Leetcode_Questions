class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
      int ans=kdistinct(nums,k)-kdistinct(nums,k-1);
      return ans;
    }
    public int kdistinct(int[] nums,int k){
        if(k<=0 ){
            return 0;
        }
        int l=0;
        int r=0;
        int c=0;
        Map<Integer,Integer> freq=new HashMap<>();
        while(r<nums.length){
            freq.put(nums[r],freq.getOrDefault(nums[r],0)+1);
            while(freq.size()>k){
                freq.put(nums[l],freq.get(nums[l])-1);
                if(freq.get(nums[l])==0){
                    freq.remove(nums[l]);
                }
                l++;
            }
            c=c+(r-l+1);
            r++;
        }
        return c;
    }
}