class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st =new Stack<>();
        int rem=k;
        for(char dig: num.toCharArray()){
            while( rem>0 && !st.isEmpty() && st.peek()>dig){
                st.pop();
                rem--;
            }
            st.push(dig);
        }
        while(rem>0 && !st.isEmpty()){
            st.pop();
            rem--;
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        res.reverse();

        int start=0;
        while(start<res.length() && res.charAt(start)=='0'){
            start++;
        }
        if(start==res.length()){
            return "0";
        }
        return res.substring(start);
        
    }
}