class Solution {
    public int smallestNumber(int n, int t) {
        int dup=n;
        while(dup<2*dup){
            n=dup;
            int pr=1;
            int dig=0;
            while(n>0){
                dig=n%10;
                pr=pr*dig;
                n=n/10;
            }
            if(pr%t==0){
                return dup;

            }
            dup++;
        }
        return -1;
    }
}