class Solution {
    public int trap(int[] height) {
        int tot=0;
        int lmax=0;
        int rmax=0;
        int n=height.length;
        int l=0;
        int r=n-1;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]<lmax){
                    tot+=lmax-height[l];
                }
                else{
                    lmax=height[l];
                }
                l++;
            }
            else{
                if(height[r]<rmax){

                    tot+=rmax-height[r];
                }
                else{
                    rmax=height[r];
                }
                r--;
            }
        }
        return tot;
    }
}