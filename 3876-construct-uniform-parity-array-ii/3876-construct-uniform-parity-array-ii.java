class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd=0;
        boolean hasodd=false;
        int n=nums1.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums1[i]%2!=0){
                hasodd=true;
                odd=i;
                break;
            }
        }
        for(int i =0;i<n;i++){
            if(nums1[i]<min){
                min=nums1[i];
            }
        }
        if(hasodd==false){
            return true;
        }
        else{
            if(min%2==0){
                return false;
            }
            
        }
        return true;
    }
}