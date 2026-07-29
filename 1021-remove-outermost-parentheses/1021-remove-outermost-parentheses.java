class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res=new StringBuilder();
        int c=0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                if(c>0) res.append(ch);
                c++;
            }
            else if(ch==')'){
                c--;
                if(c>0) res.append(ch);
            }
        }
        return res.toString();
    }
}