class Solution {
    public int countCommas(int n){
        int commas=0;
        if(n<=999){
            return 0;
        }
        else if(n>=1000 && n<=100000){
            commas= (n-999);
        }

        return commas;
    }

}