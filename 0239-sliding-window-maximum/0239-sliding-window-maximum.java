class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new ArrayDeque<>();
        int[] list=new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.getFirst()<=i-k){
                dq.removeFirst();

            }
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                list[idx++]=nums[dq.getFirst()];
            }
        }
        return list;

    }
}