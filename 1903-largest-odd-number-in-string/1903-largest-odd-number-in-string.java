class Solution {
    public String largestOddNumber(String s) {
        int end=-1;
        int i;
        //last odd digit
        for(i=s.length()-1;i>=0;i--){
            if((s.charAt(i)-'0')%2==1){
                end=i;
                break;

            }
        }
        if(end == -1) return "";

        //removing leading zeroes;
        i=0;
        while(i>=end && s.charAt(i)=='0'){
            i++;
        }
        return s.substring(i,end+1);
    }
}