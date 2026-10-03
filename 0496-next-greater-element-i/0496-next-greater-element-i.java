import java.util.Arrays;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        int smaller=0;
        int[] ans=new int[nums1.length];
        Arrays.fill(ans, -1);
        for(int i=0;i<nums2.length;i++){
            while(!st.isEmpty() && nums2[i]>st.peek()){
            
                smaller=st.pop();
                for(int j=0;j<nums1.length;j++){
                    if(nums1[j]==smaller){
                        ans[j]=nums2[i];
                        break;
                    }
                }
            }
            st.push(nums2[i]);
        }
        return ans;
    }
}