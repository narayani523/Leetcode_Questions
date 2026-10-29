class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[] h=new int[m];
        if(matrix==null || matrix.length==0) return 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    h[j]++;
                }
                else{
                    h[j]=0;
                }
            }
            maxArea=Math.max(maxArea,largestRecArea(h));
        }
        return maxArea;
    }
    public int largestRecArea(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int max=0;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() &&(i==n || arr[st.peek()]>=arr[i])){
                int height=arr[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){
                    width=i;
                }
                else{
                    width=i-st.peek()-1;

                }

                max=Math.max(max,height*width);

            }
            st.push(i);
        }
        return max;
    }
}