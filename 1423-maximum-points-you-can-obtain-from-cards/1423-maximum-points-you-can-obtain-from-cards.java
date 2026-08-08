class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int right=cardPoints.length-1;
        int maxum=0;
        int lsum=0;
        for(int i=0;i<k;i++){
            lsum=lsum+cardPoints[i];
            maxum=lsum;
        }

        int rsum=0;
        for(int i=k-1;i>=0;i--){
            lsum=lsum-cardPoints[i];
            rsum=rsum+cardPoints[right];
            right--;
            maxum=(int)Math.max(maxum,rsum+lsum);
        }
        return maxum;
    }
}