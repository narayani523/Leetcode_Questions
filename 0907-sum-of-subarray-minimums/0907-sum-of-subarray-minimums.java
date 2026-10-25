class Solution {
    public int[] findPrevLess(int[] arr){
        int n=arr.length;
        int[] prev=new int[n];
        Arrays.fill(prev, -1);
        Stack<Integer> idx=new Stack<>();
        for(int i=0;i<n;i++){
            while(!idx.isEmpty() && arr[idx.peek()]>arr[i]){
                idx.pop();
            }
            if(!idx.isEmpty()){
                prev[i]=idx.peek();
            }
            idx.push(i);
        }
        return prev;
    }
    public int[] findNextLessOrEq(int[] arr){
        int n=arr.length;
        int[] next=new int[n];
        Arrays.fill(next, n);
        Stack<Integer> idx=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!idx.isEmpty() && arr[idx.peek()]>=arr[i]){
                idx.pop();
            }
            if(!idx.isEmpty()){
                next[i]=idx.peek();
            }
            idx.push(i);
        }
        return next;
    }
    public int sumSubarrayMins(int[] arr) {
        long sum=0;
        int n=arr.length;
         int[] nse=findNextLessOrEq(arr);
        int[] pse=findPrevLess(arr);
        for(int i=0;i<n;i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            sum=sum+(left*right*arr[i]);
        }
        return (int)(sum % 1_000_000_007);
    }
}