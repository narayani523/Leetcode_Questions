class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=1;
        int n=position.length;
        int high=position[n-1]-position[0];
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(placed(position,mid,m)==true){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    public boolean placed(int[] arr,int pos,int m){
        int count=1;
        int last=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]-last >=pos){
                count++;
                last=arr[i];
            }
        }
        if(count>=m) return true;
        return false;
    }
}