class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int maxp=Arrays.stream(piles).max().getAsInt();
       int low=1;
       int high=maxp;
       int ans=maxp; 
       while(low<=high){
        int mid=low+(high-low)/2;
        long tot=totspeed(piles,mid);

        if(tot<=h){
            ans=mid;
            high=mid-1;
        }
        else{
            low=mid+1;
        }
       }
       return ans;
    }
    private long totspeed(int[] arr,int s){
        long tot=0;
        for(int bananas : arr){
            tot+=(int)Math.ceil((double)bananas/s);
        }
        return tot;
    }
}