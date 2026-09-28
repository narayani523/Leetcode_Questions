class Solution {
    public int maxDepth(String s) {
        int OpenB=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') OpenB++;
            else if(s.charAt(i)==')') OpenB--;
            res=Math.max(res,OpenB);
        }
        return res;
    }
}