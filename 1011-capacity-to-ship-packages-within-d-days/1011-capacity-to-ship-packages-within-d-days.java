class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high=0;
        for(int i=0;i<weights.length;i++){
            high+=weights[i];
        }
        while(low<=high){
            int mid=(low+high)/2;
            int totdays=noofdays(weights,mid);
            if(totdays<=days){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
    public int noofdays(int[] arr,int cap){
        int load=0;
        int dy=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+load>cap){
                dy++;
                load=arr[i];
            }
            else{
                load+=arr[i];
            }
        }
        return dy;
    }
}