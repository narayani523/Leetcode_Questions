class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Arrays.stream(nums).max().getAsInt();
        int n=nums.length;
        int min=1;
        int ans=-1;
        while(min<=max){
            int mid=min+(max-min)/2;
            int sum=sumAll(nums,mid);
            if(sum<=threshold){
                ans=mid;
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return ans;
    }
    public int sumAll(int[] nums,int div){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/div);
        }
        return sum;
    }
}