class Solution {
    public int[] findnse(int[] arr){
        int n=arr.length;
        int[] next=new int[n];
        Arrays.fill(next,n);
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                next[i]=st.peek();
            }
            st.push(i);
        }
        return next;
    }

    public int[] findpse(int[] arr){
        int n=arr.length;
        int[] prev=new int[n];
        Arrays.fill(prev,-1);
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                prev[i]=st.peek();
            }
            st.push(i);
        }
        return prev;
    }
    public long subArrayMin(int[] nums){
        int[] prev=findpse(nums);
        long sum=0;
        int[] next=findnse(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            long left=i-prev[i];

            long right=next[i]-i;
            sum=sum+(left*right*nums[i]);
        }
        return sum;
    }

    public int[] findnge(int[] arr){
        int n=arr.length;
        int[] next=new int[n];
        Arrays.fill(next,n);
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                next[i]=st.peek();
            }
            st.push(i);
        }
        return next;
    }

    public int[] findpge(int[] arr){
        int n=arr.length;
        int[] prev=new int[n];
        Arrays.fill(prev,-1);
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                prev[i]=st.peek();
            }
            st.push(i);
        }
        return prev;
    }
    public long subArrayMax(int[] nums){
        int[] prev=findpge(nums);
        long sum=0;
        int[] next=findnge(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            long left=i-prev[i];

            long right=next[i]-i;
            sum=sum+(left*right*nums[i]);
        }
        return sum;
    }

    public long subArrayRanges(int[] nums) {
        long ans =subArrayMax(nums)-subArrayMin(nums);
        return ans;
    }
}