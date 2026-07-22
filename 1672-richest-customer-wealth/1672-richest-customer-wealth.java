class Solution {
    public int maximumWealth(int[][] acc) {
        int n=acc.length;
        int m=acc[0].length;
        int max=-1;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum+=acc[i][j];

            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }
}