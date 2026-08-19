class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> f=new HashMap<>();
        int n=nums.length;
        int zero=0;
        int one=0;
        int diff=0;
        int res=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zero++;
            }else one++;
            diff=zero-one;
            if(diff==0){
                res=(int)(Math.max(i+1,res));
                continue;
            }
            if(!f.containsKey(diff)){
                f.put(diff,i);
            }
            else{
                int idx=f.get(diff);
                int len=i-idx;
                res=(int)(Math.max(res,len));
            }
        }
        return res;
    }
}