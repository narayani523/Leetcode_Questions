class Solution {
    public int maxDepth(String s) {
        int c=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                c++;
            }
            else if(s.charAt(i)==')'){
                c--;
            }
            ans=Math.max(c,ans);
        }
        return ans;
    }
}