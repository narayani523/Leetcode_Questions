class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int max=0;
        int pse=0;
        int nse=0;
        int el=0;

        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                el=st.peek();
                st.pop();
                pse=st.isEmpty()?-1:st.peek();
                nse=i;
                max=Math.max(max,heights[el]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            el=st.peek();
            st.pop();
            nse=heights.length;
            pse=st.isEmpty()?-1:st.peek();
            max=Math.max(max,heights[el]*(nse-pse-1));

        }
        return max;
    }
}